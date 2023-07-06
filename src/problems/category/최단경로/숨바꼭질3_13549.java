package problems.category.최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질3_13549 {
	static int N, K, sec;
	static final int max = 100001;
	static StringBuilder sb = new StringBuilder();
	static int[] dist = new int[max];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 수빈이 위치
		N = Integer.parseInt(st.nextToken());
		
		// 동색 위치
		K = Integer.parseInt(st.nextToken());
		
		// 첫번째 방문을 확인하기 위해 1
		dist[N] = 1;
		
		find();
		
		System.out.println(sb);
	}
	
	static void find() {
		
		if(N > K) {
			sb.append(N-K);
			return;
		}
		else if(N == K) {
			sb.append(0);
			return;
		}
		else {
			
			Queue<Integer> queue = new LinkedList<Integer>();
			
			queue.offer(N);
			
			while(!(queue.isEmpty())) {
				
				int curr = queue.poll();
				int next = 0;
				
				// 시작을 1로 하였으니 1 빼줌
				if(curr == K) {
					sb.append(dist[curr]-1);
					return;
				}
				
				// -1, +1, *2 : 3방향
				for(int i = 0; i < 3; i++) {
					if(i == 0) {
						next = curr - 1;
					}
					else if(i == 1) {
						next = curr + 1;
					}
					else {
						next = curr * 2;
						
						if(next >= 0 && next < max) {
							// 방문하지 않았거나 next 위치의 cnt가 현재 cnt보다 클 경우 더 작은 횟수로 설정하지(다음 위치의  횟수가 더 많으면 최단거리로 바꿔주기)
							if(dist[next] == 0 || dist[next] > dist[curr]) {
								
								queue.offer(next);
								dist[next] = dist[curr];
							}
						}
						continue;
					}
					
					
					if(next >= 0 && next < max) {
						// 방문하지 않았거나 next 위치의 cnt가 현재 cnt보다 클 경우 더 작은 횟수로 설정하지(다음 위치의  횟수가 더 많으면 최단거리로 바꿔주기)
						if(dist[next] == 0 || dist[next] > dist[curr] + 1) {
							queue.offer(next);
							dist[next] = dist[curr] + 1;
						}
					}
					
					
				}
				
			}
			
		}
	}
	
	
}
