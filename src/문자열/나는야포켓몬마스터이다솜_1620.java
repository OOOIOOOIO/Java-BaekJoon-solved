package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 나는야포켓몬마스터이다솜_1620 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		// N : 총 포멧몬 개수
		// M : 내가 맞춰야 하는 개수
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		/*
		 * 문자열은 map이 젤 낫다. 도구는 아끼지 말자
		 */
		String[] list = new String[N+1];
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		for(int i = 1; i <= N; i++) {
			list[i] = br.readLine();
			map.put(list[i], i);
		}
		
		
		
		// 문자 : 몇번쨰 인덱스에 있는지
		// 숫자 : 숫자에 해당하는 값
		while(M-- > 0) {
			String temp = br.readLine();
			
			try {
				int idx = Integer.parseInt(temp);
				sb.append(list[idx]).append("\n");
				
			} catch (NumberFormatException e) {
				sb.append(map.get(temp)).append("\n");
			}
			
		}
		
		System.out.println(sb.toString());
		
	}
}
