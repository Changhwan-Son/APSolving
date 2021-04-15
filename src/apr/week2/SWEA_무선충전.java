package apr.week2;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA_무선충전 {
	static int[] dx = {0, -1, 0, 1, 0};
	static int[] dy = {0, 0, 1, 0, -1};
	static class BC {
		int x, y, C, P;
		public BC(int x, int y, int C, int P) {
			this.x = x;
			this.y = y;
			this.C = C;
			this.P = P;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(in.readLine());
		StringTokenizer st = null;
		for(int t = 1 ; t <= tc ; t++) {
			st = new StringTokenizer(in.readLine());
			int M = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			int[] ma = new int[M];
			int[] mb = new int[M];
			
			st = new StringTokenizer(in.readLine());
			for(int i = 0 ; i < M ; i++)
				ma[i] = Integer.parseInt(st.nextToken());
			
			for(int i = 0 ; i < M ; i++)
				mb[i] = Integer.parseInt(st.nextToken());
			
			BC[] bcs = new BC[A];
			for(int i = 0 ; i < A ; i++) {
				st = new StringTokenizer(in.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());
				int P = Integer.parseInt(st.nextToken());
				bcs[i] = new BC(x, y, C, P);
			}
			
			int[] aPos = {1,1};
			int[] bPos = {10,10};
			
			for(int i = 0 ; i < M; i++) {
				int aMax = 0;
				int aIdx = -1;
				for(int j = 0 ; j < A; j++) {
					if(bcs[j].C >= Math.abs(bcs[j].x - aPos[0]) + Math.abs(bcs[j].y - aPos[1])) {
						if(aMax < bcs[j].P) {
							aMax = bcs[j].P;
							aIdx = j;
						}
					}
				}
				
				
				
			}
		}
	}
}
