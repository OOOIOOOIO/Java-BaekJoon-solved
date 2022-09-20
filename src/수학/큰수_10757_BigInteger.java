package 수학;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class 큰수_10757_BigInteger {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] arr = br.readLine().split(" ");
		System.out.println(new BigInteger(arr[0]).add(new BigInteger(arr[1])));
		
/*
	 int는 메모리 크기는 4byte로 표현할 수 있는 범위는 -2,147,483,648 ~ 2,147,483,647이고 
	long은 메모리 크기는 8byte로 표현할 수 있는 범위는 -9,223,372,036,854,775,808 ~ 
	9,223,372,036,854,775,807이다. 기본 연산으로는 이 범위를 넘어가면 에러가 나며 개발 혹은 
	알고리즘 문제를 풀 때 무한의 정수 혹은 범위를 넘어가는 연산일 경우 BigInteger를 써야한다. 
	
	 수가 너무 크면, 약 int -2,150,000,000 ~ -2,150,000,000 범위를 넘어가면 일반적은 연산으로는 불가능
		
	 일반적으로 1! ~ 20!(팩토리얼)이 최대 넘어서면 BigInteger 사용 
	 long은 9,~~,~... ","이 6개
	 
	< 선언하기 >
	
	BigInteger num1 = new BigInteger("2498619848418918")
	--> 문자열로 선언을 해줘야한다.
	
	
	< 형 변환 >
	
	BigInteger bigNumber = BigInteger.valueOf(100000); //int -> BigIntger
	--> int a = Integer.valueOf("101") 같은 느낌. String -> int

	int int_bigNum = bigNumber.intValue(); //BigIntger -> int
	long long_bigNum = bigNumber.longValue(); //BigIntger -> long
	float float_bigNum = bigNumber.floatValue(); //BigIntger -> float
	double double_bigNum = bigNumber.doubleValue(); //BigIntger -> double
	String String_bigNum = bigNumber.toString(); //BigIntger -> String
	
	< 연산 >
	
	BigInteger bigNumber1 = new BigInteger("100000");
	BigInteger bigNumber2 = new BigInteger("10000");
			
	System.out.println("덧셈(+) :" +bigNumber1.add(bigNumber2));
	System.out.println("뺄셈(-) :" +bigNumber1.subtract(bigNumber2));
	System.out.println("곱셈(*) :" +bigNumber1.multiply(bigNumber2));
	System.out.println("나눗셈(/) :" +bigNumber1.divide(bigNumber2));
	System.out.println("나머지(%) :" +bigNumber1.remainder(bigNumber2));
  
  	< 비교 >
  	
	BigInteger bigNumber1 = new BigInteger("100000");
	BigInteger bigNumber2 = new BigInteger("1000000");
			
	// .compareTo -->  compareTo 맞으면 0   틀리면 -1
	int compare = bigNumber1.compareTo(bigNumber2);
	System.out.println(compare);
 */
		
		
		
		
		
		
//		< 일반적인 연산 >
//		String str = br.readLine();
//		StringTokenizer st = new StringTokenizer(str);
//		
//		bw.write((Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())) + "\n");
//		bw.close();
		
//		실험
//		bw.write(st.nextToken() + st.nextToken() + "\n");
//		System.out.println("af");
//		bw.write("김성호");
//		bw.close();
		
		
	
	}
}
