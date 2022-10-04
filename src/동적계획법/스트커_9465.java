package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 
 7
10 30 10 50 100 20 40
20 40 30 50 60 20 80

dp는 규칙!
규칙을 끊어서 생각하자 흠
 */
public class 스트커_9465 {
	
	static int[][] map;
	static int[][] point;

	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			
			map = new int[2][N+1];
			point = new int[2][N+1];
			
			for(int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 1; j <= N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			point[0][1] = map[0][1];
			point[1][1] = map[1][1];
			
			
			for(int i = 2; i <= N; i++) {
				point[0][i] = Math.max(point[1][i-1], point[1][i-2]) + map[0][i];
				point[1][i] = Math.max(point[0][i-1], point[0][i-2]) + map[1][i];
				
			}
			
			System.out.println(Math.max(point[0][N], point[1][N]));
			
		}
	}
		
}
