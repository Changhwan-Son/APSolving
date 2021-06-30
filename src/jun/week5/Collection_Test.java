package jun.week5;

import java.time.LocalDate;

public class Collection_Test {

	static int[][] days = { { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 },
			{ 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 } };

	public static void main(String[] args) {
		LocalDate now = LocalDate.now();
		int year = now.getYear();
		int month = now.getMonthValue();
		
		int idx = 0;
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) 
			idx = 1;
		
		System.out.println(days[idx][month] + "days for " + year + "-" + month);
	}
}
