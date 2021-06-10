package jun.week2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BOJ_2023_신기한소수 {

	static int N;
	static List<String> list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(in.readLine());

		list = new ArrayList<>();
		func("");

		for (String s : list)
			sb.append(s).append("\n");

		System.out.println(sb);
	}

	static void func(String num) {
		if (num.length() == N) {
			list.add(num);
			return;
		}

		for (int i = 0; i < 10; i++) {
			if (isPrime(Integer.parseInt(num + Integer.toString(i)))){
				func(num + Integer.toString(i));
			}
		}

	}

	static boolean isPrime(int num) {
		if (num == 0 || num == 1)
			return false;

		for (int i = 2; i * i <= num; i++)
			if (num % i == 0)
				return false;

		return true;
	}
}
