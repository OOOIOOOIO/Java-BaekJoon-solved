package problems.category.dfs_bfs_그래프순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질_1697 {
	
	static int N, K, cnt;
	static int max = 100001;
	static int[] visited = new int[max];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		// 수빈이가 동생을 잡자!
		
		// 수빈 현재 위치 +-1 or *2
		N = Integer.parseInt(st.nextToken());
		// 동생
		K = Integer.parseInt(st.nextToken());
		
		// 1부터 시작
		visited[N] = 1;
		
		bfs();
		
		System.out.println(sb);
		
	}
	
	static void bfs() {
		
		if(N > K) {
			sb.append(N-K);
			return;
		}
		else if( N == K){
			sb.append(0);
			return;
		}
		else {
			Queue<Integer> queue = new LinkedList<Integer>();
			
			queue.offer(N);
			
			while(!(queue.isEmpty())) {
				
				int curr = queue.poll();
				
				if(curr == K) {
					// 1부터 시작했으니 -1 해줘야됨
					sb.append(visited[curr] - 1);
					return;
				}
				
				for(int i = 0; i < 3; i++) {
					
					int next;

	                if (i == 0) {
	                    next = curr + 1;
	                } else if (i == 1) {
	                    next = curr - 1;
	                } else {
	                    next = curr * 2;
	                }


	                if (next >= 0 && next < visited.length && visited[next] == 0) {
	                    queue.offer(next);
	                    
	                    visited[next] = visited[curr] + 1;
	                }
	            }
	        }
	    }
	}
}
