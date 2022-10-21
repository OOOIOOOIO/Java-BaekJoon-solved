package dfs_bfs_그래프순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

import jdk.internal.org.jline.utils.InputStreamReader;

public class 미세먼지안녕_17144 {
	
	static int R, C;
	static int[][] map;
	static Map<String, Integer> diff;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		diff = new HashMap<String, Integer>();
		
		// 입력
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()); // 행
		C = Integer.parseInt(st.nextToken()); // 열
		int T = Integer.parseInt(st.nextToken()); // 초
		
		//초기화
		map = new int[R][C];
		int air1X = -1;
		int air1Y = -1;
		int air2X = -1;
		int air2Y = -1;
		
		// 지도 입력
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == -1 && air1X == -1) {
					air1X = j;
					air1Y = i;
				}
				else {
					air2X = j;
					air2Y = i;
				}
			}
		}
		
		// 동시 확산
		bfs();
		
		for(String key : diff.keySet()) {
			String[] temp = key.split(",");
			int y = Integer.parseInt(temp[0]);
			int x = Integer.parseInt(temp[1]);
			
			map[y][x] = diff.get(key);
		}
		
		
		// 시간에 따라 움직이기
		move();
		
	}

	// 동시에 확산
	static void bfs() {
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				
				if(map[i][j] == 0 || map[i][j] == -1) {
					continue;
				}
				
				int cnt = 0;
				int currVal = map[i][j];
				String currCordi = i+","+j; // y,x 형태
				
				for(int k = 0; k < 4; k++) {
					int nextY = i + dy[k];
					int nextX = j + dx[k];
					
					if(nextY >= 0 && nextY < R && nextX >=0 && nextX < C) {
						if(map[nextY][nextX] != -1) {
							cnt++;
							
							String nextCordi = nextY+","+nextX;
							int value = currVal / 5; 
							
							diff.put(nextCordi, diff.put(nextCordi, 0) + value);
						}
					}
				}
				
				int laterVal = currVal -(currVal / 5) * cnt;
				diff.put(currCordi, diff.getOrDefault(currCordi, 0) + laterVal);
				
			}
		}
		
	}
	
	static void move() {
		
	}
		
}
