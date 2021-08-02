package aug.week1;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_2668_숫자고르기 {

	static int N, start;
	static int[] arr;
	static boolean[] visited;
	static ArrayList<Integer> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		arr = new int[N+1];
		visited = new boolean[N+1];
		list = new ArrayList<>();
		
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}
		
		for(int i = 1 ; i <= N; i++) {
			start = i;
			visited[i] = true;
			dfs(i);
			visited[i] = false;
		}
		
		System.out.println(list.size());
		Collections.sort(list);
		for(Integer a : list)
			System.out.println(a);
	
	}
	
	static void dfs(int a) {
		
		if(!visited[arr[a]]) {
			visited[arr[a]] = true;
			dfs(arr[a]);
			visited[arr[a]] = false;
		}
		
		if(arr[a] == start)
			list.add(start);
			
	}
}
