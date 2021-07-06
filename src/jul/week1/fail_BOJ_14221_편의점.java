package jul.week1;

import java.io.*;
import java.util.StringTokenizer;

public class fail_BOJ_14221_편의점 {

	static int n, m;
	static int[][] adjMatrix;
	static int[] distance;
	static boolean[] check;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		adjMatrix = new int[n + 1][n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			adjMatrix[a][b] = c;
		}

		st = new StringTokenizer(in.readLine());
		int h = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int[] answer = new int[h];
		int[] house = new int[h];
		int[] store = new int[s];
		
		st = new StringTokenizer(in.readLine());
		for(int i = 0 ; i < h ; i++) {
			house[i] = Integer.parseInt(st.nextToken());
			answer[i] = Integer.MAX_VALUE;
		}
		
		st = new StringTokenizer(in.readLine());
		for(int i = 0 ; i < s ; i++)
			store[i] = Integer.parseInt(st.nextToken());
		
		int min = Integer.MAX_VALUE;
		int idx = Integer.MAX_VALUE;
		for(int i = 0 ; i < h ; i++) {
			dijkstra(house[i]);
			
			for(int j = 1; j < n + 1 ; j++) {
				if(distance[j] == 0)
					continue;
				
				if(min > distance[j]) {
					min = distance[j];
					idx = house[i];
				}
			}
		}
		
		System.out.println(idx);
	}

	public static void dijkstra(int start) {
		distance = new int[n + 1]; // 최단 거리를 저장할 변수
		check = new boolean[n + 1]; // 해당 노드를 방문했는지 체크할 변수

		// distance 배열 값 최대로 초기화
		for (int i = 1; i < n + 1; i++)
			distance[i] = Integer.MAX_VALUE;

		distance[start] = 0;
		
		for (int i = 1; i < n + 1; i++) {
			int min = Integer.MAX_VALUE;
			int current = 0;

			// 최소값 찾기
			for (int j = 1; j < n + 1; j++) {
				if (!check[j] && distance[j] < min) {
					min = distance[j];
					current = j;
				}
			}

			check[start] = true;
			for(int j = 1 ; j < n + 1; j++) {
				if(!check[j] && adjMatrix[current][j] != 0) {
					if(distance[j] > distance[current] + adjMatrix[current][j]) {
						distance[j] = distance[current] + adjMatrix[current][j];
					}
				}
			}
	
		}

	}
}
