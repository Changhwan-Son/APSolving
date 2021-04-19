package apr.week3;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ_1339_단어수학 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int[] alpha = new int[26];
		String[] strs = new String[N];
		for(int i = 0 ; i < N ; i++) {
			strs[i] = in.readLine();
			int len = strs[i].length();
			for(int j = 0 ; j < len ; j++) {
				char c = strs[i].charAt(j);
				alpha[c - 'A'] += (int)Math.pow(10, len - 1 - j);
			}
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[1] - o1[1];
			}
		});
		
		
		for(int i = 0 ; i < 26 ; i++) {
			if(alpha[i] != 0)
				pq.add(new int[] {i, alpha[i]});
		}
		
		int num = 9;
		while(!pq.isEmpty()) {
			int idx = pq.poll()[0];
			alpha[idx] = num--;
		}
		
		int sum = 0;
		for(int i = 0 ; i < N ; i++) {
			int len = strs[i].length();
			for(int j = 0 ; j < len ; j++) {
				char c = strs[i].charAt(j);
				sum += alpha[c - 'A'] * (int)Math.pow(10, len - 1 - j);
			}
		}
		
		System.out.println(sum);
	}
}
