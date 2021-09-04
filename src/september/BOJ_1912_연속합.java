package september;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1912_연속합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(in.readLine());

		StringTokenizer st = new StringTokenizer(in.readLine());

		int max = Integer.MIN_VALUE;
		int cur = 0;
		for (int i = 0; i < n; i++) {
			cur += Integer.parseInt(st.nextToken());
			max = Math.max(max, cur);
			if (cur < 0)
				cur = 0;
		}

		System.out.println(max);

	}
}
