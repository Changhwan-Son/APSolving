package apr.week2;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA_3951_CRT {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for(int tc = 1; tc <= T ; tc++) {
			int N = Integer.parseInt(in.readLine());
			int[][] arr = new int[N][2];
			
			for(int i = 0 ; i < N ; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			int num =0;
			while(true) {
				boolean check = true;
				for(int i = 0 ; i < N; i++) {
					if(num % arr[i][1] != arr[i][0]) {
						check = false;
						break;
					}
				}
				if(check) {
					break;
				}
				num++;
			}
			
			System.out.println("#" + tc + " " + num);
			
		}
	}
}
