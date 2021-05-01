package apr.week4;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2846_오르막길 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st= new StringTokenizer(in.readLine());
		int[] roads = new int[N];
		
		for(int i = 0 ; i < N; i++)
			roads[i] = Integer.parseInt(st.nextToken());
		
		
		int max = 0;
		int cnt = 0;
		for(int i = 1 ; i < N ; i++) {
			if(roads[i] > roads[i-1]) {
				cnt += roads[i] - roads[i-1];
				max = Math.max(max, cnt);
			} else {
				cnt = 0;
			}
		}
		
		System.out.println(max);
	}
}
