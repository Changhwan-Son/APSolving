package apr.week2;

import java.io.*;
import java.util.*;

public class BOJ_14496_그대그머가되어 {

	static int[] distance;
	static ArrayList<Integer>[] list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		distance = new int[1001];
		list = new ArrayList[1001];

		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
			distance[i] = 1000000000;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			if (n1 != n2) {
				list[n1].add(n2);
				list[n2].add(n1);
			}
		}

		dij(a);

		if (distance[b] == 1000000000)
			System.out.println(-1);
		else
			System.out.println(distance[b]);
	}

	static void dij(int start) {
		Queue<int[]> q = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
		distance[start] = 0;
		q.offer(new int[] {start, 0});
		
		while(!q.isEmpty()) {
			int cur = q.peek()[0];
			int dis = q.poll()[1];
			
			if(distance[cur] < dis)
				continue;
			
			for(int next: list[cur]) {
				if(distance[next] > dis + 1) {
					distance[next] = dis + 1;
					q.offer(new int[] {next, dis + 1});
				}
			}
		}
	}
	
}
