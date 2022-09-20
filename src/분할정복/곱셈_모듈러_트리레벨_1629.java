package 분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*

  모듈러 합 공식
 
(a * b) % C = ((a % C)*(b % C)) % C

(temp * temp * A) % C = ((temp * temp % C) * (A % C)) % C
					  = (((temp * temp % C) % C) * (A % C)) % C 	// (temp * temp % C) = (temp * temp % C) % C
					  = ((temp * temp % C) * A) % C
 */
public class 곱셈_모듈러_트리레벨_1629 {
	
	static int result, temp;
	static boolean flag;
	static long A, B, C;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		
		System.out.println(pow(A, B));
		
	}
	
	static long pow(long A, long exponent) { // A : 밑, ex : 지수
		
		// 지수가 1일 경우 A^1이므로 A를 그대로 리턴
		if(exponent == 1) {
			return A % C;
		}
		
		// 지수의 절반에 해당하는 A^(ex/2)를 구한다.(분할)
		long temp = pow(A, exponent/2);
		
		// 지수가 홀수라면
		// 2^5 == 2^2 * 2^2 * 2
		if(exponent % 2 == 1) {
			return ((((temp * temp) % C) * A) % C);
//			return ((temp * temp % C) * (A % C)) % C;
		}
		
		// 지수가 짝수라면
		return (temp * temp % C);
	}
	
	
	
}
