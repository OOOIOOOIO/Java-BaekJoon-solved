package 브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 체스판다시칠하기_1018_O {
	public static int min = 64;
	
	
	public static void check(boolean arr[][],int a, int b) {
		// 수정할 개수
		int cnt = 0;
		
		// 시작 W B
		boolean color = arr[a][b];
		
		//여기선 끝값으로 돌려야한다.
		// 8*8 프레임으로 돌리기
		for(int i = a; i < a + 8; i++) {
			for(int j = b; j < b + 8; j++) {
				if(arr[i][j] != color) {
					cnt++;
				}
				color = (!color);
			}
			// 행이 바뀔 경우 시작하는 색은 이전 행의 반대여야하기 때문에 
			color = (!color);
		}
	
		cnt = Math.min(cnt, 64 - cnt);
		
		min = Math.min(min, cnt);
		
	}
	
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
	
		// 행 열 입력
		st = new StringTokenizer(br.readLine());
		// 행
		int N = Integer.parseInt(st.nextToken());
		// 열
		int M = Integer.parseInt(st.nextToken());
		// 체스판 만들기
		boolean[][] arr = new boolean[N][M];
		
		// 행 받아와서 체스판 완성하기
		for (int i = 0; i < N; i++) {
			String[] row = br.readLine().split("");
			for(int j = 0; j < M; j++) {
				if(row[j].equals("W")){
					arr[i][j] = true;
				}
				else {
					arr[i][j] = false;
				}
			}
		}
		
		
		//시작값들을 넘겨줘야한다.
		for(int i = 0; i < N -7; i++) {
			for(int j = 0; j < M - 7; j++) {
				check(arr, i, j);
				
			}
		}
		System.out.println(min);
	}
}






//for (int i = 0; i < N; i++) {
//	for(int j = 0; j < M; j++) {
//		System.out.print(arr[i][j]);
//	}
//	System.out.println();
//}