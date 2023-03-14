package problems.category.dfs_bfs_그래프순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
/*
5
RRRBB
GGBBB
BBBRR
BBRRR
RRRRR
 */
public class 적록색약_10026 {
	static int N;
	
	static String[][] mapNomal;
	static String[][] mapBlind;
	
	static boolean[][] visitedNomal;
	static boolean[][] visitedBlind;
	
	static int[] dx = {0, -1, 0, 1}; // j
	static int[] dy = {-1, 0, 1, 0}; // i
	
	static int[] resultNomal = {0, 0, 0}; // 0 : R / 1 : G / 2 : B
	static int[] resultBlind = {0, 0}; // 0 : R G / 2 : B
	
	static class Node{
		int y;
		int x;
		String word;
		
		public Node(int y, int x, String word) {
			this.y = y;
			this.x = x;
			this.word = word;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		mapNomal = new String[N][N];
		mapBlind = new String[N][N];
		visitedNomal = new boolean[N][N];
		visitedBlind = new boolean[N][N];
		
		// mapping
		for(int i = 0; i < N; i++) {
			String[] temp = br.readLine().split("");
			
			for(int j = 0; j < N; j++) {
				mapNomal[i][j] = temp[j];
				
				if(temp[j].equals("G")) {
					mapBlind[i][j] = "R";
				}
				else {
					mapBlind[i][j] = temp[j];
				}
			}
		}
		
		// 시작
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visitedNomal[i][j]) {
					bfsNomal(i, j);
					check(mapNomal[i][j], "nomal");
				}
				if(!visitedBlind[i][j]) {
					bfsBlind(i, j);
					check(mapNomal[i][j], "blind");
					
				}
			}
		}
		
		// result
		int nomal = Arrays.stream(resultNomal).sum();
		int blind = Arrays.stream(resultBlind).sum();
		System.out.println(nomal + " " + blind);
		
	}
	
	static void bfsNomal(int y, int x) {
		Queue<Node> queue = new LinkedList<Node>();
		
		queue.offer(new Node(y, x, mapNomal[y][x]));
		visitedNomal[y][x] = true;
		
		while(!queue.isEmpty()) {
			Node curr = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int nextY = curr.y + dy[i];
				int nextX = curr.x + dx[i];
				
				if(nextY < N && nextX < N && nextY >= 0 && nextX >= 0) {
					if(!visitedNomal[nextY][nextX]) {
						String nextWord = mapNomal[nextY][nextX];
						
						if(curr.word.equals(nextWord)) {
							queue.offer(new Node(nextY, nextX, nextWord));
							visitedNomal[nextY][nextX] = true;
							
						}
					}
				}
			}
			
		}
		
	}
	static void bfsBlind(int y, int x) {
		Queue<Node> queue = new LinkedList<Node>();
		
		queue.offer(new Node(y, x, mapBlind[y][x]));
		visitedBlind[y][x] = true;
		
		while(!queue.isEmpty()) {
			Node curr = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int nextY = curr.y + dy[i];
				int nextX = curr.x + dx[i];
				
				if(nextY < N && nextX < N && nextY >= 0 && nextX >= 0) {
					if(!visitedBlind[nextY][nextX]) {
						String nextWord = mapBlind[nextY][nextX];
						
						if(curr.word.equals(nextWord)) {
							queue.offer(new Node(nextY, nextX, nextWord));
							visitedBlind[nextY][nextX] = true;
							
						}
					}
				}
			}
			
		}
		
	}
	
	static void check(String word, String cri) {
		if(cri.equals("nomal")) {
			if(word.equals("R")) {
				resultNomal[0]++;
			}
			else if(word.equals("G")) {
				resultNomal[1]++;
			}
			else {
				resultNomal[2]++;
			}
			
		}
		else {
			if(word.equals("R")) {
				resultBlind[0]++;
			}
			else {
				resultBlind[1]++;
			}
			
		}
	}
}
