package dfs_bfs_그래프순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/*
6
1 1 1 1 1 1
2 2 6 2 2 3
2 2 5 2 2 3
2 2 2 4 6 3
0 0 0 0 0 6
0 0 0 0 0 9
 */
public class 아기상어_16236 {
	
	
	static class Shark{
		static int size;
		static int feed;
		static int move;
	}
	
	static class Move{
		int x;
		int y;
		int distance;
		
		public Move(int y, int x, int distance) {
			this.y = y;
			this.x = x;
			this.distance = distance;
		}
		
	}
	
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {-1, 0, 1, 0}; // 상 좌 하 우 (반시계방향)
	static int N;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		visited = new boolean[N][N];
		
		Shark.size = 2;
		Shark.move = 0;
		Shark.feed = 0;
		
		int sX = -1;
		int sY = -1;
		
		for(int i = 0; i < N; i++) {
			String[] temp = br.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(temp[j]);
				
				if(map[i][j] == 9) {
					sY =  i;
					sX = j;
					map[sY][sX] = 0;
				}
			}
		}
		
		xfs(sY, sX);
		
		System.out.println(Shark.move);
		
		
	}
	
	static void xfs(int y, int x) {
		
		Queue<Move> cordi = new LinkedList<>();
		Queue<Move> fish = new PriorityQueue<Move>(new Comparator<Move>() {
			@Override
			public int compare(Move o1, Move o2) {
				if (o1.distance == o2.distance) {
					if (o1.y == o2.y) return Integer.compare(o1.x, o2.x);
					
					return Integer.compare(o1.y, o2.y);
				}
				
				return Integer.compare(o1.distance, o2.distance);
			}
		});
		
		visited[y][x] = true;
		
		cordi.offer(new Move(y, x, 0));
		
		while(true) {
			
			
			
			while(!cordi.isEmpty()) {
				
				// 현재
				Move curr = cordi.poll();
				
				// 탐색
				for(int i = 0; i < 4; i++) {
					int nextY = curr.y + dy[i];
					int nextX = curr.x + dx[i];
					
					// map 벗어나는 경우
					if(nextY < N && nextY >= 0 && nextX < N && nextX >= 0) {
						// 방문하지 않았을 경우
						if(!visited[nextY][nextX]) {
							// 크기가 작거나 같을 경우 이동 가능
							if(map[nextY][nextX] <= Shark.size) {
								
								// 크기가 작을 경우 -> 먹는다
								if(map[nextY][nextX] < Shark.size && map[nextY][nextX] != 0) {
									fish.offer(new Move(nextY, nextX, curr.distance+1));
								}
								
								cordi.offer(new Move(nextY, nextX, curr.distance+1));
								visited[nextY][nextX] = true;
								
							}
						}
					}
				}
			}
			

			
			// 종료
			if(fish.isEmpty()) {
				return;
			}
			
			// 1마리
			if(fish.size() >= 1) {
				Move temp = fish.poll();
				Shark.move += temp.distance;
				Shark.feed++;
				
				// 초기화
				cordi.clear();
				visited = new boolean[N][N];
				visited[temp.y][temp.x] = true;
				map[temp.y][temp.x] = 0;
				cordi.offer(new Move(temp.y, temp.x, 0));
				
				if(!fish.isEmpty()) {
					fish.clear();
				}
				
			}
			
			// 크기 커지기
			if(Shark.size == Shark.feed) {
				Shark.size += 1;
				Shark.feed = 0;	
			}


		}
		
	}
	
	
}
