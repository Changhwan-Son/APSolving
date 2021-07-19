package jul.week3;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1477_휴게소세우기 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] rest = new int[N+2];
		st = new StringTokenizer(in.readLine());
		rest[0] = 0;
		rest[N+1] = L;
		for(int i = 1 ; i <= N ; i++)
			rest[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(rest);
		
		int left = 0;
		int right = L; 
		
		while(left <= right) {
			int mid = (left + right) / 2;
			int cnt = 0;
			
			for(int i = 1 ; i <= N + 1 ; i++)
				cnt += (rest[i] - rest[i-1] - 1) / mid;
			
			if(cnt > M)
				left = mid + 1;
			else
				right = mid - 1;
		}
		
		System.out.println(left);
	}
}
