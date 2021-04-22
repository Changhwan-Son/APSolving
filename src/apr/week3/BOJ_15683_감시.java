package apr.week3;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_15683_감시 {

	static int cctvCnt, answer, N, M;
	static CCTV[] cctvs;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int[][][] cctvDir = {
			{{0}},
			{{1}, {2}, {3}, {0}}, // 1번 cctv
            {{1, 3}, {0, 2}}, // 2번 cctv
            {{0, 1}, {1, 2}, {2, 3}, {3, 0}}, // 3번 cctv
            {{0, 1, 3}, {0, 1, 2}, {1, 2, 3}, {2, 3, 0}}, // 4번 cctv
            {{0, 1, 2, 3}}, // 5번 cctv
	};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		cctvs = new CCTV[8];
		answer = Integer.MAX_VALUE;
		
		int cnt = 0;
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0 ; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] > 0 && map[i][j] < 6)
					cctvs[cctvCnt++] = new CCTV(i, j, map[i][j]);
				
				if(map[i][j] == 0)
					cnt++;
			}
		}
		
		func(0, map, cnt);
		
		System.out.println(answer);
	}
	
	static void func(int idx, int[][] map, int cnt) {
		if(idx == cctvCnt) {
			answer = Math.min(answer, cnt);
			return;
		}
		
		int[][] tmpMap = new int[N][M];
		copyMap(tmpMap,map);
		
		CCTV cur = cctvs[idx];
		
		// 현재 cctv 90도씩 돌면서 감시 
		for(int i = 0 ; i < cctvDir[cur.type].length; i++) {
			
			int rooms = 0;
			// 현재 방향에서 감시할 수 있는 경우 모두 감시 
			for(int j = 0 ; j < cctvDir[cur.type][i].length; j++) {
				int r = cur.r;
				int c = cur.c;
				while(true) {
					r += dr[cctvDir[cur.type][i][j]];
					c += dc[cctvDir[cur.type][i][j]];
					
					if(r < 0 || c < 0 || r >= N || c >= M || tmpMap[r][c] == 6)
						break;
					if(tmpMap[r][c] > 0 || tmpMap[r][c] == -1)
						continue;
					tmpMap[r][c] = -1;
					rooms++;
				}
			}
			func(idx+1, tmpMap, cnt - rooms);
			copyMap(tmpMap, map);
		}
		
	}
	static void copyMap(int[][] tmp, int[][] map) {
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				tmp[i][j] = map[i][j];
			}
		}
	}
	static class CCTV {
		int r, c, type;
		public CCTV(int r, int c, int type) {
			this.r = r;
			this.c = c;
			this.type = type;
		}
	}
}
