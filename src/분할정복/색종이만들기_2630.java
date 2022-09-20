

package 분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
start ~ end

1 ~ N/2,

N/2+1 ~ N

8
1 1 0 0 0 0 1 1
1 1 0 0 0 0 1 1
0 0 0 0 1 1 0 0
0 0 0 0 1 1 0 0
1 0 0 0 1 1 1 1
0 1 0 0 1 1 1 1
0 0 1 1 1 1 1 1
0 0 1 1 1 1 1 1
*/
		
public class 색종이만들기_2630 {
	
	
	static int N;
	static int white, blue;
	static int[][] map;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		
		// 1~8
		map = new int[N+1][N+1];
		
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		divide(1, 1, N);
		System.out.println(white);
		System.out.println(blue);
	}
	
	// 나누는 곳
	static void divide(int row, int col, int size) { // int N 넣고 재귀로 돌리자
		

		if(check(row, col, size)) {
			if(map[row][col] == 0) white++;
			else blue++;
			return;
			
		}
		// 그냥 4등분 해버린다. 여기서 그냥 다 나눠버리고 바로바로 check
		int newSize = size/2;
		
		divide(row, col, newSize);	 
		divide(row, col+newSize, newSize);
		divide(row+newSize, col, newSize);
		divide(row+newSize, col+newSize, newSize);	
	}

	
	static boolean check(int row, int col, int size) { // int N 넣고 재귀로 돌리자
		
		int color = map[row][col];
		
		for(int i = row; i < row + size; i++) {
			for(int j = col; j < col + size; j++) {
				
				if(color != map[i][j]) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	

	
	
}



