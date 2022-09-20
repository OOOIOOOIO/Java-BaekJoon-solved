package 유니온파인드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사이클게임_20040 {
	
	static int n, m;
	static int[] parent;
	static int cnt;
	static boolean flag;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		parent = new int[n];
		
		
		for(int i = 0; i < n; i++) {
			parent[i] = i;
		}
		
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			// 같은 부모가 아닐 경우 union
			if(!(isSameParent(v1, v2))) {
				cnt++;
				union(v1, v2);
			}
			// 같은 부모일 경우 == cycle
			else {
				flag = true;
				break;
			}
		}
		
		
		
		if(flag) {
			System.out.println(cnt+1);
		}
		else {
			System.out.println(0);
		}
		
		
		
	}
	
	static int find(int v) {
		if(parent[v] == v) return v;
		else return parent[v] = find(parent[v]);
	}
	
	static void union(int v1, int v2) {
		v1 = find(v1);
		v2 = find(v2);
		
		if(v1 != v2) {
			if(v1 < v2) {
				parent[v2] = v1;
			}
			else {
				parent[v1] = v2;
			}
		}
	}
	
	static boolean isSameParent(int v1, int v2) {
		v1 = find(v1);
		v2 = find(v2);
		
		if(v1 == v2) {
			return true;
		}
		else {
			return false;
		}
	}
}