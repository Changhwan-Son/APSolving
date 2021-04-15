package apr.week2;

import java.io.*;
import java.util.*;

public class SWEA_3820_롤러코스터 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1 ; tc <= T ; tc++) {
			int n = Integer.parseInt(in.readLine());
			StringTokenizer st = null;
			
			int[][] list = new int[n][2];
			for(int i = 0 ; i < n ; i++) {
				st = new StringTokenizer(in.readLine());
				list[i][0] = Integer.parseInt(st.nextToken());
				list[i][1] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(list, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					int diff = o2[0] * o1[1] + o2[1] - o1[0] * o2[1] - o1[1];
					return diff;
				}
			});
			
			int answer = 1;
			for(int i = 0 ; i < n ; i++) {
				answer = answer * list[i][0] + list[i][1];
				answer %= 1000000007;
			}
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
}
