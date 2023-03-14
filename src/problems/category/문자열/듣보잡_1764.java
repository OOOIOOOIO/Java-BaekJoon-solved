package problems.category.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 듣보잡_1764 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		ArrayList<String> list = new ArrayList<String>();
		int cnt = 0;
		
		for(int i = 0; i < N; i++) {
			map.put(br.readLine(), i);
		}
		
		for(int i = 0; i < M; i++) {
			String name = br.readLine();
			if(map.containsKey(name)) {
				cnt++;
				list.add(name);
			}
		}
		
		Collections.sort(list);
		
		System.out.println(cnt);
		list.forEach(a -> System.out.println(a));
		
	}
}
