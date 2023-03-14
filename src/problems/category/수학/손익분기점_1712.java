package problems.category.수학;

import java.util.Scanner;

public class 손익분기점_1712 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();

		
		if((C - B) <= 0) {
			System.out.println("-1");
		}
		else {
			System.out.println((A/(C-B)+1));
			
		}
		
	}
}
