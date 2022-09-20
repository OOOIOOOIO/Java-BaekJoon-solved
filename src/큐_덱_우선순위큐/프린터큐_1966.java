package 큐_덱_우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 프린터큐_1966 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());	// 테스트 케이스 
 
		while (T-- > 0) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			LinkedList<int[]> q = new LinkedList<>();	// Queue로 활용 할 연결리스트
			st = new StringTokenizer(br.readLine());
 
			for (int i = 0; i < N; i++) {
				// LinkedList에 [중요도, 초기위치]로 들어가 있음 
				q.offer(new int[] { Integer.parseInt(st.nextToken()), i });
			}
 
			int count = 0;	// 출력 횟수
			
			while (!q.isEmpty()) {	// 한 케이스에 대한 반복문
				
				int[] front = q.poll();	// 가장 첫 원소 추출
				boolean isMax = true;	// front 원소가 가장 큰 원소인지를 판단하는 변수
				
				// 추출한 원소를 제외한 큐에 남아있는 원소들과 중요도를 비교 
				for(int i = 0; i < q.size(); i++) {
					
					// 처음 뽑은 원소보다  큐에 남아있는 있는 i번째 원소가 중요도가 클 경우 
					if(front[0] < q.get(i)[0]) { //get 때문에 Deque나 Queue 못 씀
						
						// 뽑은 원소 및 i 이전의 원소들을 뒤로 보낸다.
						q.offer(front); // 첫번째 요소
//						for(int j = 0; j < i; j++) { // 첫번째요소보다 큰 중요도 전까지 
//							q.offer(q.poll());
//						}
						
						// front원소가 가장 큰 원소가 아니였으므로 false를 하고 탐색을 마침
						isMax = false;
						break;
					}
				}
				
				// front 원소가 가장 큰 원소가 아니였으므로 다음 반복문으로 넘어감
				if(isMax == false) {
					continue;
				}
				
				// front 원소가 가장 큰 원소였으므로 해당 원소는 출력해야하는 문서다.
				count++;
				if(front[1] == M) {	// 찾고자 하는 문서라면 해당 테스트케이스 종료
					break;
				}
 
			}
 
			sb.append(count).append('\n');
 
		}
		System.out.println(sb);
	}
 
}
