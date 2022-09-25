package dfs_bfs_그래프순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 거짓말_1043 {
	static ArrayList<Integer> tList = new ArrayList<Integer>();
	static Map<Integer, ArrayList<Integer>> map = new HashMap<>();
	static boolean[] truth;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		truth = new boolean[N+1];
		
		st = new StringTokenizer(br.readLine());
		
		int num = Integer.parseInt(st.nextToken());
		
		while(st.hasMoreTokens()) {
			int person = Integer.parseInt(st.nextToken());
			tList.add(person);
			truth[person] = true;
		}
		

		
		
		
				
	}
}
