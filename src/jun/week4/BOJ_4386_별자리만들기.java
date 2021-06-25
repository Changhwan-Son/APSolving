package jun.week4;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_4386_별자리만들기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int n = Integer.parseInt(in.readLine());
		
		double[][] points= new double[n][2];
		for(int i = 0 ; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			points[i][0] = Double.parseDouble(st.nextToken());
			points[i][1] = Double.parseDouble(st.nextToken());
		}
		
		double[][] matrix = new double[n][n];
		double[] minEdge = new double[n];
		boolean[] visited = new boolean[n];
		
		// 비용 구하기 
		for(int i = 0; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				matrix[i][j] = Math.sqrt(Math.pow(points[i][0] - points[j][0], 2) + Math.pow(points[i][1] - points[j][1], 2));
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
			minEdge[i] = Double.MAX_VALUE;
		}
		
		double result = 0;
		minEdge[0] = 0;
		
		for(int c = 0 ; c < n; c++) {
			double min = Double.MAX_VALUE;
			int minNum = 0;
			
			for(int i = 0 ; i < n ; i++) {
				if(!visited[i] && min > minEdge[i]) {
					min = minEdge[i];
					minNum = i;
				}
			}
			
			result += min;
			visited[minNum] = true;
			
			for(int i = 0 ; i < n; i++) {
				if(!visited[i] && matrix[minNum][i] != 0 && minEdge[i] > matrix[minNum][i])
					minEdge[i] = matrix[minNum][i];
			}
		}
		
		System.out.printf("%.2f", result);
		
	}
}
