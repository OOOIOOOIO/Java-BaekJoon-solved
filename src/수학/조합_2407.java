package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/*
 * nPm / m!
 */
public class 조합_2407 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		BigInteger n1 = BigInteger.ONE;
		BigInteger n2 = BigInteger.ONE;
		
		for(int i = 0; i < m; i++) {
			n1 = n1.multiply(new BigInteger(String.valueOf(n-i)));
			n2 = n2.multiply(new BigInteger(String.valueOf(i + 1)));
		
		}

		BigInteger result = n1.divide(n2);
		System.out.println(result);
		
	}
}
