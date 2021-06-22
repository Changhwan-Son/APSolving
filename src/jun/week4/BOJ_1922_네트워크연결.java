package jun.week4;

import java.io.*;
import java.util.*;

public class BOJ_1922_네트워크연결 {
	
	static class Edge implements Comparable<Edge> {
		int from, to, weight; 
		
		Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
	}

	static int N, M;
	static int[] parents;
	static Queue<Edge> edgeList;
	
	static void make() {
		for(int i = 1 ; i <= N ; i++)
			parents[i] = i;
	}
	
	static int findSet(int a) {
		if(parents[a] == a)
			return a;
		
		return parents[a] = findSet(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot)
			return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(in.readLine());
		M = Integer.parseInt(in.readLine());
		
		parents = new int[N+1];
		edgeList = new PriorityQueue<Edge>();
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(in.readLine());
			edgeList.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		
		make();
		
		int answer = 0;
		int count = 0;
		while(!edgeList.isEmpty()) {
			Edge edge = edgeList.poll();
			if(union(edge.from, edge.to)) {
				answer += edge.weight;
				if(++count == N - 1)
					break;
			}
		}
		
		System.out.println(answer);
	}
}
