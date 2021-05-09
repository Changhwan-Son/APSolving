package may.week1;
/*
 * 2021 K 인턴십 코딩테스트 
 */
public class Solution1 {
	public int solution(String s) {
		int answer = 0;

		StringBuilder sb = new StringBuilder();
		int len = s.length();
		for (int i = 0; i < len; i++) {
			char c = Character.toLowerCase(s.charAt(i));

			if (c > '9') {
				if (c == 'z') {
					sb.append('0');
					i += 3;
				} else if (c == 'o') {
					sb.append('1');
					i += 2;
				} else if (c == 'e') {
					sb.append('8');
					i += 4;
				} else if (c == 'n') {
					sb.append('9');
					i += 3;
				} else if (c == 't') {
					if (s.charAt(i + 1) == 'h') {
						sb.append('3');
						i += 4;
					} else {
						sb.append('2');
						i += 2;
					}
				} else if (c == 'f') {
					if (s.charAt(i + 1) == 'o') {
						sb.append('4');
						i += 3;
					} else {
						sb.append('5');
						i += 3;
					}
				} else if (c == 's') {
					if (s.charAt(i + 1) == 'e') {
						sb.append('7');
						i += 4;
					} else {
						sb.append('6');
						i += 2;
					}
				}
			} else {
				sb.append(c);
			}
		}

		answer = Integer.parseInt(sb.toString());
		return answer;
	}
}
