package apr.week2;

import java.util.*;
class Programmers_월코_2 {
    static int len;
    public int solution(String s) {
        int answer = 0;
        len = s.length();
        
        for(int i = 0 ; i < len ; i++){
            if(check(i, s))
                answer++;
        }
        
        return answer;
    }
    
    static boolean check(int start, String s) {
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0 ; i < len ; i++) {
            char c = s.charAt((start + i) % len);
            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if(stack.isEmpty()) {
                return false;
            }else if(c == ')') {
                if(stack.peek() != '(')
                    return false;
                stack.pop();
            } else if(c == ']') {
                if(stack.peek() != '[')
                    return false;
                stack.pop();
            } else if(c == '}') {
                if(stack.peek() != '{')
                    return false;
                stack.pop();    
            }
        }
        return true;
    }
}