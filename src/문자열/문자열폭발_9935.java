package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 문자열 검사해서 삭제 혹은 뭐 이상한 거 할 떄
 * 기준은 삭제할 문자열이다.
 * 
 */
public class 문자열폭발_9935 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		String str = br.readLine();
		String boomb = br.readLine();
		int boLen = boomb.length();
		Stack<Character> stack = new Stack<Character>();
		
		int idx = 0;
		
		for(int i = 0; i < str.length(); i++) {
			// 일단 넣어
			stack.push(str.charAt(i));
			
			// 검색 시작 
			if(stack.size() >= boLen) {
				
				// 검색
				for(int j = 0; j < boLen; j++) {
					
					if(stack.get(stack.size() - boLen + j) != boomb.charAt(j)) {
						break;
					}
				}
				
				
				
			}
			
			
		}

	}
}
