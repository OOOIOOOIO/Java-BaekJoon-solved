package dfs_bfs_그래프순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;


public class 미세먼지안녕_17144 {
	
	static int R, C, T;
	static int[][] map = new int[50][50];
	static ArrayList<Integer> aircleaner = new ArrayList<Integer>();
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, -1, 0, 1};
	static int sumOfDust = 2;
	
	   public static void main(String[] args) throws Exception {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st;

	        // input
	        st = new StringTokenizer(br.readLine());
	        R = Integer.parseInt(st.nextToken());
	        C = Integer.parseInt(st.nextToken());
	        T = Integer.parseInt(st.nextToken());

	        for (int i = 0; i < R; i++) {
	            st = new StringTokenizer(br.readLine());

	            for (int j = 0; j < C; j++) {
	                map[i][j] = Integer.parseInt(st.nextToken());
	                sumOfDust += map[i][j];

	                if (map[i][j] == -1) {
	                    aircleaner.add(i);
	                }
	            }
	        }

	        // solution
	        solution();
	    }

	    static void solution() {
	        while (T-- > 0) {
	            // 1. 먼지 확산
	            map = spreadDust();

	            // 2. 공기청정기 가동
	            executeAirCleaner();
	        }

	        System.out.println(calculateSum());
	    }

	    static int[][] spreadDust() {
	        int[][] temp = new int[50][50];
	        int[] dx = {-1, 1, 0, 0};
	        int[] dy = {0, 0, -1, 1};

	        // 확산된 미세먼지를 temp 배열에 계산
	        for (int y = 0; y < R; y++) {
	            for (int x = 0 ; x < C; x++) {
	            	
	            	
	                if (map[y][x] == -1) {
	                    temp[y][x] = -1;
	                    continue;
	                }

	                temp[y][x] += map[y][x]; // 현재 자리 값 우선 저장

	                for (int i = 0; i < 4; i++) {
	                    int ny = y + dy[i];
	                    int nx = x + dx[i];

	                    if (ny < 0 || ny >= R || nx < 0 || nx >= C) continue;
	                    if (map[ny][nx] == -1) continue;

	                    temp[ny][nx] += (map[y][x] / 5); // 확산
	                    temp[y][x] -= (map[y][x] / 5); // 현재 자리 확산 횟수 만큼 빼기
	                }
	            }
	        }

	        return temp;
	    }

	    static void executeAirCleaner() {
	        // 위쪽 공기청정기는 반시계방향
	        int top = aircleaner.get(0);

	        for (int x = top - 1; x > 0; x--) { // ↓
	            map[x][0] = map[x-1][0];
	        }
	        
	        for (int y = 0; y < C - 1; y++) { // ←
	            map[0][y] = map[0][y+1];
	        }

	        for (int x = 0; x < top; x++) { // ↑
	            map[x][C-1] = map[x+1][C-1];
	        }
	        
	        for (int y = C - 1; y > 1; y--) { // →
	            map[top][y] = map[top][y-1];
	        }

	        map[top][1] = 0;
	        

	        // 아래쪽 공기청정기는 시계 방향
	        int bottom = aircleaner.get(1);
	        
	        for (int x = bottom + 1; x < R - 1; x++) { // ↑
	            map[x][0] = map[x+1][0];
	        }

	        for (int y = 0; y < C - 1; y++) { // ←
	            map[R-1][y] = map[R-1][y+1];
	        }

	        for (int x = R - 1; x > bottom; x--) { // ↓
	            map[x][C-1] = map[x-1][C-1];
	        }

	        for (int y = C - 1; y > 1; y--) { // →
	            map[bottom][y] = map[bottom][y-1];
	        }

	        map[bottom][1] = 0;
	    }

	    static int calculateSum() {
	        int sum = 0;

	        for (int x = 0; x < R; x++) {
	            for (int y = 0; y < C; y++) {
	                sum += map[x][y];
	            }
	        }
	        
	        return sum -2;
	    }
	}