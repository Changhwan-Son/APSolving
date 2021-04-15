package apr.week2;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA_3813_그래도수명 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());
		StringTokenizer st = null;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[] arr = new int[N];
			st = new StringTokenizer(in.readLine());
			for(int i = 0 ; i < N; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			
			int[] data = new int[K];
			st = new StringTokenizer(in.readLine());
			for(int i = 0 ; i < N; i++)
				data[i] = Integer.parseInt(st.nextToken());
			
			
			System.out.println("#" + tc + " " );
		}
	}
}
