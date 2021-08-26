package aug.week4;

import java.io.*;
import java.util.*;

public class BOJ_2583_영역구하기 {
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0 ,-1, 0};
	static List<Integer> list;
	static boolean[][] map;
	static int M, N, K, max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new boolean[M][N];
		for(int i = 0 ; i < K ; i++) {
			st = new StringTokenizer(in.readLine());
			int lx = Integer.parseInt(st.nextToken());
			int ly = Integer.parseInt(st.nextToken());
			int rx = Integer.parseInt(st.nextToken());
			int ry = Integer.parseInt(st.nextToken());
			
			for(int y = lx; y < rx; y++) {
				for(int x = ly ; x < ry ; x++) {
					map[x][y] = true;
				}
			}
		}
		
		int count = 0;
		list = new ArrayList<>();
		for(int i = 0 ; i < M ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(!map[i][j]) {
					max = 0;
					count++;
					map[i][j] = true;
					func(i, j);
					list.add(max);
				}
			}
		}
		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		sb.append(count).append("\n");
		for(int i = 0 ; i < list.size(); i++)
			sb.append(list.get(i)).append(" ");
		
		System.out.println(sb);
		
	}
	
	static void func(int x, int y) {
		max++;
		
		for(int i = 0 ; i < 4; i++) {
			int mx = x + dx[i];
			int my = y + dy[i];
			
			if(mx < 0 || my < 0 || mx >= M || my >= N)
				continue;
			
			if(map[mx][my])
				continue;
			
			map[mx][my] = true;
			func(mx, my);
		}
	}
}
