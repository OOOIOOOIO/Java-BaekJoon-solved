package problems.category.분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Z {
	
	static int cnt = 0;
	static int r;
	static int c;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		int length = (int)Math.pow(2, N);
		
		
		
		divide(0, 0, length);

	}
	

	static void divide(int row, int col, int length) {
		
		// 2*2 사각형일 경우 더 재귀를 돌지 않고 여기서 끝난다.
		if(check(row, col, length)) {
			System.out.println(cnt);
			return;
			
		}
		
		// 2 * 2 사각형까지만 돌기 위해 1 * 1 사각형일 경우 종료한다.
		if(length == 1) return;

		int newLength = length / 2;
		
		/*
		 * 구역을 나누어 r행 c열에 속한 요소가 있는 2*2 사각형을 찾을 때 까지 재귀를 돈다.
		 * 만약 2*2 사각형을 찾을 경우 check에서 요소를 찾고 끝낸다.
		 * cnt는 각 재귀마다 출발 지점의 값이다.
		 */
		
		// 1사분면
		if(r < row+newLength && c < col+newLength) {
			divide(row, col, newLength); // 1
			
		}
		// 2사분면
		if(r < row+newLength && c >= col+newLength) {
			cnt += (length * length) /4;
			divide(row, col+newLength, newLength); // 2
			
		}
		// 3사분면
		if(r >= row+newLength && c < col+newLength) {
			cnt += ((length * length) /4)*2;
			divide(row+newLength, col, newLength); // 3
		}
		// 4사분면
		if(r >= row+newLength && c >= col+newLength) {
			cnt += ((length * length) /4)*3;
			divide(row+newLength, col+newLength, newLength); // 4
			
			
		}

		
	}
	
	static boolean check(int row, int col, int length) {
		
		
		if(length == 2) {
			for(int i = row; i < row+length; i++) {
				for(int j = col; j < col+length; j++) {
					if(r == i && c == j) {
						return true;
					}
					cnt++;
				}
			}
		}
		
		return false;
	}
	
	
}
