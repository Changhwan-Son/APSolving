package aug.week4;

import java.io.*;
import java.util.*;

public class BOJ_1138_한줄로서기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());

		int[] people = new int[N + 1];
		List<Integer> list = new ArrayList<Integer>();

		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 1; i <= N; i++)
			people[i] = Integer.parseInt(st.nextToken());

		for(int i = N ; i > 0; i--) {
			list.add(people[i], i);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < N ;i++) {
			sb.append(list.get(i)).append(" ");
		}
		System.out.println(sb);
	}
}
