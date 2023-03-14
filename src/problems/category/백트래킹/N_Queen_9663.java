package problems.category.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_Queen_9663 {
	static int N;
	static boolean[] flag_row; // 행에 있는지에 대한 유무
	static boolean[] flag_crossUp; // 좌측하단에서 우측상단을 가로지르는 대각선
	static boolean[] flag_crossDown; // 좌측상단에서 우측하단을 가로지르는 대각선
	static int[] pos; // 퀸의 위치 pos[열] = 행 ==> 칸
	static int cnt;
	
	// i열의 알맞은 위치에 퀸을 배치
	static void set(int i) {
		
		// 행(j)을 움직이면서, 열(i)을 채워 넣는다.
		for(int j = 0; j < N; j++) {
			
			if(!flag_row[j] && !flag_crossUp[i+j] && !flag_crossDown[i - j + (N-1)]) { // j행에 퀸이 없다면
				pos[i] = j; // i열, j행에 퀸 배치
				
				// 모든 열에 배치하였다면
				if(i == (N-1)) {
					cnt++;
					return;
				}
				else {
					flag_row[j] = flag_crossUp[i+j] = flag_crossDown[i - j + (N-1)] = true;
//					flag_row[j] = flag_crossUp[i+j] = flag_crossDown[i - j + 7] = true;
					
					set(i+1);
					
					flag_row[j] = flag_crossUp[i+j] = flag_crossDown[i - j + (N-1)] = false;
//					flag_row[j] = flag_crossUp[i+j] = flag_crossDown[i - j + 7] = false;
				}
				
			}
	
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		flag_row = new boolean[N]; // 행에 있는지에 대한 유무
		flag_crossUp = new boolean[N + N -1]; // 좌측하단에서 우측상단을 가로지르는 대각선
		flag_crossDown = new boolean[N + N -1]; // 좌측상단에서 우측하단을 가로지르는 대각선
		pos = new int[N]; // 퀸의 위치 pos[열] = 행 ==> 칸
		
		// 열을 넣는다
		set(0);
		
		System.out.println(cnt);
	}
}
