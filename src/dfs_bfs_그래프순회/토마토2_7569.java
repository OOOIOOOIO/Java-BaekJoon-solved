package dfs_bfs_그래프순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토2_7569 {
	
	static int M, N, H;
	static int MAX = Integer.MIN_VALUE;
	static boolean flag = true;
	static boolean[][][] visited;
	static int[][][] box;
	static int[] dy = {-1, 0, 1, 0, 0, 0};
	static int[] dx = {0, -1, 0, 1, 0, 0};
	static int[] dz = {0, 0, 0, 0, -1, 1};
	
	static LinkedList<int[]> ripe = new LinkedList<int[]>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		// 가로
		M = Integer.parseInt(st.nextToken());
		// 세로
		N = Integer.parseInt(st.nextToken());
		// 층 수
		H = Integer.parseInt(st.nextToken());
		// 토마토 위치, N * H번
		
		box = new int[N][M][H];
		visited = new boolean[N][M][H];
		
		// 토마토 채워넣기
	    // 3차원은  z--> y --> x 순으로 돈다!
			for(int k = 0; k < H; k++) {
				for(int i = 0; i < N; i++) {
					String[] arr = br.readLine().split(" ");
					for(int j = 0; j < M; j++) {
						box[i][j][k] = Integer.parseInt(arr[j]);
						
						// 익은 애들 위치 저장
						if(Integer.parseInt(arr[j]) == 1) {
							ripe.offer(new int[] {i, j, k});
							visited[i][j][k] = true;
						}
					
				}
			}
		}
		
		
		bfs();
		
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
		
		System.out.println();
		
		for(int k = 0; k < H; k++) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					System.out.print(box[i][j][k] + " ");
				}
				System.out.println();
			}
		}
		
	}
	
	static void bfs() {
		Queue<int[]> queue = new LinkedList<int[]>();
		
		
		while(!(ripe.isEmpty())) {
			queue.offer(ripe.poll());
		}
		
		
		while(!(queue.isEmpty())) {
			
			int[] curr = queue.poll();
			
			for(int i = 0; i < 6; i++) {
				int next_y = curr[0] + dy[i];
				int next_x = curr[1] + dx[i];
				int next_z = curr[2] + dz[i];
				
				if(next_x >= 0 && next_x < M && next_y >= 0 && next_y < N && next_z >= 0 && next_z < H ) {
					if(box[next_y][next_x][next_z] == 0 && !(visited[next_y][next_x][next_z])) {
						visited[next_y][next_x][next_z] = true;
						box[next_y][next_x][next_z] = box[curr[0]][curr[1]][curr[2]] + 1;
						
						queue.offer(new int[] {next_y, next_x, next_z});
						
					}
				}
			}
		}
	}
	
	
	static void check() {
		for(int k = 0; k < H; k++) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(box[i][j][k] == 0) {
						flag = false;
					}
					
					if(box[i][j][k] >= MAX ) {
						MAX = box[i][j][k]; 
					}
				}
				
			}
		}
			
	}
	
}














