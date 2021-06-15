package jun.week3;

import java.io.*;
import java.util.*;

public class fail_BOJ_2251_물통 {

	static int[][] bottle;
	static int A,B,C;
	static Set<Integer> set;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		bottle = new int[3][2];
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		bottle[0][0] = Integer.parseInt(st.nextToken());
		bottle[1][0] = Integer.parseInt(st.nextToken());
		bottle[2][0] = Integer.parseInt(st.nextToken());
		bottle[2][1] = C;
		
		func(2);
		System.out.println(set.toString());
	}
	 
	static void func(int cur) {
		for(int i = 0 ; i < 3 ; i++) {
			if(i == cur)
				continue;
			
			if(bottle[cur][1] <= bottle[i][0] - bottle[i][1]) {
				bottle[cur][1] = 0;
				bottle[i][1] += bottle[cur][1];
				set.add(bottle[2][1]);
				func(i);
			} else if(bottle[cur][1] > bottle[i][0] - bottle[i][1]) {
				bottle[cur][1] -= bottle[i][0] - bottle[i][1];
				bottle[i][1] = bottle[i][0];
				set.add(bottle[2][1]);
				func(i);
			}
			
		}
	}
}
