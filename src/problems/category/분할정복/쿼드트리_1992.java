package problems.category.분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
8
11110000
11110000
00011100
00011100
11110000
11110000
11110011
11110011
 */
public class 쿼드트리_1992 {
	
	static int N;
	static int[][] map;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			String[] line = br.readLine().split("");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(line[j]);
			}
		}
		
		divide(0, 0, N);
		System.out.println(sb);
		
	}
	
	
	static void divide(int row, int col, int size) {
		
		if(check(row, col, size)) {
			int num = map[row][col];
			
			if(num == 0) {
				sb.append(0);
				return;
			}else {
				sb.append(1);
				return;
			}
		}
		
		int newSize = size/2;
		// 각 분면의 모든 사이클이 끝나면 닫아주고
		divide(row, col, newSize); // 1사
		divide(row, col+newSize, newSize); // 2사
		divide(row+newSize, col, newSize); // 3사
		divide(row+newSize, col+newSize, newSize); // 4사
		sb.append(")");
		
	}
	
	static boolean check(int row, int col, int size) {
		
		int num = map[row][col];
		
		for(int i = row; i < row+size; i++) {
			for(int j = col; j < col+size; j++) {
				if(num != map[i][j]) {
					// 분면이 나눠질 때마다 열어주고!
					sb.append("(");
					return false;
				}
			}
		}
		
		return true;
	}
	
}
