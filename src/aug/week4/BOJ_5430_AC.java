package aug.week4;

import java.io.*;
import java.util.*;

public class BOJ_5430_AC {

	static List<Integer> list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());

		for (int t = 0; t < T; t++) {
			String p = in.readLine();
			int n = Integer.parseInt(in.readLine());
			list = new ArrayList<>();

			StringTokenizer st = new StringTokenizer(in.readLine(), "[],");
			for (int i = 0; i < n; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			boolean flag = false;
			boolean idx = false;
			int head = 0;
			int tail = n - 1;

			int len = p.length();
			for (int i = 0; i < len; i++) {

				if (p.charAt(i) == 'R') {
					idx = !idx;
				} else {
					if (head > tail) {
						sb.append("error").append("\n");
						flag = true;
						break;
					}

					if (!idx)
						head++;
					else
						tail--;
				}
			}

			if (flag)
				continue;

			sb.append("[");
			if (idx && head <= tail) {
				for (int i = tail; i > head; i--) {
					sb.append(list.get(i)).append(",");
				}
				sb.append(list.get(head));
			} else if (head <= tail) {
				for (int i = head; i < tail; i++) {
					sb.append(list.get(i)).append(",");
				}
				sb.append(list.get(tail));
			}

			sb.append("]\n");
		}
		System.out.println(sb);
	}

}
