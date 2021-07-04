package jul.week1;

import java.util.*;

class Solution2 {
	static ArrayList<String> left;
	static String str;

	public static void main(String[] args) {
		solution("abcxyqwertyxyabc");
	}

	public static String[] solution(String s) {
		String[] answer = {};
		left = new ArrayList<>();
		str = s;

		while (func()) {

		}

		int len = left.size();
		if (str.length() != 0) {
			answer = new String[len * 2 + 1];
			for (int i = 0; i < len; i++) {
				answer[i] = left.get(i);
				answer[len * 2 - i] = left.get(i);
			}
			answer[len] = str;
		} else {
			answer = new String[len * 2];
			for (int i = 0; i < len; i++) {
				answer[i] = left.get(i);
				answer[len * 2 - i - 1] = left.get(i);
			}
		}

		for (int i = 0; i < answer.length; i++)
			System.out.println(answer[i]);

		return answer;
	}

	public static boolean func() {
		int len = str.length();
		for (int i = 1; i < len; i++) {
			String tmp = str.substring(0, i);

			if (tmp.equals(str.substring(len - i, len))) {
				left.add(tmp);
				// System.out.println(str);
				str = str.substring(i, len - i);
				return true;
			}
		}
		return false;
	}
}