package problems.category.스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 괄호_9012_스택에대한개념확립_OOO {
	
	public static String match(String input) {
		Stack<Character> stack = new Stack<Character>();
		
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) == '(') stack.push('(');
			
			// 딱 처음에 ) 이게 들어 올 때
			else if(stack.empty()) return "NO";
			
			else stack.pop();
		}
		
		if(stack.empty()) return "YES";
		
		// ( 이게 남아 있을 때
		else return "NO";
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		
		for(int i = 0; i < T; i++) {
			sb.append(match(br.readLine())).append("\n");
			
		}
				
		System.out.println(sb);
		
	
	}
}
