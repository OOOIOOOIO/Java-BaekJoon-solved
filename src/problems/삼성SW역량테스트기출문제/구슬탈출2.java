package problems.삼성SW역량테스트기출문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
. : 빈 칸
# : 벽
O : 구멍 위치
R : 빨간구슬
B : 파란 구슬O
 
 
7 7
#######
#...RB#
#.#####
#.....#
#####.#
#O....#
#######
 
*/

public class 구슬탈출2 {
	
	static String[][] map;
	static boolean[][] rVisited;
	static boolean[][] bVisited;
	static int rX = 0, rY = 0, bX = 0, bY= 0;
					// 상 좌 하 우
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static int redCnt = 0;
	static int blueCnt = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 세로
		int M = Integer.parseInt(st.nextToken()); // 가로
		
		
		// 초기화
		map = new String[N][M];
		rVisited = new boolean[N][M];
		bVisited = new boolean[N][M];
		
		
		for(int i = 0; i < N; i++) {
			String[] temp = br.readLine().split("");
			for(int j = 0; j < M; j++) {
				map[i][j] = temp[j];
				if(temp[j].equals("R")) {
					rX = j;
					rY = i;
				}
				if(temp[j].equals("B")) {
					bX = j;
					bY = j;
				}
			}
		}
		
		
		bfs(rY, rX, bY, bX);
		
		
	}
	
	
	public static void bfs(int rY,int rX,int bY,int bX) {
		Queue<int[]> redQueue = new LinkedList<int[]>();
		Queue<int[]> blueQueue = new LinkedList<int[]>();
		
		
		redQueue.offer(new int[] {rY, rX});
		blueQueue.offer(new int[] {bY, bX});
		
		while(redQueue.isEmpty() && blueQueue.isEmpty()) {
			int[] red = redQueue.poll();
			int[] blue = blueQueue.poll();
			// 0 : 상 / 1 : 좌 / 2 : 하 / 3 : 우
			for(int i = 0; i < 4; i++) {
				
				
				int redY = red[0] - dy[i];
				int redX = red[1] - dx[i];
				int blueY = blue[0] - dy[i];
				int blueX = blue[1] - dx[i];
				
				// 뻥 뚫려 있을 때
				if(map[redY][redX].equals(".")) {
					 int[] curr = redMove(i,redY, redX);
					 redQueue.offer(curr);
				}
				
				if(map[blueY][blueX].equals(".")) {
					int[] curr = blueMove(i, blueY, blueX);
					blueQueue.offer(curr);
				}
				
				
				
			}
			
		}
		
		
	}
	
	public static int[] redMove(int i, int currY, int currX) {
		int[] curr = {};
		int nextY = currY - dy[i];
		int nextX = currX - dx[i];
		// 기울여서 벽과 만주쳤을 때
		if(map[nextY][nextX].equals("#")) {
			redCnt++;
			return curr;
		}
		// 뻥 뚫려 있을 때
		else if(map[nextY][nextX].equals(".")) {
			curr = redMove(i, nextY, nextX);
		}
		else if(map[nextY][nextX].equals("O")) {
			curr = new int[] {-1, redCnt};
			return curr;
		}
		return curr;
	}
	
	public static int[] blueMove(int i, int currY, int currX) {
		int[] curr = {};
		int nextY = currY - dy[i];
		int nextX = currX - dx[i];
		// 기울여서 벽과 만주쳤을 때
		if(map[nextY][nextX].equals("#")) {
			redCnt++;
			return curr;
		}
		// 뻥 뚫려 있을 때
		else if(map[nextY][nextX].equals(".")) {
			curr = blueMove(i, nextY, nextX);
		}
		else if(map[nextY][nextX].equals("O")) {
			curr = new int[] {-1, redCnt};
			return curr;
		}
		return curr;
	}
	
}
