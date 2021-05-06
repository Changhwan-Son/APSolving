package may.week1;

import java.io.*;
import java.util.ArrayList;

public class fail_PRO_수식최대화 {

	static long answer;

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		solution(in.readLine());
	}

	public static long solution(String expression) {
		answer = 0;

		int len = expression.length();
		ArrayList<Long> list = new ArrayList<>();
		ArrayList<Character> act = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			char c = expression.charAt(i);
			if (c == '*' || c == '-' || c == '+') {
				list.add(Long.parseLong(sb.toString()));
				sb = new StringBuilder();
				act.add(c);
			} else {
				sb.append(c);
			}
		}
		list.add(Long.parseLong(sb.toString()));

		boolean[] visited = new boolean[3];
		for (int i = 0; i < 3; i++) {

			visited[i] = true;
			func(new ArrayList<>(list), new ArrayList<>(act), i, 0, visited);
			visited[i] = false;
		}

		System.out.println(answer);
		return answer;
	}

	static void func(ArrayList<Long> list, ArrayList<Character> act, int op, int cnt, boolean[] visited) {

		if (list.size() == 1) {
			answer = Math.max(Math.abs(list.get(0)), answer);
			return;
		}

		int len = act.size();

		if(op == 0) {
			for(int i =0;i< len; i++) {
				if(act.get(i) == '+') {
					list.add(i, list.remove(i) + list.remove(i));
					act.remove(i);
					len--;
					i--;
				}
			}
		} else if(op == 1) {
			for(int i =0; i< len; i++) {
				if(act.get(i) == '-') {
					list.add(i, list.remove(i) - list.remove(i));
					act.remove(i);
					len--;
					i--;
				}
			}
		} else if(op == 2) {
			for(int i =0;i< len; i++) {
				if(act.get(i) == '*') {
					list.add(i, list.remove(i) * list.remove(i));
					act.remove(i);
					len--;
					i--;
				}
			}
		}

		for (int i = 0; i < 3; i++) {
			if (!visited[i]) {
				visited[i] = true;
				func(list, act, i, cnt + 1, visited);
				visited[i] = false;
			}
		}

	}

}
