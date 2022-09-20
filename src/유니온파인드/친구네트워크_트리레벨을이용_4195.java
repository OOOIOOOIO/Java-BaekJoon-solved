package 유니온파인드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
/*
2
3
Fred Barney
Barney Betty
Betty Wilma
3
Fred Barney
Betty Wilma
Barney Betty
 */
public class 친구네트워크_트리레벨을이용_4195 {
	
	static int[] parent;
	static int[] level;

	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		
		
		while(T-- > 0) {
			int F = Integer.parseInt(br.readLine());
			parent = new int[F*2]; // 3쌍으로 최대 들어올 수 있는 사람은 6명이므로 6칸을 만들어준다.
			level = new int [F*2];
			
			for(int i = 0; i < F*2; i++) {
				parent[i] = i; // 서로소 집합
				level[i] = 1; // 각 노드의 레벨들, 일단 각각 개별로 떨어져 있으므로 레벨을 1로 둔다.
			}
			
			int idx = 0; // 각 사람(노드) 들의 번호(위치)를 정의할 변수
			
			Map<String, Integer> map = new HashMap<String, Integer>();
			
			for(int i = 0; i < F; i++) {
				st = new StringTokenizer(br.readLine());
				String a = st.nextToken();
				String b = st.nextToken();
				
				// 중복 없이 각 노드의 번호(위치)를 부여
				if(!map.containsKey(a)) {
					map.put(a, idx++);
				}
				
				if(!map.containsKey(b)) {
					map.put(b, idx++);
				}
			
				sb.append(union(map.get(a), map.get(b))).append("\n");
			}
		
		}
		System.out.println(sb);
	
	}
	
	static int find(int v) {
		if(parent[v] == v) return v;
		else return parent[v] = find(parent[v]);
		
	}
	
	static int union(int v1, int v2) {
		v1 = find(v1);
		v2 = find(v2);
		
		if(v1 != v2) {
			if(v1 > v2) {
				int temp = v1;
				v1 = v2;
				v2 = temp;
			}
			
			parent[v2] = v1;
			
			// 각 노드들이 이어지면 노드의 레벨이 1씩 증가하므로 루트 노드에 1씩 증가시킨다. 
			level[v1] += level[v2];
			
			
		}
		
		return level[v1];
	}
	
	
	
}
