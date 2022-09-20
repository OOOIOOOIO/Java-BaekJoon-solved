package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수정렬하기3_10989_CountingSort_O {
	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			int N = Integer.parseInt(br.readLine());
			
			int[] count = new int[N];
			
			for(int i = 0; i < N; i++) {
				count[Integer.parseInt(br.readLine())]++; // 3이 몇개 들어갔는지 
			}
			
			// for문에서 바로 print로 찍어내는 것 보다 저렇게 한번에 찍어 내는 게 더 빠르다.
			// 앞으로 배열같은 걸 출력할 일이 있다면 Stringbuilder 나 StringBuffer를 사용하도록.
			StringBuilder sb = new StringBuilder();
			
			for(int i = 1; i < 10001; i++) {
                if(count[i] == 0) continue;
				for(int j = 0; j < count[i]; j++) {
					sb.append(i).append("\n");
				}
						
			}
			
			System.out.println(sb);
	}
}