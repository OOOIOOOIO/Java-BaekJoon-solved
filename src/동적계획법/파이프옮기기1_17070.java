package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 파이프옮기기1_17070 {
	

	static int[][] map;
	static int N;
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			String[] temp = br.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		dfs(0, 1, 0);
//		bfs();
		System.out.println(cnt);
		
		
	}
	
	static void dfs(int y, int x, int direction) {
		 if (y == N-1 && x == N-1) { // 종료 조건
	            cnt++;
	            return;
	        }
	 
	        switch (direction) {
	        case 0: // 파이프가 가로 방향일 경우, 갈 수 있는 경우는 동쪽과 대각선임.
	        	if(y < N && x + 1 < N && map[y][x+1] != 1) { 
	                dfs(y, x + 1, 0);
	            }
	            break;
	        case 1: // 파이프가 세로 방향일 경우, 갈 수 있는 경우는 남쪽과 대각선임.
	        	if(y + 1 < N && x < N && map[y+1][x] != 1) { 
	                dfs(y + 1, x, 1);
	            }
	            break;
	        case 2: // 파이프가 대각선일 경우, 갈 수 있는 경우는 동쪽과 남쪽, 대각선임.
	        	if(y < N && x + 1 < N && map[y][x+1] != 1) {
	                dfs(y, x + 1, 0);
	            }
	 
	            if(y+1 < N && x < N && map[y+1][x] != 1) {
	                dfs(y + 1, x, 1);
	            }
	            break;
	        }
	 
	        // 파이프가 어떤 방향이든지, 대각선은 검사해서 가장 아래로 뺐음.
	        if(y+1 < N && x+1 < N && map[y+1][x] != 1 && map[y][x+1] != 1 && map[y+1][x+1] != 1) {
	            dfs(y + 1, x + 1, 2);
	        }
	    }
	
	
	
}

/*
 * 
 * 시나리오
 * 가로 세로 대각 방향이 있다.
 * 각각의 경우로 나눠 이동, n, n까지 도착할 경우 + 1
 * 1인 경우 벽
 * 
 * 방향, 타입, 좌표, bfs로 돌려 16
 */
