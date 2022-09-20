package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 좌표압축_18870_HashMap사용_O {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		String[] Data = br.readLine().split(" ");
		
		int[] cor = new int[N];
		
		int cnt = 0;
		
		// 좌표 받기
		for (int i = 0; i < Data.length; i++) {
			cor[i] = Integer.parseInt(Data[i]);
		}
		
		// 복사하기
		int[] corClone = cor.clone();
		
		// 정렬(복사한 배열). 정렬을 함으로써 인덱스 번호가 순위가 됨
		Arrays.sort(corClone);
		
		// Map으로 카운팅하기(key는 중복되지 않으니까  Map 써야됨)
		Map<Integer, Integer> hMap = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < corClone.length; i++) {
			if(hMap.containsKey(corClone[i])) continue;
			
			hMap.put(corClone[i], cnt++);
			
		}
		
		
		for (int i = 0; i < cor.length; i++) {
			cor[i] = hMap.get(cor[i]);
			sb.append(cor[i]).append(" ");
			
		}
		
		
		
		System.out.println(sb);	
			
		
	}
}