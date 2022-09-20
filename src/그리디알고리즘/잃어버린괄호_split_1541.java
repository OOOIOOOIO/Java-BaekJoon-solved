package 그리디알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 잃어버린괄호_split_1541 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int sum = Integer.MAX_VALUE;
		
		String[] sub = br.readLine().split("-");
		
		for(int i = 0; i < sub.length; i++) {
			int temp = 0;
			
			// 정규식에 +는 의미가 있는 아이이므로 \\를 붙여서 문자로 만들어준다
			String[] add = sub[i].split("\\+"); 
			
			for(int j = 0; j < add.length; j++) {
				temp += Integer.parseInt(add[j]);
			}
			
					
			if(sum == Integer.MAX_VALUE) {
				sum = temp;
			}
			else {
				sum -= temp;
			}
			
		}
		
		System.out.println(sum);
		
	}
}
