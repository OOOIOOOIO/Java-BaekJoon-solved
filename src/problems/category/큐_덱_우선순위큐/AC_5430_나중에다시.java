package problems.category.큐_덱_우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class AC_5430_나중에다시 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 케이스 개수
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		// 테스트 수만큼
		while(T-- > 0) {
			int front = 0;
			boolean flag = true;
			// 명령 R : 뒤집기 / D : 삭제(없으면 error 출력)
			String[] order = br.readLine().split("");
		
			// 요소개수
			int n = Integer.parseInt(br.readLine());
			// 요소 [1, 2, 3] 이딴식 
//			st = new StringTokenizer(br.readLine(), "[],"); StringTokenizer로 제거하는 법 
			String[] arr = br.readLine().replace("[", "").replace("]", "").split(",");
			
			// [] 일 경우
			if(arr[0].equals("")) {
				sb.append("error");
				continue;
			}
//			Deque<Integer> deque = new LinkedList<Integer>();
			LinkedList<Integer> deque = new LinkedList<Integer>();
			
			
			// Deque 생성
			for(int i = 0; i < arr.length; i++) {
				deque.offerLast(Integer.parseInt(arr[i]));
			}

			
			// order 수 만큼
			for(int i = 0; i < order.length; i++) {
				// D의 횟수가 요소의 개수보다 많을 경우
				if(deque.isEmpty()) {
					sb.append("error").append("\n");
					flag = false;
					break;
				}
				switch(order[i]) {
				case "R" :
					front++;
					break;
				case "D" :
//					if(deque.peekFirst() == null) {
//						sb.append("error").append("\n");	
//						flag = false;
//						break;
//					}
					// front % 2 == 0 --> 원상태
					if(front % 2 == 0) {
						deque.pollFirst();
						n--;
					}
					else {
						deque.pollLast();
						n--;
					}
					break;
				}
			}
			
			if(flag) {
				sb.append("[");
				if(deque.peekFirst() != null || deque.peekLast() != null) { // 요소의 개수가 1개이고 D가 1개일 경우
					if(front % 2 == 0) {
						for(int i = 0; i < n-1; i++) {
							sb.append(deque.pollFirst()).append(",");
						}
						sb.append(deque.pollFirst());
					}
					else {
						for(int i = 0; i < n-1; i++) {
							sb.append(deque.pollLast()).append(",");
						}
						sb.append(deque.pollLast());
					}
				}
				sb.append("]").append("\n");
			}
		}
		System.out.println(sb);
		
	}
}
