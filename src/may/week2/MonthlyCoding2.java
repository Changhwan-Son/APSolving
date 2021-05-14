package may.week2;

public class MonthlyCoding2 {

	public static void main(String[] args) {
		long[] an = solution(new long[] {11111L});
		for(int i = 0 ;i < 1; i++)
			System.out.println(an[i]);
	}
	
	 public static long[] solution(long[] numbers) {
	        
	        int len = numbers.length;
	        long[] answer = new long[len];
	        for(int i = 0 ;i < len ; i++) {
	            long num = numbers[i];
	            char[] tmp = Long.toBinaryString(num).toCharArray();
	            char[] chars = new char[16];
	            for(int j = 0 ; j < 16; j++)
	                chars[j] = '0';
	            System.out.println(tmp.length);
	            for(int j = 16 - tmp.length ; j < 16; j++) {
	                chars[j] = tmp[j + tmp.length - 16];
	            }
	            
	            int len2 = chars.length;
	            for(int j = len2 - 1 ; j >= 0 ; j--) {
	            	if(chars[j] == '0' ){
	                	System.out.println(j);
	                    chars[j] = '1';
	                    if(j < len2 - 1)
	                        chars[j+1] = '0';
	                    break;
	                }
	            }
	            System.out.println(String.valueOf(chars));
	            answer[i] = Long.parseLong(String.valueOf(chars).trim(),2);
	           
	        }
	        return answer;
	    }
}
