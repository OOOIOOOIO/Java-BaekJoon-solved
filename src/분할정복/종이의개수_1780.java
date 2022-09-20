package 분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*

9
0 0 0 1 1 1 -1 -1 -1
0 0 0 1 1 1 -1 -1 -1
0 0 0 1 1 1 -1 -1 -1
1 1 1 0 0 0 0 0 0
1 1 1 0 0 0 0 0 0
1 1 1 0 0 0 0 0 0
0 1 -1 0 1 -1 0 1 -1
0 -1 1 0 1 -1 0 1 -1
0 1 -1 1 0 -1 0 1 -1 
 
 */
public class 종이의개수_1780 {
	static int N, zero, one, minusOne;
	static int[][] map;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		
	
		map = new int[N][N];
		
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}		
		
		divide(0, 0, N);
		
		System.out.println(minusOne);
		System.out.println(zero);
		System.out.println(one);
	}
	
	static void divide(int row, int col, int size) {
		
		if(check(row, col, size)) {
			if(map[row][col] == 0) {
				zero++;
				return;
			}
			else if(map[row][col] == 1) {
				one++;
				return;
			}
			else {
				minusOne++;
				return;
			}
		}
		
		
		int newSize = size / 3;
		
		divide(row, col, newSize);
		divide(row, col+newSize, newSize);
		divide(row, col+newSize+newSize, newSize);

		divide(row+newSize, col, newSize);
		divide(row+newSize, col+newSize, newSize);
		divide(row+newSize, col+newSize+newSize, newSize);
		
		divide(row+newSize+newSize, col, newSize);
		divide(row+newSize+newSize, col+newSize, newSize);
		divide(row+newSize+newSize, col+newSize+newSize, newSize);
		
	}
	
	static boolean check(int row, int col, int size) {
		
		int num = map[row][col];
		
		for(int i = row; i < row+size; i++) {
			for(int j = col; j < col+size; j++) {
				if(num != map[i][j]) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	
}
