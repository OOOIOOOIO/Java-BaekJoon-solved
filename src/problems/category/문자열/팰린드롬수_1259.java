package problems.category.문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class 팰린드롬수_1259{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		while(true) {
			String input = br.readLine();
			if(input.equals("0")) {
				break;
			}
			
			String[] arr = input.split("");
			boolean flag = false;
			int last = arr.length-1; //last 5 
			
			for(int i = 0; i < arr.length; i++) {
				if(i > last) {
					break;
				}
				
				if(arr[i].equals(arr[last--])) {
					flag = true;
				}
				else {
					flag = false;
					break;
				}
				
			}
			if(flag) {
				sb.append("yes").append("\n");
			}
			else {
				sb.append("no").append("\n");
			}
		}
		
		System.out.println(sb);
		
	}
 

 
}