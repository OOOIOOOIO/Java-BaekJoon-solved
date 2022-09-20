package dfs_bfs_그래프순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 단지번호붙이기_DFS_2667 {
	static int[][] graph;
	static boolean[][] visited; 
	static int[] dx = {0, -1, 0, 1}; // 좌 우 {x, x, x, x}  
	static int[] dy = {-1, 0, 1, 0}; // 상 하 {y, y, y, y} 인덱스에서의 위치를 생각해야 한다. dx, dy 위 아래로 한 쌍
	static int N;
	static int total; // 단지의 수
	static int cnt; // 단지 내 아파트 수
	static ArrayList<Integer> cnts = new ArrayList<Integer>(); // 아파트 수를 담을 곳
	
	
	static void dfs(int current_y, int current_x) {
		visited[current_y][current_x] = true;
		cnt++;
		
//		i 가 y축(헹), j가  x축(열)!!! 중요!!
//		좌 우로 움직일 때 j(열)가 움직이고
//		상 하로 움직일 때는 i(행)가 움직인다.
		
		for(int i = 0; i < 4; i++) {
			//			{y, x}
			// i = 0, 상 {0, -1}
			// i = 1, 좌 {-1, 0}
			// i = 2, 하 {0, 1}
			// i = 3, 우 {1, 0}
			int next_y = current_y + dy[i];
			int next_x = current_x + dx[i];
			
			// 지도 칸 안에 있을 경우
			// 아직 방문하지 않고 1인 경우 재귀 호출
			if(next_x >= 0 && next_x < N && next_y >= 0 && next_y < N) {
				if(graph[next_y][next_x] == 1 && !(visited[next_y][next_x])) {
					dfs(next_y, next_x);
				}
			}
		}
	}
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		
		// 길이
		N = Integer.parseInt(st.nextToken());
		
		// 지도 받기
		graph = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			String[] line = br.readLine().split("");
			
			for(int k = 0; k < N; k++) {
				graph[i][k] = Integer.parseInt(line[k]);
			}
		}
		
//		for(int i = 0; i < N; i++) {
//			for(int k = 0; k < N; k++) {
//				System.out.print(graph[i][k]);
//			}
//			System.out.println();
//		}
		
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				// 1이고 방문한 적이 없을 때
				// i 가 y축, j가 x 축
				if(graph[i][j] == 1 && !(visited[i][j])) {
					// 아파트 단지의 수
					total++;
					
					dfs(i, j);
					// 단지 내에 있는 아파트의 수
					cnts.add(cnt);
					
					// 단지가 바뀌므로 0으로 초기화(전역변수)
					cnt = 0;
				}
			}
		}
		
		System.out.println(total);
		
//		Collections.sort(cnts);
		
		cnts.sort(new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			};
		});
		/* Arrays.sort / Collections.sort의 기준(오름차순이 기본) 
		 return이 음수일 경우 : 두 원소의 위치를 교환 안함(현재 오름차순)
		 return이 양수일 경우 : 두 원소의 위치를 교환 함(현재 내림차순)
		 --> 내림차순을 하고싶다면 return에 ()*-1을 해주면 된다.
		 혹은 o2.value - o1.value 처럼 순서를 바꿔주면 된다.*/
		
		for(int item : cnts) {
			System.out.println(item);
		}
	}
}
