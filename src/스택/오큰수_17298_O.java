package 스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 오큰수_17298_O {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		// 수열 개수
		int N = Integer.parseInt(br.readLine());
		
		// 수열 생성
		st = new StringTokenizer(br.readLine());
		int[] data = new int[N];
		for(int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		
		
		for(int i = 0; i < N; i++) {
			
			while(true) {
				if(!stack.isEmpty() && data[i] > data[stack.peek()]) {
					data[stack.pop()] = data[i]	;
				}
				else {
					stack.push(i);
					break;
				}
			}
		}
		
		// 자기보다 더 큰 애들이 없는 경우 
		for(int i = 0; i < stack.size(); i++) {
			data[stack.pop()] = -1;
		}
		
		
		// 출력
		for(int i = 0; i < N; i++) {
			sb.append(data[i]).append(" " );
		}
		System.out.println(sb);
	}
	
}
