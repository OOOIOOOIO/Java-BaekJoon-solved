package problems.category.문자열;

import java.util.Scanner;

public class 단어의개수_1152 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 공백 제거해서 받기(.isemty()를 하기위해)
		String word = sc.nextLine().trim();
		
 		
		String splitWord[] = word.split(" ");

		if(word.isEmpty()) System.out.println("0");
		
		
		else System.out.println(splitWord.length);
	
	}
}