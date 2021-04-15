package apr.week2;

import java.io.*;
import java.util.*;

public class SWEA_3927_가장짧은길전부청소 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
		int T = Integer.parseInt(in.readLine());
		StringTokenizer st = null;
		for(int tc = 1; tc <= T ; tc++) {
			st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] visited = new int[N+1];
			int[] load = new int[N+1];
			PriorityQueue<int[]>[] edges = new PriorityQueue[N+1];
			for(int i = 0 ; i <= N; i++)
				edges[i] = new PriorityQueue<>(new Comparator<int[]>() {

					@Override
					public int compare(int[] o1, int[] o2) {
						return o1[1] - o2[1];
					}
				});
			
			for(int i = 0 ; i < M ; i++) {
				st = new StringTokenizer(in.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				edges[u].add(new int[] {v, w});
				edges[v].add(new int[] {u, w});
			}
			
			int answer = 0;
			for(int i = 1 ; i <= N; i++) {
				System.out.println(edges[i].peek()[1]);
				answer += edges[i].poll()[1];
			}
			
			System.out.println("#" + tc + " " + answer);
		}
	}
}
