package jul.week1;

import java.util.Arrays;

public class Solution1 {

	public static void main(String[] args) {
		int[] prices = { 13000, 88000, 10000 };
		int[] discounts = { 30, 20 };
		solution(prices, discounts);
	}

	public static int solution(int[] prices, int[] discounts) {
		int answer = 0;

		Arrays.sort(prices);
		Arrays.sort(discounts);

		int len = prices.length;
		int dlen = discounts.length;
		for (int i = len - 1; i >= 0; i--) {

			if (i - len + dlen >= 0) {
				System.out.println(prices[i] + " " + discounts[i - len + dlen]);
				answer += prices[i] * (100 - discounts[i - len + dlen]) / 100;
			} else
				answer += prices[i];
		}

		System.out.println(answer);
		return answer;
	}
}
