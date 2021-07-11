package jul.week2;

import java.io.*;
import java.util.*;

public class BOJ_1446_지름길 {

	static class Road implements Comparable<Road> {
		int start, end, weight;

		Road(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Road o) {
			int diff = this.start - o.start;
			if (diff == 0)
				diff = this.end - o.end;
			return diff;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		List<Road> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list.add(new Road(start, end, weight));
		}

		Collections.sort(list);

		int[] distance = new int[10001];
		Arrays.fill(distance, 10001);
		distance[0] = 0;

		int idx = 0, cur = 0;
		while (cur < D) {
			if(idx < list.size()) {
				Road r = list.get(idx);
				if(cur == r.start) {
					distance[r.end] = Math.min(distance[cur] + r.weight,distance[r.end]);
					idx++;
				} else {
					distance[cur+1] = Math.min(distance[cur+1], distance[cur] + 1);
					cur++;
				}
			} else {
				distance[cur + 1] = Math.min(distance[cur + 1], distance[cur] + 1);
				cur++;
			}
		}
		System.out.println(distance[D]);
	}

}
