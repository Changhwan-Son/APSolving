package apr.week4;

import java.io.*;
import java.util.*;

public class BOJ_1766_문제집 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(in.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] arr = new ArrayList[N+1];
		int[] links = new int[N+1];
		for(int i = 1; i <= N; i++)
			arr[i] = new ArrayList<>();
		
		for(int i = 0 ; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			arr[n1].add(n2);
			links[n2]++;
		}
		
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 1; i <= N; i++) {
			if(links[i] == 0)
				pq.offer(i);
		}
		
		while(!pq.isEmpty()) {
			int cur = pq.poll();
			sb.append(cur).append(" ");
			
			for(int n : arr[cur]) {
				links[n]--;
				
				if(links[n] == 0)
					pq.offer(n);
			}
		}
		System.out.println(sb);
	}
}