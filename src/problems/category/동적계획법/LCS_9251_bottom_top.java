package problems.category.동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS_9251_bottom_top {
	
	static Integer topDown[][];
	static int bottomUp[][];
	static String str1;
	static String str2;
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		str1 = br.readLine();
		str2 = br.readLine();
		
		// topDown
		// ↓ str2, → str1 로 2차원을 만들어야된다!
		topDown = new Integer[str2.length()][str1.length()];
		
		// bottomUP
		// ↓ str2, → str1 로 2차원을 만들어야된다! 또한 이전 요소와 비교하므로 크기를 +1 해준다.
		bottomUp = new int[str1.length() + 1][str2.length() + 1]; 
		
		for(int i = 1; i <= str1.length(); i++) {
			
			for(int j = 1; j <= str2.length(); j++) {

				if(str1.charAt(i-1) == str2.charAt(j-1)) {
					bottomUp[i][j] += bottomUp[i-1][j-1]+1;
				}
				else {
					bottomUp[i][j] = Math.max(bottomUp[i-1][j], bottomUp[i][j-1]); // 다 채워줘야 한다.
				}
				
			}
		}


		for(int i = 1; i <= str1.length(); i++) {

			for(int j = 1; j <= str2.length(); j++) {
				System.out.print(bottomUp[i][j]);
			}
			System.out.println();
		}

		
		// bottomUp
		System.out.println(bottomUp[str1.length()][str2.length()]);
		
		// topDown
		System.out.println(LCS(str2.length()-1, str1.length()-1));

		for(int i = 1; i <= str1.length(); i++) {

			for(int j = 1; j <= str2.length(); j++) {
				System.out.print(bottomUp[i][j]);
			}
			System.out.println();
		}
	}
	
	static int LCS(int y, int x) {
		
		if(y == -1 || x == -1) return 0;
		
		if(topDown[y][x] == null) {
			if(str2.charAt(y) == str1.charAt(x)) {
				topDown[y][x] = LCS(y-1, x-1) + 1;
			}
			else {
				topDown[y][x] = Math.max(LCS(y-1, x),  LCS(y, x-1));
			}
		}
		
		return topDown[y][x];
	}
}
