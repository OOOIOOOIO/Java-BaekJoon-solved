package dfs_bfs_그래프순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 나이트의이동_7562 {
	
	static int[][] chess;
	static boolean[][] visited;
	static StringBuilder sb = new StringBuilder();
	static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		// 테스트 케이스
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		
		while(T-- > 0) {
			// 한편의 길이
			int l = Integer.parseInt(br.readLine());
			
			// 생성
			chess = new int[l][l];
			visited = new boolean[l][l];
			
			//현재있는 칸
			st = new StringTokenizer(br.readLine());
			int curr_y = Integer.parseInt(st.nextToken());
			int curr_x = Integer.parseInt(st.nextToken());

			
			//이동하려는 칸
			st = new StringTokenizer(br.readLine());
			int target_y = Integer.parseInt(st.nextToken());
			int target_x = Integer.parseInt(st.nextToken());
			
			
			bfs(l, curr_y, curr_x, 0, target_y, target_x);
		}
		
		System.out.println(sb);
		
	}
	
	
	static class Knight{
		int y;
		int x;
		int cnt;
		
		public Knight(int y, int x, int cnt) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
	}
	
	static void bfs(int length, int curr_y, int curr_x, int cnt, int target_y, int target_x) {
		Queue<Knight> queue = new LinkedList<>();
		
//		Knight knight = new Knight(curr_y, curr_x, 0);
		
		// 종료
		
		queue.offer(new Knight(curr_y, curr_x, 0));
		
		while(!(queue.isEmpty())) {
			
			Knight curr = queue.poll();
			
			if(curr.y == target_y && curr.x == target_x) {
				sb.append(curr.cnt).append("\n");
				return;
			}
			
			for(int i = 0; i < 8; i++) {
				
				int next_y = curr.y + dy[i];
				int next_x = curr.x + dx[i];
				
				
				if(next_x >= 0 && next_x < length && next_y >= 0 && next_y < length) {
					if(!(visited[next_y][next_x])) {
						
						visited[next_y][next_x] = true;
						
						queue.offer(new Knight(next_y, next_x, curr.cnt+1));
					}
				}
			}
		}
	}
}



