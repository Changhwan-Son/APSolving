package apr.week2;

import java.io.*;

public class BOJ_3896_소수사이수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int[] arr = new int[1300001];
		
		for(int i = 2; i <= 1300000; i++)
			arr[i] = i;
		
		for(int i = 2; i <= 1300000; i++) {
			if(arr[i] == 0)
				continue;
			
			for(int j = 2 * i; j <= 1300000; j += i)
				arr[j] = 0;
		}
		
		
		int T = Integer.parseInt(in.readLine());
		for (int i = 0; i < T; i++) {
			int k = Integer.parseInt(in.readLine());
			int min = 0;
			int max = 0;
			int j = 0;
			while(arr[k - j] == 0) {
				j++;
				min = k - j;
			}
			
			j = 0;
			while(arr[k + j] == 0) {
				j++;
				max = k + j;
			}
			System.out.println(max - min);
		}
	}
}
