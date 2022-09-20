package 문자열;

import java.util.Scanner;

public class 숫자의합_11720 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		String data = sc.next();
		
		int sum = 0;
		
		for(int i = 0; i < N; i++) {
//			System.out.println(data.charAt(i) - '0');
			sum += data.charAt(i) - '0';
		}
		
		System.out.println(sum);
	}
}