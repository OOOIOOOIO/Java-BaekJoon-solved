package problems.category.dfs_bfs_그래프순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 유기농배추_1012 {


	static int worm;
	static int[][] map;
	static boolean[][] visited;
	static int N;
	static int M;
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {-1, 0, 1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		// 테스트 개수
		Integer T = Integer.parseInt(br.readLine());

		while(T-- > 0){
			st = new StringTokenizer((br.readLine()));

			M = Integer.parseInt(st.nextToken()); // 가로
			N = Integer.parseInt(st.nextToken()); // 세로
			int K = Integer.parseInt(st.nextToken()); // 배추개수

			map = new int[N][M];
			visited = new boolean[N][M];
			worm = 0;

			// 배추 심기
			while(K-- > 0){
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				map[y][x] = 1;
			}

			// 밭 돌아다니기
			for(int i = 0; i < N; i++){
				for(int j = 0; j < M; j++){
					if(map[i][j] == 1 && !visited[i][j]){
						bfs(i, j);
						worm++;
					}
				}
			}
			sb.append(worm+"\n");
		}

		System.out.println(sb.toString());

	}

	static void bfs(int y, int x){

		// 움직일 수 있는 곳 저장
		Queue<int[]> queue = new LinkedList<>();

		// 첫 번째 삽입
		queue.offer(new int[]{y, x});

		// 움직일 곳이 있을 때까지
		while (!queue.isEmpty()) {

			int[] curr = queue.poll();

			// 4방향 움직이기
			for(int i = 0; i < 4; i++){
				int nextY = curr[0] + dy[i];
				int nextX = curr[1] + dx[i];

				if(nextY >= 0 && nextX >= 0 && nextY < N && nextX < M) {
					if(map[nextY][nextX] == 1 && !visited[nextY][nextX]){
						queue.offer(new int[]{nextY, nextX});
						visited[nextY][nextX] = true;
					}
				}
			}
		}

	}

	static void dfs(int curry, int currX){

		visited[curry][currX] = true;

		for(int i = 0; i < 4; i++){

			int nextY = curry + dy[i];
			int nextX = currX + dx[i];

			if(nextY >= 0 && nextX >= 0 && nextY < N && nextX < M) {
				if(map[nextY][nextX] == 1 && !visited[nextY][nextX]){
					dfs(nextY, nextX);
				}
			}
		}
	}
}
