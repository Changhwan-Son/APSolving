package aug.week2;

import java.io.*;
import java.util.Stack;

public class BOJ_6198_옥상정원꾸미기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		long answer = 0;
		
		Stack<Long> stack = new Stack<>();

		for(int i = 0 ; i < N ; i++) {
			long n = Integer.parseInt(in.readLine());
			
			while(!stack.isEmpty()) {
				if(stack.peek() <= n) {
					stack.pop();
				} else { 
					break;
				}
			}
			answer += stack.size();
			stack.add(n);
		}
		
		System.out.println(answer);
		
	}
}
