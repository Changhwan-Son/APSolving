package apr.week3;

import java.io.*;
import java.util.*;

public class BOJ_17822_원판돌리기 {

	static int[][] circle;
	static int[] dx = {1, 0 ,-1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int N, M, T;
	static boolean check;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		circle = new int[N+1][M];
		for(int i = 1 ; i <= N ; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0 ; j < M ; j++) {
				circle[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0 ; i < T ; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			rotate(x, d, k);
		}
		
		System.out.println(getSum());
	}
	
	static int getSum() {
		int sum = 0;
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				sum += circle[i][j];
			}
		}
		return sum;
	}
	
	static void rotate(int x, int d, int k) {
		check = false;
		if(d == 0) {
			for(int i = x ; i <= N; i += x) {
				for(int t = 0 ; t < k ; t++) {
					int tmp = circle[i][M-1];
					for(int j = M-1 ; j > 0 ; j--) {
						circle[i][j] = circle[i][j-1];
					}
					circle[i][0] = tmp;
				}
			}
		} else {
			for(int i = x ; i <= N; i += x) {
				for(int t = 0 ; t < k ; t++) {
					int tmp = circle[i][0];
					for(int j = 0 ; j < M - 1 ; j++) {
						circle[i][j] = circle[i][j+1];
					}
					circle[i][M-1] = tmp;
				}
			}
		}
		
		
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(circle[i][j] != 0)
					bfs(i, j, circle[i][j]);
			}
		}
		
		int tmpSum = 0;
		int tmpCnt = 0;
		if(!check) {
			for(int i = 1 ; i <= N ; i++) {
				for(int j = 0 ; j < M ; j++) {
					if(circle[i][j] != 0) {
						tmpSum += circle[i][j];		
						tmpCnt++;
					}
				}
			}
			double avg = (double)tmpSum / tmpCnt;
			for(int i = 1 ; i <= N ; i++) {
				for(int j = 0 ; j < M ; j++) {
					if(circle[i][j] != 0) {
						if(avg > circle[i][j])
							circle[i][j]++;
						else if(avg < circle[i][j])
							circle[i][j]--;
					}
				}
			}
		}
		
		
	}
	
	static void bfs(int x, int y, int n) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {x, y});
		while(!queue.isEmpty()) {
			int cx = queue.peek()[0];
			int cy = queue.poll()[1];
			for(int i = 0 ; i < 4 ; i++) {
				int mx = cx + dx[i];
				int my = cy + dy[i];
				if(my == -1)
					my = M-1;
				else if(my == M)
					my = 0;
				
				if(mx < 1 || my < 0 || mx > N || my >= M || circle[mx][my] != n)
					continue;
				check = true;
				circle[cx][cy] = 0;
				circle[mx][my] = 0;
				queue.add(new int[] {mx, my});
			}
		}
	}
}
