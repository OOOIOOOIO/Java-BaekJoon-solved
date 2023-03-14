package problems.category.dfs_bfs_그래프순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토_7576 {
	static int M, N;
	static int MAX = Integer.MIN_VALUE;
	static boolean flag = true;
	static int[][] box;
	static boolean[][] visited;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, -1, 0, 1};
	
	
	static void bfs(LinkedList<int[]> ripe) {
		
		Queue<int[]> queue = new LinkedList<int[]>();
		
		// 1인 애들 큐에 넣기
		while(!(ripe.isEmpty())) {
			queue.offer(ripe.poll());
		}
		
		
		while(!(queue.isEmpty())) {
			
			// 1인 애들이 담긴 애들부터 나온다 FIFO
			int[] curr = queue.poll();
			
			//curr에서 모든 next를 간 다음
			
			for(int i = 0; i < 4; i++) {
				int next_x = curr[1] + dx[i];
				int next_y = curr[0] + dy[i];
				
				if(next_x >= 0 && next_x < M && next_y >= 0 && next_y < N ) {
					if(box[next_y][next_x] == 0 && !(visited[next_y][next_x])) {
//						flag = true;
						visited[next_y][next_x] = true;
						box[next_y][next_x] = box[curr[0]][curr[1]] + 1;
						
						queue.offer(new int[] {next_y, next_x});
						
					}
				}
			}
		}
	}
	
	// 0이 있는지 확인
	static void check() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(box[i][j] == 0) {
					flag = false;
				}
				
				if(box[i][j] >= MAX ) {
					MAX = box[i][j]; 
				}
				
			}
		}
			
	}
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		LinkedList<int[]> ripe = new LinkedList<int[]>();
		
		st = new StringTokenizer(br.readLine());
		
		
		// 가로, 열
		M = Integer.parseInt(st.nextToken());
		
		// 세로, 행
		N = Integer.parseInt(st.nextToken());
		
		// 생성
		box = new int[N][M];
		visited = new boolean[N][M];
		
		// 토마토들 만들기, 1인 위치 찾기
		for(int i = 0; i < N; i++) {
			String[] arr = br.readLine().split(" ");
			for(int j = 0; j < M; j++) {
				// 값이 1인 좌표 
				box[i][j] = Integer.parseInt(arr[j]);
				if(box[i][j] == 1) {
					visited[i][j] = true;
					ripe.offer(new int[] {i, j});
				}
			}
		}
		
		
		bfs(ripe);
		
		// 다 돌았을 경우
		check();
		
		if(flag) {
			if(MAX == 1) {
				System.out.println("0");
			}
			else {
				System.out.println(MAX -1);
				
			}
		}
		else {
			System.out.println("-1");
		}
		
//		System.out.println();
//		
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < M; j++) {
//				System.out.print(box[i][j] + " ");
//				
//			}
//			System.out.println();
//		}
		
	}
}
