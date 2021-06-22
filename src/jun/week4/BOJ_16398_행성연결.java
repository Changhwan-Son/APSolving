package jun.week4;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_16398_행성연결 {

	static int N;
	static int[][] matrix;
	static boolean[] visited;
	static int[] minEdge;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		matrix = new int[N][N];
		visited = new boolean[N];
		minEdge = new int[N];

		StringTokenizer st = null;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
			minEdge[i] = Integer.MAX_VALUE;
		}

		int result = 0;
		minEdge[0] = 0;

		for (int c = 0; c < N; c++) {
			int min = Integer.MAX_VALUE; // 최소 가중치
			int minVertex = 0; // 정점 번호
			// 신장 트리에 연결되지 않은 정점들 중 최소 가중치가 최소인 정점 선택
			for (int i = 0; i < N; i++) {
				if (!visited[i] && min > minEdge[i]) {
					min = minEdge[i];
					minVertex = i;
				}
			}

			// 선택된 정점의 최소 가중치 더해주기
			result += min;
			// 신장 트리에 포함됨 체크
			visited[minVertex] = true;

			// 신장 트리와의 최소 가중치 다시 계산
			for (int i = 0; i < N; i++) {
				if (!visited[i] && matrix[minVertex][i] != 0 && minEdge[i] > matrix[minVertex][i]) {
					minEdge[i] = matrix[minVertex][i];
				}
			}
		}
		System.out.println(result);

	}
}
