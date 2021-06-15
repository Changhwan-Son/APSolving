package jun.week3;

import java.io.*;
import java.util.*;

public class BOJ_17141_연구소2 {

	static int N, M, can, blank, answer = Integer.MAX_VALUE;
	static int[][] map, tmp;
	static int[][] canVirus;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		tmp = new int[N][N];
		canVirus = new int[N*N][2];
		can = 0;
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0 ; j < N ;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					canVirus[can][0] = i;
					canVirus[can][1] = j;
					can++;
				}
				if(map[i][j] == 0)
					blank++;
			}
		}
		blank += can - M;
		
		if(blank == 0)
			answer = 0;
		else
			perm(new boolean[can], 0, 0);
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}
	
	static void bfs(int[][] map, int count, boolean[] visited) {
		Queue<int[]> queue = new LinkedList<>();
		for(int i = 0 ; i < can; i++) {
			if(visited[i])
				queue.add(new int[] {canVirus[i][0], canVirus[i][1]});
		}
		
		int time = 0 ;
		int mx,my;
		while(!queue.isEmpty()) {
			if(time >= answer)
				break;
			
			int t = queue.size();
			for(int i = 0 ; i < t ; i++) {
				int x = queue.peek()[0];
				int y = queue.poll()[1];
				
				for(int j = 0 ; j < 4; j++) {
					mx = x + dx[j];
					my = y + dy[j];
					if( mx < 0 || my < 0 || mx >= N || my>= N || map[mx][my] != 0)
						continue;
					
					map[mx][my] = 2;
					queue.add(new int[] {mx,my});
					count--;
				}
			}
			time++;
			if(count == 0) {
				answer = time;
				return;
			}
		}
	}
	
	static void perm(boolean[] visited, int count, int start) {
		if(count == M) {
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N; j++) {
					tmp[i][j] = map[i][j];
				}
			}
			for(int i = 0 ; i < can ; i++) {
				if(!visited[i]) {
					tmp[canVirus[i][0]][canVirus[i][1]] = 0;
				}
			}
			
			bfs(tmp, blank, visited);
			return;
		}
		
		for(int i = start ; i < can; i++) {
			visited[i] = true;
			perm(visited, count + 1, i+1);
			visited[i] = false;
		}
	}
}
