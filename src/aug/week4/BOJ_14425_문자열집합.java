package aug.week4;

import java.io.*;
import java.util.*;

public class BOJ_14425_문자열집합 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int count = 0;

		Map<String,Integer> map = new HashMap<String, Integer>();

		for (int i = 0; i < N; i++) {
			map.put(in.readLine(), 1);
		}

		for (int i = 0; i < M; i++) {
			if(map.get(in.readLine()) != null)
				count++;
		}
		
		System.out.println(count);
	}
}
