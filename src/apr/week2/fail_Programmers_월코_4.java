package apr.week2;

import java.util.*;
class fail_Programmers_월코_4 {
    static ArrayList<Integer> price;
    public static long[] solution(int n, int z, int[][] roads, long[] queries) {
        long[] answer = {};
        
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0 ; i < roads.length; i++)
            set.add(roads[i][2]);
        price = new ArrayList<>(set);
        price.add(z);
        
        Collections.sort(price, Collections.reverseOrder());
        
     
        for(int i = 0 ; i < queries.length; i++) {
            answer[i] = getAnswer(queries[i]);
        }
        return answer;
    }
    
    static long getAnswer(long n) {
        long cnt = 0;
        int len = price.size();
        for(int i = 0 ; i < len; i++) {
            int num = price.get(i);
            if(n > num){
                cnt += (n / num);
                n %= num;
            }
            if(n == 0)
                break;
        }
        if(n == 0)
            return cnt;
        else
            return -1;
    }
    
    public static void main(String[] args) {
    	int[][] roads = {{1,2,3},{0,3,2}};
    	long[] queries= {0,1,2,3,4,5,6};
		solution(5, 5, roads, queries);
	}
}