package jul.week2;

import java.io.*;

public class BOJ_1342_행운의문자열 {

	static int len, answer;
	static boolean[] visited;
	static char[] list;
	static String S;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		S = in.readLine();

		int[] alpha = new int[26];
		
		answer = 0;
		len = S.length();
		list = new char[len];
		visited = new boolean[len ];
		
		for(int i = 0 ; i < len ; i++) {
			alpha[S.charAt(i) - 'a']++;
		}
		
		dfs(0);
		
		for(int i = 0 ; i < 26; i++) {
			if(alpha[i] > 1)
				answer /= func(alpha[i]);
		}
		System.out.println(answer);

	}
	static int func(int a) {
		if(a == 1)
			return 1;
		
		return a * func(a - 1);
	}
	
	
	static void dfs(int cnt) {
		if(cnt == len) {
			for(int i = 0 ; i < len - 1; i++) {
				if(list[i] == list[i+1])
					return;
			}
			
			answer++;
			return;
		}
		
		for(int i = 0 ; i < len ; i++) {
			if(!visited[i]) {
				visited[i] = true;
				list[cnt] = S.charAt(i);
				dfs(cnt+1);
				visited[i] = false;
			}
		}
	}

}
