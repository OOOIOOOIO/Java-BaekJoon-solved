package dfs_bfs_그래프순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 단지번호붙이기_BFS_2667 {
	
	static int[][] graph;
	static boolean[][] visited;
	static int N;
	static PriorityQueue<Integer> pQueue; // 단지 수를 담을 곳
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		
		// 길이
		N = Integer.parseInt(st.nextToken());
		
		// 지도 받기
		graph = new int[N][N];
		visited = new boolean[N][N];
		pQueue = new PriorityQueue<Integer>();
		
		for(int i = 0; i < N; i++) {
			String[] line = br.readLine().split("");
			
			for(int k = 0; k < N; k++) {
				graph[i][k] = Integer.parseInt(line[k]);
			}
		}
		
//		for(int i = 0; i < N; i++) {
//			for(int k = 0; k < N; k++) {
//				System.out.print(graph[i][k]);
//			}
//			System.out.println();
//		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(graph[i][j] == 1 && !(visited[i][j])) {
					bfs(i, j);
				}
			}
		}
        // 큐의 사이즈가 단지의 수이다.
        System.out.println(pQueue.size());
        
        // 우선순위 큐는 작은 수부터 우선적으로 나오기 때문에 큐가 빌때까지 값을 출력하면 된다.
        while(!pQueue.isEmpty()) {
            System.out.println(pQueue.poll());
        }
	}
	
	
	
//	i 가 y축(헹), j가  x축(열)!!! 중요
//	좌 우로 움직일 때 j(열)가 움직이고
//	상 하로 움직일 때는 i(행)가 움직인다.
	static void bfs(int start_y, int start_x) {
		Queue<int[]> queue = new LinkedList<int[]>();
		
		queue.offer(new int[] {start_y, start_x});
		
		// 아파트 수
		int cnt = 0;
		
		while(!(queue.isEmpty())) {
			int[] curr = queue.poll();
			
			int curr_y = curr[0];
			int curr_x = curr[1];
			
			// 지도 칸 안에 있을 경우
			// 아직 방문하지 않고 1인 경우 현재 좌표의 상하좌우 queue에 넣기
			if(curr_x >= 0 && curr_y >= 0 && curr_x < N && curr_y < N) {
				if(graph[curr_y][curr_x] == 1 && !visited[curr_y][curr_x]) {
					cnt++;
					visited[curr_y][curr_x] = true;
					
		            // 근처 상하 좌우 좌표를 큐에 입력한다. 
					// 일단 다 때려박고 다시 내려오는 과정에서 걸러진다!!!
		            queue.offer(new int[] {curr_y+1, curr_x}); // 하
		            queue.offer(new int[] {curr_y-1, curr_x}); // 상
		            queue.offer(new int[] {curr_y, curr_x+1}); // 우
		            queue.offer(new int[] {curr_y, curr_x-1}); // 좌
				}
			}
		}
		if(cnt != 0) {
			pQueue.offer(cnt);
			
		}
		
	}
}
