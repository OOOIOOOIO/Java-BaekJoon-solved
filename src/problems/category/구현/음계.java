package problems.category.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 음계 {
	public static void main(String[] args) throws IOException{
		String[] asc = {"1", "2", "3", "4", "5", "6", "7", "8"};
		String[] desc = {"8", "7", "6", "5", "4", "3", "2", "1"};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] a = br.readLine().split(" ");
		
		boolean flag1 = false;
		boolean flag2 = false;
		boolean flag3 = false;
		// asc
		if(a[0].equals("1")) {
			for(int i = 0; i < a.length; i++) {
				if(!asc[i].equals(a[i])) {
					flag1 = true;
					break;
				}
			}
			
			flag2 = true;
		}
		//desc
		else if(a[0].equals("8")) {
			for(int i = 0; i < a.length; i++) {
				if(!desc[i].equals(a[i])) {
					flag1 = true;
					break;
				}
			}
			
			flag3 = true;
		}
		else{
			flag1 = true;
		}

		
		if(flag1) {
			System.out.println("mixed");
			
		}
		else if(flag2) {
			System.out.println("ascending");
		}
		else {
			System.out.println("descending");
		}
		
		// 출력
		
	}
}
