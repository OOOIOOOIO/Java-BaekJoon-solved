package problems.test;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class TestBaek {
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

	}

	static void divide(int y, int x, int length){

		// 종료
		if(check(y, x, length)){
			if(map[y][x] == 0){
				white++;
			}
			else{
				blue++;
			}
			return;
		}

		int newLength = length/2;

		divide(y, x, length);
		divide(y, x + newLength, length);
		divide(y + newLength, x, length);
		divide(y + newLength, x + newLength, length);




	}

	static boolean check(int y, int x, int length){

		int color = map[y][x];

		for(int i = y; i < y+length; i++) {
			for (int j = 1; j <= x+length; j++) {
				if(color != map[i][j]) return false;
			}
		}

		return true;
	}


}