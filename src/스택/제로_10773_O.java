package 스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 제로_10773_O {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<Integer>();
		int sum = 0;
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			
			if(input == 0) {
				stack.pop();
			}
			else stack.push(input);
			
		}
		while(!stack.isEmpty()) {
			sum += stack.pop();
		}
		
		System.out.println(sum);
	}
}
