package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 문자열 검사해서 삭제 혹은 뭐 이상한 거 할 떄
 * 이렇게 하면 되는구나
 * 
 * 
mirkovC4nizCC44
C4
 * 
 */
public class 문자열폭발_9935 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		String boomb = br.readLine();
		int boLen = boomb.length();
		Stack<Character> stack = new Stack<Character>();
		
		
		for(int i = 0; i < str.length(); i++) {
			// 일단 넣어
			stack.push(str.charAt(i));
			
			// 검색 시작 
			if(stack.size() >= boLen) {
				// 일치 유무
				boolean flag = true;
				
				// 검색
				for(int j = 0; j < boLen; j++) {
					
					// stack.get(스택길이 - 폭탄길이 + 인덱스)를 해줌으로써 
					if(stack.get(stack.size() - boLen + j) != boomb.charAt(j)) {
						flag = false;
						break;
					}
				}
				
				// 일치했다면
				if(flag) {
					for(int j = 0; j < boLen; j++) {
						stack.pop();
						
					}
				}
			}
		}
		
		if(stack.isEmpty()) {
			System.out.println("FRULA");
		}
		else {
			for(Character c : stack) {
				sb.append(c);
			}
			System.out.println(sb.toString());
			
		}
	}
}
