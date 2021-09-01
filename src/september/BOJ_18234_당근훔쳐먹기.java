package september;

import java.io.*;
import java.util.*;

public class BOJ_18234_당근훔쳐먹기 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		PriorityQueue<long[]> carrots = new PriorityQueue<>(new Comparator<long[]>() {
			@Override
			public int compare(long[] o1, long[] o2) {
				int diff = (int)(o1[1] - o2[1]);
				if (diff == 0)
					diff = (int)(o1[0] - o2[0]);
				return diff;
			}
		});
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			carrots.add(new long[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		}

		long answer = 0;
		for (int i = 0; i < N; i++) {
			long[] cur = carrots.poll();
			answer += cur[0] + cur[1] * (T - N + i);
		}

		System.out.println(answer);
	}
}
