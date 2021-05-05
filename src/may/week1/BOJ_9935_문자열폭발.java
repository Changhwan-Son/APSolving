package may.week1;

import java.io.*;
import java.util.Stack;

public class BOJ_9935_문자열폭발 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		Stack<Character> stack = new Stack<>();
		String str = in.readLine();
		String bomb = in.readLine();
		StringBuilder sb = new StringBuilder();
		int len = str.length();
		int blen = bomb.length();
		int stSize = 0;
		for (int i = 0; i < len; i++) {
			stack.push(str.charAt(i));

			stSize = stack.size();
			if (stSize >= blen) {
				boolean c = false;
				for (int j = 0; j < blen; j++) {
					if (stack.get(stSize - 1 - j) != bomb.charAt(blen - j - 1)) {
						c = true;
						break;
					}
				}
				if (!c) {
					for (int j = 0; j < blen; j++) {
						stack.pop();
					}
				}
			}
		}

		for (Character c : stack) {
			sb.append(c);
		}

		if (sb.toString().isEmpty()) {
			sb.append("FRULA");
		}
		System.out.println(sb);
	}
}
