package 유니온파인드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 집합의표현_1717 {
	
	static int[] arr;
	static int[] parent;
	static StringBuilder sb = new StringBuilder();
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1];
		parent = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(command == 0) {
				union(a, b);
			}
			
			if(command == 1) {
				isSameParent(a, b);
			}
			
		}
		System.out.println(sb);
		
	}
	
	static int find(int x) {
		if(parent[x] == x) return x;
		else return parent[x] = find(parent[x]);
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a != b) {
			if(a < b) {
				parent[b] = a;
			}
			else {
				parent[a] = b;
			}
		}
		
	}
	
	static void isSameParent(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a == b) {
			sb.append("YES\n");
		}
		else {
			sb.append("NO\n");
		}
	}
}
