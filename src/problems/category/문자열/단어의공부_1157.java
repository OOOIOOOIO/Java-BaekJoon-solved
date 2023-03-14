package problems.category.문자열;

import java.util.Scanner;

public class 단어의공부_1157 {
	public static void main(String[] args) {
		int[] cnt = new int[26]; // 0으로 알아서 초기화 됨
		int max = 0;
		char result = '?';
		Scanner sc = new Scanner(System.in);
		
		// 소문자로 받기
		String word = sc.next().toUpperCase();
		
		
		
		for(int i = 0; i < word.length(); i++) {
            // 글자 수 세기
			cnt[word.charAt(i) - 65]++;
			
            // 최대비교
			if(cnt[word.charAt(i) - 65] > max) {
			    max = cnt[word.charAt(i) - 65];
				result = word.charAt(i);
			}
			else if(cnt[word.charAt(i) - 65] == max) result = '?'; 
			
		}
		System.out.println(result);
        
    }
}	
		
		// 아스키 코드 넣기 1행 : A-Z, 2행 : a-z
//		for(int i = 0; i < 2; i++) {
//			for(int j = 0; j < 26; j++) {
//				if(i == 0) ASCII[i][j] = (char)(65 + j);
//				else ASCII[i][j] = (char)(65 + j + 32); 
//			}
//		}
//		
//		 아스키 코드가 잘 들어갔는지 확인해보기
//		for(int i = 0; i < 2; i++) {
//			for(int j = 0; j < 26; j++) {
//				System.out.println(ASCII[i][j]);
//			}
//		}

		
		
		
		
		
//	}
//}
