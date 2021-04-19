package apr.week3;

import java.io.*;
import java.util.StringTokenizer;

public class fail_SWEA_3238_이항계수구하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			long N = Long.parseLong(st.nextToken());
			long R = Long.parseLong(st.nextToken());
			long P = Long.parseLong(st.nextToken());

			System.out.println("#" + tc + " " + nCr(N % P, R % P, P));
		}
	}

	static long nCr(long n, long r, long p) {
		if (r == 0)
			return 1L;

		long[] fac = new long[(int) (n + 1)];
		fac[0] = 1;

		for (int i = 1; i <= n; i++)
			fac[i] = fac[i - 1] * i % p;

		return (fac[(int) n] * power(fac[(int) r], p - 2, p) % p * power(fac[(int) (n - r)], p - 2, p) % p) % p;
	}

	static long power(long x, long y, long p) {
		long res = 1L;
		x = x % p;

		while (y > 0) {
			if (y % 2 == 1)
				res = (res * x) % p;
			y = y >> 1;
			x = (x * x) % p;
		}
		return res;
	}
}
