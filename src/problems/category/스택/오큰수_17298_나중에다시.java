package problems.category.스택;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 오큰수_17298_나중에다시 {
	/*
	 * 배열이 있따면 |1|2|3|4|5|6| 
	 * 6부터 stack에 먼저 넣고  Ai번째까지 넣는다 그 후 Ai를 
	 * pop한 후 변수에 담아 Ai 보다 큰 요소가 존재한다면 break
	 * 만약 끝까지 pop했는데도 없다면 -1 출력 오케이~
	 */
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<Integer>();
		
		// 수열의 크기
		int A = Integer.parseInt(br.readLine());
		int[] data = new int[A];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 수열 생성
		for(int i = 0; i < A; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = A-1; i >= 0; i--) {
			stack.push(data[i]);
		}
		
		// 수열의 인덱스
		int j = 0;
		while(true) {
            boolean flag = true;
			j += 1;
			if(j <= A) {
				if(stack.size() == 1) {
					sb.append(-1);
					break;
				}
				
				int N = stack.pop(); // 0번 요소, data[i]는 1번요소부터 시작
				
				for(int i = j; i < A; i++) {
					if(N < data[i]) {
						sb.append(data[i]).append(" ");
                        flag = false;
                        break;
					}
				}
				if(flag) {
					sb.append("-1").append(" ");
				}
			}
            else{
                break;
            }
		}
		System.out.println(sb);
		
	}
}
