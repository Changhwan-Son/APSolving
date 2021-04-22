package apr.week3;

import java.io.*;
import java.util.StringTokenizer;

public class fail_SWEA_3238_이항계수구하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int testCase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testCase; t++) {
			st = new StringTokenizer(br.readLine());
			long N = Long.parseLong(st.nextToken());
			long K = Long.parseLong(st.nextToken());
			long P = Integer.parseInt(st.nextToken());

			long[] fact = new long[(int) P];
			long rst = 1;

			fact[0] = 1;
			for (int i = 1; i < P; i++) {
				fact[i] = fact[i - 1] * i;
				fact[i] %= P;
			}

			while (N != 0 || K != 0) {
				int n = (int) (N % P);
				int k = (int) (K % P);

				if (n < k) {
					rst = 0;
					break;
				}

				long a = (rst * fact[n]) % P;
				long b = pow((fact[n - k] * fact[k]) % P, P - 2, P) % P;

				rst = (a * b) % P;

				N /= P;
				K /= P;
			}

			sb.append("#").append(t).append(" ").append(rst).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();

	}

	public static long pow(long x, long y, long P) {
		if (y == 0)
			return 1;
		else if (y == 1)
			return x;

		if (y % 2 == 0) {
			long temp = pow(x, y / 2, P);
			return (temp * temp) % P;
		}
		long temp = pow(x, y - 1, P) % P;

		return (temp * x) % P;
	}

}
