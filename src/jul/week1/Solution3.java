package jul.week1;

public class Solution3 {
	static int[] fail;
	static String str, target;

	public int solution(String s, String t) {
		int result = 0;
		str = s;
		target = t;

		fail = new int[t.length()];
		failure();

		while (kmp()) {
			result++;
		}
		return result;
	}

	static boolean kmp() {
		int m = 0;
		int begin = 0; // 실패 함수와 다르게 KMP에서는 두 문자열 모두 처음부터 비교를 시작

		while (begin + m < str.length()) {
			if (str.charAt(begin + m) == target.charAt(m)) { // 두 문자가 같으면, m을 1 증가
				m++;
				if (m >= target.length()) { // m이 s2의 길이와 같다는 말은, s1에서 s2를 발견했다는 뜻
					str = str.substring(0, begin) + str.substring(begin + m);
					return true;
				}
			} else { // 두 문자가 다르면, fail 배열을 확인해서 s2를 우측으로 이동
				if (m == 0) {
					begin++;
				} else {
					begin += m - fail[m - 1];
					m = fail[m - 1];
				}
			}
		}
		return false;
	}

	static void failure() {
		int m = 0;
		int begin = 1;

		while (begin + m < target.length()) {
			if (target.charAt(begin + m) == target.charAt(m)) {
				m++;
				fail[begin + m - 1] = m;
			} else {
				if (m == 0) {
					begin++;
				} else {
					begin += m - fail[m - 1];
					m = fail[m - 1];
				}
			}
		}
	}
}