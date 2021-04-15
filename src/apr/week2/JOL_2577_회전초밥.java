package apr.week2;

import java.io.*;
import java.util.StringTokenizer;

public class JOL_2577_회전초밥 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken()); // 접시 수
		int d = Integer.parseInt(st.nextToken()); // 가짓수
		int k = Integer.parseInt(st.nextToken()); // 연속 접시 수
		int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

		int[] sushi = new int[N];			// 접시 배열 
		int[] visited = new int[d + 1];		// 연속 접시 k 개에 속해있는 종류 수 
		for (int i = 0; i < N; i++)
			sushi[i] = Integer.parseInt(in.readLine());

		int answer = 0;						// 최종 답 
		int kind = 0;						// 현재 가짓 수 
		for (int i = 0; i < k; i++) {		// 처음 위치에서 k 개 연속 접시 계산 
			if (visited[sushi[i]] == 0)
				kind++;
			visited[sushi[i]]++;
		}
		answer = kind;

		for (int i = 1; i < N; i++) {		// 마지막 접시까지 돌면서 k 개 연속 접시 경우 계산 
			if (answer <= kind) {			// 가짓수 최대값 구하기 
				if (visited[c] == 0)
					answer = kind + 1;
				else
					answer = kind;
			}

			visited[sushi[i - 1]]--;		// 맨 처음 index 였던 거 삭제 
			if (visited[sushi[i - 1]] == 0)		// 유일한 종류의 것이었으면 kind -- 
				kind--;

			if (visited[sushi[(i + k - 1) % N]] == 0)	// 새로 들어온게 새로운 거면 kind++
				kind++;
			visited[sushi[(i + k - 1) % N]]++;		// 새로 들어온거 추가 
		}

		System.out.println(answer);
	}
}
