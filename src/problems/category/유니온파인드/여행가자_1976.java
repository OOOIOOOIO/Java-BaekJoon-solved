package problems.category.유니온파인드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 여행가자_1976 {
	
	static int[] parent;
	static int N, M;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 도시 수
		N = Integer.parseInt(br.readLine());
		// 여행 계획
		M = Integer.parseInt(br.readLine());
		
		parent = new int[N];
				
		for(int i = 0; i < N; i++){
			parent[i] = i;
					
		}
		
		
		for(int i = 0; i < N; i++) {
			String[] arr = br.readLine().split(" ");
			for(int j = 0; j <N; j++) {
				if(Integer.parseInt(arr[j]) == 1) union(i, j);
			}
		}
		
		String[] plan = br.readLine().split(" ");
		boolean flag = false;
		
		for(int i = 0; i < plan.length-1; i++) {
			if(isSameParent(parent[Integer.parseInt(plan[i])-1], parent[Integer.parseInt(plan[i+1])-1])) {
				flag = true;
			}
			else {
				flag = false;
				break;
			}
		}
		
		if(flag) System.out.println("YES");
		else System.out.println("NO");
		
		
	
	
	}
	
	static int find(int v) {
		if(parent[v] == v) return v;
		else return parent[v] = find(parent[v]);
		
	}
	
	static void union(int v1, int v2) {
		v1 = find(v1);
		v2 = find(v2);
		
		if(v1 != v2) {
			if(v1 < v2) parent[v2] = v1;
			else parent[v1] = v2;
		}
	}
	
	static boolean isSameParent(int v1, int v2) {
		v1 = find(v1);
		v2 = find(v2);
		
		if(v1 == v2) return true;
		else return false;
	}
}








