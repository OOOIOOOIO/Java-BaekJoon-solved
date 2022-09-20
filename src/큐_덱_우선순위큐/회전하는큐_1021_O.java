package 큐_덱_우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 회전하는큐_1021_O {
	
	public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		LinkedList<Integer> deque = new LinkedList<Integer>();
		
		int count = 0;	// 2, 3번 연산 횟수 누적 합 변수
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());	// 큐의 크기(1 ~ N)
		int M = Integer.parseInt(st.nextToken());	// 뽑으려는 숫자의 개수
		
		// 1부터 N까지 덱에 담아둔다.
		for(int i = 1; i <= N; i++) {
			deque.offer(i);
		}
		
		int[] seq = new int[M];	// 뽑고자 하는 수를 담은 배열
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < M; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
		
		for(int i = 0; i < M; i++) {
			// 덱에서 뽑고자 하는 숫자의 위치(index) 찾기 
			//요소들의 위치는 바뀌지만 index번호는 고정
			int target_idx = deque.indexOf(seq[i]);
			int half_idx = deque.size() / 2;

			
			
			// 중간 지점 또는 중간 지점보다 원소의 위치가 앞에 있을 경우
			if(target_idx <= half_idx) {
				// idx 보다 앞에 있는 원소들을 모두 뒤로 보낸다. (2번)
				for(int j = 0; j < target_idx; j++) {
					deque.offerLast(deque.pollFirst());
					count++;
				}
			}
			else {	// 중간 지점보다 원소의 위치가 뒤에 있는 경우 
				// target을 함한 뒤에 있는 원소들을 모두 앞으로 보낸다. (3번)
				for(int j = 0; j < deque.size() - target_idx; j++) {
					deque.offerFirst(deque.pollLast());
					count++;
				}
			
			}
			deque.pollFirst();	// 연산이 끝나면 맨 앞 원소를 삭제
		}
		
		System.out.println(count);
		
		
	}
}
