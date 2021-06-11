package jun.week2;

import java.io.*;
import java.util.Arrays;


public class BOJ_5052_전화번호목록_2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(in.readLine());
		for (int i = 0; i < t; i++) {
			boolean check = true;
			int n = Integer.parseInt(in.readLine());
			String[] nums = new String[n];
			for (int j = 0; j < n; j++)
				nums[j] = in.readLine();
            
            Arrays.sort(nums);
			
			for(int j = 0 ; j < n - 1; j++) {
				if(nums[j+1].startsWith(nums[j])){
                    check = false;
                    break;
                }
			}
			if(!check)
				sb.append("NO").append("\n");
			else
				sb.append("YES").append("\n");
		}
		System.out.println(sb);
	}
}

