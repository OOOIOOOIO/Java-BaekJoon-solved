package problems.category.스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 균형잡힌세상_4949_괄호확장판_O {
	
	public String match(String input) {
		Stack<Character> stack = new Stack();
		
		for(char a : input.toCharArray()) {
			if(a == '(' || a == '[') {
				stack.push(a);
			}
			
			
			else if(a == ')') {
				if(!(stack.empty()) && stack.peek() == '(') stack.pop();
                    
                else return "no";
				
			}
			
			else if(a == ']') {
				if(!(stack.empty()) && stack.peek() == '[') stack.pop();
                    
                else return "no";
			}
		}
		if(stack.isEmpty()) {
			return "yes";
		}
		else {
			return "no";
		}
		
	}
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		균형잡힌세상_4949_괄호확장판_O test = new 균형잡힌세상_4949_괄호확장판_O();
		
		
		while(true) {
			String input = br.readLine();
			if(input.equals(".")) break;
			
			
			sb.append(test.match(input)).append("\n");
			
			
		}
		
		System.out.println(sb);
	}
}
