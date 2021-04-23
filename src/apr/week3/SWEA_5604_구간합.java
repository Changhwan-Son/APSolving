package apr.week3;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA_5604_구간합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			long start = Long.parseLong(st.nextToken());
			long end = Long.parseLong(st.nextToken());

			long[] arr = new long[10];
			long answer = 0;
			long place = 1;

			if(start == 0)
				start = 1;
			
			while (start <= end) {
				while (start % 10 != 0 && start <= end) {
					for (long i = start; i > 0; i /= 10) {
						String str = Long.toString(i);
						int t = str.charAt(str.length() - 1) - '0';
						arr[t] += place;
					}
					start++;
				}
				if (start > end)
					break;
				while (end % 10 != 9 && start <= end) {
					for (long i = end; i > 0; i /= 10) {
						String str = Long.toString(i);
						int t = str.charAt(str.length() - 1) - '0';
						arr[t] += place;
					}
					end--;
				}

				long diff = (end / 10) - (start / 10) + 1;
				for (int i = 0; i <= 9; i++)
					arr[i] += diff * place;

				place *= 10;
				start /= 10;
				end /= 10;
			}

			for (int i = 1; i <= 9; i++)
				answer += arr[i] * i;

			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
}
