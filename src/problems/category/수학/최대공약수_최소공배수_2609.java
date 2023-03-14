package problems.category.수학;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
 
public class 최대공약수_최소공배수_2609 {
	//  연제법
	// 두 정수 또는 두 정식인 a와 b가 있을 때, a를 b로 나눈 나머지 a'로 b를 나누고 그 나머지로 a'를 나누는 일을 완전히 나누어질 때까지 계속하여 a와 b의 최대 공약수를 구하는 방법. 
	// 단, a, b가 자연수일 때 a>b, 다항식일 때는 a의 차수가 b의 차수 이상이어야 한다.
	static int gcd(int a, int b) {
		if(b == 0) {
			return a;
		}
		else {
			return gcd(b, a % b);
		}
	}
	
	static int lcm(int a, int b) {
		int max;
		max = (a > b) ? a : b;
		while(true) {
			if((max % a == 0) && (max % b == 0)) {
				return max;
			}
			max++;
		}
	}
	
	static int lcm2(int a, int b) {
		int g = gcd(a, b);
		return g * (a/g) * (b/g);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		
		System.out.println(gcd(a, b)); // 최대공약수
		
		System.out.println(lcm(a, b)); // 최소공배수 -> a*b / gcd(a,b)도 최소공배수가 되는구나
		
		
	}
 
}