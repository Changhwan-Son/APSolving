package apr.week2;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA_3814_평등주의 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1 ; tc <= T ; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[N];
			st = new StringTokenizer(in.readLine());
			for(int i = 0 ; i < N ; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			
			
		}
	}
}
