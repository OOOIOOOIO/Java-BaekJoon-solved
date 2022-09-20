package dfs_bfs_그래프순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 뱀과사다리게임_16928 {
	
	static int[] map = new int[101];
	static boolean[] visited = new boolean[101];
	static int[] snakeAndLadder = new int[101];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int ladder = Integer.parseInt(st.nextToken());
		int snake = Integer.parseInt(st.nextToken());
	
		for(int i = 0; i < ladder+snake; i++) {
			st = new StringTokenizer(br.readLine());
			int curr = Integer.parseInt(st.nextToken());
			int move = Integer.parseInt(st.nextToken());
			snakeAndLadder[curr] = move;
		
	
		}
		
		bfs(1);
	}
	
	static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.offer(start);
		
		visited[start] = true;
		map[start] = 0;
		
		while(!(queue.isEmpty())) {
			int curr = queue.poll();
			
			// 도착하면 끝내기
			if(curr == 100) {
				System.out.println(map[curr]);
				return;
			}
			
			for(int i = 1; i <= 6; i++) {
				int pos = curr + i;
				
				if(pos > 100 || visited[pos] == true) continue;
				
				// 우선 밟고 사다리든 뱀이든 타니까 밖으로 빼내준다.
				visited[pos] = true;
				
				if(snakeAndLadder[pos] != 0) {
					if(!(visited[snakeAndLadder[pos]])) {
						queue.offer(snakeAndLadder[pos]);
						visited[snakeAndLadder[pos]] = true;
						map[snakeAndLadder[pos]] = map[curr] + 1;
					}
				}
				else {
					queue.offer(pos);
					map[pos] = map[curr] + 1;
				}
			}
			
		}
		
	}
	
	
}
