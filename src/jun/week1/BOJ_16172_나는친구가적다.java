package jun.week1;

import java.io.*;

public class BOJ_16172_나는친구가적다 {

	static int[] pi;
	static String str;
	static String target;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		str = in.readLine();
		target = in.readLine();
		str = str.replaceAll("[0-9]", "");

		int tlen = target.length();
		pi = new int[tlen];
//		failure();
		getPi(target);
		if (kmp())
			System.out.println(1);
		else
			System.out.println(0);
	}

	static boolean kmp() {
		int m = 0; // m = 0으로 초기화
		int begin = 0; // 실패 함수와 다르게 KMP에서는 두 문자열 모두 처음부터 비교를 시작

		while (begin + m < str.length()) {
			if (str.charAt(begin + m) == target.charAt(m)) { // 두 문자가 같으면, m을 1 증가
				m++;
				if (m >= target.length()) { // m이 s2의 길이와 같다는 말은, s1에서 s2를 발견했다는 뜻
					return true;
				}
			} else { // 두 문자가 다르면, fail 배열을 확인해서 s2를 우측으로 이동
				if (m == 0) {
					begin++;
				} else {
					begin += m - pi[m - 1];
					m = pi[m - 1];
				}
			}
		}
		return false;
	}

//	static void failure() {
//		int m = 0; // m은 0으로 초기화
//		int begin = 1; // begin은 1로 초기화
//
//		while (begin + m < target.length()) { // s2의 끝까지 검사한다.
//			if (target.charAt(begin + m) == target.charAt(m)) { // 일치하면 m을 1 증가시키고 fail 배열에 값을 추가해준다.
//				m++;
//				fail[begin + m - 1] = m;
//			} else { // 일치하지 않으면, 아래쪽 배열을 옮겨준다.
//				if (m == 0) {
//					begin++;
//				} else {
//					begin += m - fail[m - 1];
//					m = fail[m - 1];
//				}
//			}
//		}
//	}
	
	static void getPi(String target) {
		int len = target.length();
		int j = 0;
		for(int i = 1; i < len ; i++) {
			while(j > 0 && target.charAt(i) != target.charAt(j))
				j = pi[j-1];
			if(target.charAt(i) == target.charAt(j))
				pi[i] = j++;
		}
	}
}
