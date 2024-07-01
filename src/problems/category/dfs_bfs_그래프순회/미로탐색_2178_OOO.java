package problems.category.dfs_bfs_그래프순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색_2178_OOO {
	static int N, M;
	static int min, cnt;
	static int[][] maze;
	static boolean[][] visited;
	static int[][] dp;
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {-1, 0, 1, 0};
	static StringBuilder sb = new StringBuilder();
	
	
	// 최단거리 찾기는 BFS!!!!
	static void bfs(int curr_y, int curr_x) {
		Queue<int[]> queue = new LinkedList<int[]>();
		
		queue.offer(new int[] {curr_y, curr_x});
		
		// 처음 (1, 1) 
		visited[curr_y][curr_x] = true;
		
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			
			int current_y = curr[0];
			int current_x = curr[1];
			
			for(int i = 0; i < 4; i++) {
				
				int next_y = current_y + dy[i];
				int next_x = current_x + dx[i];
						
				if(next_x >= 1 && next_x <= M && next_y >= 1 && next_y <= N) {
					if(maze[next_y][next_x] == 1 && !(visited[next_y][next_x])) {
						
						visited[next_y][next_x] = true;
						
						queue.offer(new int[] {next_y, next_x});
						
						dp[next_y][next_x] = dp[current_y][current_x] + 1;
						maze[next_y][next_x] = maze[current_y][current_x] + 1;
						
					}
				}
				
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 가로
		
		// 생성
		maze = new int[N+1][M+1];
		dp = new int[N+1][M+1];
		visited = new boolean[N+1][M+1];
		
		dp[1][1] = 1;
		
		// 칸은 1부터 시작, maze 만들기
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			String[] arr = st.nextToken().split("");
			for(int j = 1; j <= M; j++) {
				maze[i][j] = Integer.parseInt(arr[j-1]);
			}
		}
		
		bfs(1,1);

//		확인하기
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				System.out.print(maze[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		
		// 정답 출력
		System.out.println(maze[N][M]);
//		System.out.println(dp[N][M]);
		

		
		 
		
		
	}
}
