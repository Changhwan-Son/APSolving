package apr.week2;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA_3816_아나그램 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			String str1 = st.nextToken();
			String str2 = st.nextToken();
			
			int len1 = str1.length();
			int len2 = str2.length();
			int[] arr1 = makeAlphaArr(str1, 0, len1);
			
			int answer = 0;
			for(int i = 0 ; i < len2 - len1 + 1; i++) {
				boolean check = true;
				int[] arr2 = makeAlphaArr(str2, i, i + len1);
				for(int j = 0 ; j < 26; j++) {
					if(arr1[j] != arr2[j])
						check = false;
				}
				if(check)
					answer++;
			}
			
			System.out.println("#" + tc + " " + answer);
		}
	}
	
	static int[] makeAlphaArr(String str, int s, int e) {
		int[] arr = new int[26];
		for(int i = s ; i < e; i++)
			arr[str.charAt(i) - 'a']++;
		return arr;
	}
}
