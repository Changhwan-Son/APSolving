package jun.week5;

public class PRO_정수삼각형 {
	public int solution(int[][] triangle) {
		int answer = 0;

		int len = triangle.length;
		for (int i = 1; i < len; i++) {
			int tlen = triangle[i].length;
			for (int j = 0; j < tlen; j++) {

				if (j == 0)
					triangle[i][j] += triangle[i - 1][j];
				else if (j == tlen - 1)
					triangle[i][j] += triangle[i - 1][j - 1];
				else
					triangle[i][j] = Math.max(triangle[i][j] + triangle[i - 1][j],
							triangle[i - 1][j - 1] + triangle[i][j]);
			}
		}

		for (int i = 0; i < len; i++) {
			answer = Math.max(answer, triangle[len - 1][i]);
		}
		return answer;
	}
}
