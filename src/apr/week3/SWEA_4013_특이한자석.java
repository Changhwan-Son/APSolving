package apr.week3;

import java.io.*;
import java.util.*;

public class SWEA_4013_특이한자석 {
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {

			int K = Integer.parseInt(in.readLine());
			arr = new int[4][8];
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < 8; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			Queue<int[]> q = new LinkedList<int[]>();
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(in.readLine());
				int num = Integer.parseInt(st.nextToken()) - 1;
				int d = Integer.parseInt(st.nextToken());
				q.offer(new int[] { num, d });

				int idx = 1;
				while (num - idx >= 0) {
					if (arr[num - idx + 1][6] != arr[num - idx][2])
						q.offer(new int[] { num - idx, (int) (Math.pow((-1), idx) * d) });
					else
						break;
					idx++;
				}

				idx = 1;
				while (num + idx < 4) {
					if (arr[num + idx - 1][2] != arr[num + idx][6])
						q.offer(new int[] { num + idx, (int) (Math.pow((-1), idx) * d) });
					else
						break;
					idx++;
				}

				while (!q.isEmpty()) {
					rotate(q.peek()[0], q.poll()[1]);
				}

			}

			int sum = 0;
			for (int i = 0; i < 4; i++) {
				if (arr[i][0] == 1)
					sum += (int) Math.pow(2, i);
			}

			System.out.println("#" + tc + " " + sum);
		}
	}

	static void rotate(int n, int d) {
		if (d == 1) {
			int tmp = arr[n][7];
			for (int i = 7; i > 0; i--) {
				arr[n][i] = arr[n][i - 1];
			}
			arr[n][0] = tmp;
		} else {
			int tmp = arr[n][0];
			for (int i = 0; i < 7; i++) {
				arr[n][i] = arr[n][i + 1];
			}
			arr[n][7] = tmp;
		}
	}

}
