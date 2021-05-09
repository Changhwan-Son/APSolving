package may.week1;
/*
 * 2021 K 인턴십 코딩테스트 
 */
import java.util.LinkedList;
import java.util.Stack;

public class Solution3 {
	public String solution(int n, int k, String[] cmd) {
		LinkedList<Integer> list = new LinkedList<>();
		Stack<int[]> stack = new Stack<>();
		for (int i = 0; i < n; i++)
			list.add(i);

		int idx = k;
		int len = cmd.length;
		for (int i = 0; i < len; i++) {
			char c = cmd[i].charAt(0);

			switch (c) {
			case 'U': {
				idx -= cmd[i].charAt(2) - '0';
				break;
			}
			case 'D': {
				idx += cmd[i].charAt(2) - '0';
				break;
			}
			case 'C': {
				stack.push(new int[] { idx, list.get(idx) });
				list.remove(idx);
				if (idx == list.size())
					idx--;
				break;
			}
			case 'Z': {
				if (stack.peek()[0] <= idx)
					idx++;

				list.add(stack.peek()[0], stack.pop()[1]);
				break;
			}
			}
		}

		boolean[] check = new boolean[n];
		for (Integer i : list) {
			check[i] = true;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			if (check[i])
				sb.append('O');
			else
				sb.append('X');
		}

		return sb.toString();
	}
}
