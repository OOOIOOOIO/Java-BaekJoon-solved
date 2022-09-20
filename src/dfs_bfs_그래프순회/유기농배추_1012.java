package dfs_bfs_그래프순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 유기농배추_1012 {
	
	static int M, N;
	static int total; // 필요한 지렁이 개수
	static int[][] matrix;
	static boolean[][] visited;
	static boolean[][] visited2;
	static StringBuilder sb = new StringBuilder();
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, -1, 0, 1};
	/*
	 * 
	 * x + dx[?]
	 * y + dy[?] 
	 * 
	 * i : y축 / j = x축
	 * 
	 * [0] -> 상
	 * 
	 * [1] -> 좌
	 * 
	 * [2] -> 하
	 * 
	 * [3] -> 우
	 * 
	 */
	
	static void dfs(int curr_y, int curr_x) { // curr_y : i / curr_x : j
		visited[curr_y][curr_x] = true;
		
//		int next_x;
//		int next_y;
		
		// 4방향(상하좌우)
		for(int i = 0; i < 4; i++) {
			int next_x = curr_x + dx[i];
			int next_y = curr_y + dy[i];
			
			if(next_x >= 0 && next_y >= 0 && next_x < N && next_y < M) {
				if(matrix[next_y][next_x] == 1 && !(visited[next_y][next_x])) {
					dfs(next_y, next_x);
				}
			}
		}
	}
	
	static void bfs(int curr_y, int curr_x) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {curr_y, curr_x});
		
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			
			int current_y = curr[0];
			int current_x = curr[1];
			
			
//			< 방법 1 : 하나만 걸려라>
//			if(current_x >= 0 && current_x < N && current_y >= 0 && current_y < M) {
//				if(matrix[current_y][current_x] == 1 && !(visited2[current_y][current_x])) {
//					
//					visited2[current_y][current_x] = true;
//					
//					queue.offer(new int[] {current_y, current_x-1});
//					queue.offer(new int[] {current_y, current_x+1});
//					queue.offer(new int[] {current_y-1, current_x});
//					queue.offer(new int[] {current_y+1, current_x});
//				}
//			}
			
//			<방법 2 : 깔끔하네>
			
			for(int i = 0; i < 4; i++) {
				
				int next_x = current_x + dx[i];
				int next_y = current_y + dy[i];
				
				if(next_x >= 0 && next_x < N && next_y >= 0 && next_y < M) {
					if(matrix[next_y][next_x] == 1 && !(visited2[next_y][next_x])) {
						
						visited2[next_y][next_x] = true;
						queue.offer(new int[] {next_y, next_x});
						
					}
				}
				
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		// 테스트 개수
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		// 돌리기
		while(T-- > 0) {
			
			
			// 가로 길이
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			
			// 세로 길이
			N = Integer.parseInt(st.nextToken());
			
			// 생성생성
			matrix = new int[M][N];
			visited = new boolean[M][N];
			visited2 = new boolean[M][N];
			
			// 이후 좌표 개수
			int K = Integer.parseInt(st.nextToken());
			
			// 좌표 X Y 연결
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				matrix[x][y] = 1;
			}
			
			// 돌리기
			for(int i = 0; i < M; i++) {
				for(int j = 0; j < N; j++) {
					if(matrix[i][j] == 1 && !(visited2[i][j])) {
//						dfs(i, j);
						bfs(i, j); // if문 visited2 로 바꿔주기
						total++;
					}
				}
			}
			
			sb.append(total).append("\n");
			
			total = 0;
			
		}
	
		System.out.println(sb);
	}
}
