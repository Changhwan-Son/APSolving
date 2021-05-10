package may.week2;

import java.io.*;
import java.util.*;

public class BOJ_2075_N번째큰수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
		
		int N =Integer.parseInt(in.readLine());
		int[][] map = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st= new StringTokenizer(in.readLine());
			for(int j= 0 ;j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[0] - o1[0];
			}
		});
		
		for(int i = 0 ; i < N;i++) {
			pq.add(new int[] {map[N-1][i],N-1,i});
		}
		
		int cnt = 0;
		int max = 0;
		while(cnt < N) {
			max = pq.peek()[0];
			int curi = pq.peek()[1];
			int curj = pq.poll()[2];
			
			if(curi > 0)
				pq.add(new int[] {map[curi-1][curj], curi-1, curj});
			cnt++;
		}
		
		System.out.println(max);
	}
}
