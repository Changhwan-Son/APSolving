package apr.week3;

import java.io.*;
import java.util.*;

public class SWEA_5643_키순서1 {

	static int N, M, adj[][];
	static int gtCnt, ltCnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(in.readLine());
			M = Integer.parseInt(in.readLine());
			adj = new int[N+1][N+1];

			StringTokenizer st = null;
			int i, j;
			for(int m = 0 ; m < M; m++) {
				st = new StringTokenizer(in.readLine());
				i = Integer.parseInt(st.nextToken());
				j = Integer.parseInt(st.nextToken());
				adj[i][j] = 1;
			}

			int answer = 0;
			for(int k = 1; k <= N; k++) {
				gtCnt =	ltCnt = 0;
				gtBFS(k, new boolean[N+1]);
				ltBFS(k, new boolean[N+1]);
				if(gtCnt + ltCnt == N - 1)
					answer++;
			}
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	static void gtBFS(int start, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int k = queue.poll(); 
			for(int i = 1 ; i <= N ; i++) {
				if(!visited[i]&& adj[k][i] == 1) {
					queue.offer(i);
					visited[i] = true;
					gtCnt++;
				}
			}
		}
		
	}
	
	static void ltBFS(int start, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int k = queue.poll(); 
			for(int i = 1 ; i <= N ; i++) {
				if(!visited[i]&& adj[i][k] == 1) {
					queue.offer(i);
					visited[i] = true;
					ltCnt++;
				}
			}
		}
		
	}
}
