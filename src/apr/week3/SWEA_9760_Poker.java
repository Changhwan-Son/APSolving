package apr.week3;

import java.io.*;
import java.util.*;

public class SWEA_9760_Poker {

	
	static char[] rank = {'A', '2','3','4','5','6','7','8','9','T','J','Q','K', 'A'};
	static char[] kind = {'S', 'H', 'D', 'C'};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc <= T ; tc++) {
			String answer = "High card";
			StringTokenizer st=  new StringTokenizer(in.readLine());
			String[] cards = new String[5];
			for(int i = 0 ; i < 5 ; i++) {
				cards[i] = st.nextToken();
			}
			
			Arrays.sort(cards, new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					return o1.charAt(1) - o2.charAt(1);
				}
			});
			
			int[] cnt_rank = new int[14];
			int[] cnt_kind = new int[4];
			
			for(int i = 0 ; i < 5; i++) {
				for(int j = 0 ; j < 14; j++) {
					if(rank[j] == cards[i].charAt(1))
						cnt_rank[j]++;
				}
				for(int j = 0 ; j < 4 ; j++) {
					if(kind[j] == cards[i].charAt(0))
						cnt_kind[j]++;
				}
			}
			
			int four = 0;
			int tripple = 0;
			int pair = 0;
			int straight = 0;
			int max_straight = 0;
			for(int i = 0 ; i < 14; i++) {
				if(cnt_rank[i] == 1) {
					straight++;
					max_straight = Math.max(max_straight, straight);
				} else {
					straight = 0;
				}
				
				if(i == 13)
					continue;
				
				if(cnt_rank[i] == 2)
					pair++;
				else if(cnt_rank[i] == 3)
					tripple++;
				else if(cnt_rank[i] == 4)
					four++;
			}
			
			boolean flush = false;
			for(int i = 0 ; i < 4 ; i++) {
				if(cnt_kind[i] == 5) {
					flush = true;
				}
			}
			
			if(max_straight == 5) {
				answer = "Straight";
				if(flush) 
					answer = "Straight Flush";
			} else if(flush) {
				answer = "Flush";
			} else if(four == 1) {
				answer = "Four of a Kind";
			} else if(tripple == 1) {
				answer = "Three of a kind";
				if(pair == 1)
					answer = "Full House";
			} else if(pair == 2) {
				answer = "Two pair";
			} else if(pair == 1) {
				answer = "One pair";
			}
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
}
