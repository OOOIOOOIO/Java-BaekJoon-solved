package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 내려가기_2096_시간초과 {
	final static int One = 0;
	final static int Two = 1;
	final static int Three = 2;
			
	static int N;
	static int dpMax[][];
	static int dpMin[][];
	static int cost[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		cost = new int[N][3];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int line_1 = Integer.parseInt(st.nextToken());
			int line_2 = Integer.parseInt(st.nextToken());
			int line_3 = Integer.parseInt(st.nextToken());
			
			cost[i][One] = line_1;
			cost[i][Two] = line_2;
			cost[i][Three] = line_3;
		}
		
		init();
		
		int maxP = Math.max(maxPoint(N - 1, One), Math.max(maxPoint(N - 1, Two), maxPoint(N - 1, Three)));

		int minP = Math.min(minPoint(N - 1, One), Math.min(minPoint(N - 1, Two), minPoint(N - 1, Three)));
		
		System.out.println(maxP + " " + minP);
	}
	static void init() {
		dpMax = new int[N][3];
		dpMax[0][One] = cost[0][One];
		dpMax[0][Two] = cost[0][Two];
		dpMax[0][Three] = cost[0][Three];

		dpMin = new int[N][3];
		dpMin[0][One] = cost[0][One];
		dpMin[0][Two] = cost[0][Two];
		dpMin[0][Three] = cost[0][Three];
		
		
	}
	static int maxPoint(int n, int line) {
		
		
		if(dpMax[n][line] == 0 && n > 0) {
			if(line == One) {
				dpMax[n][One] = Math.max(maxPoint(n-1, One), maxPoint(n-1, Two)) + cost[n][One];
				
			}
			else if(line == Two) {
				dpMax[n][Two] = Math.max(Math.max(maxPoint(n-1, One), maxPoint(n-1, Two)), maxPoint(n-1, Three)) + cost[n][Two];
				
			}
			else {
				dpMax[n][Three] = Math.max(maxPoint(n-1, Two), maxPoint(n-1, Three)) + cost[n][Three];
				
			}
			
		}
		
		return dpMax[n][line];
	}
	
	static int minPoint(int n, int line) {
		
		
		if(dpMin[n][line] == 0 && n > 0) {
			if(line == One) {
				dpMin[n][One] = Math.min(minPoint(n-1, One), minPoint(n-1, Two)) + cost[n][One];
				
			}
			else if(line == Two) {
				dpMin[n][Two] = Math.min(Math.min(minPoint(n-1, One), minPoint(n-1, Two)), minPoint(n-1, Three)) + cost[n][Two];
				
			}
			else {
				dpMin[n][Three] = Math.min(minPoint(n-1, Two), minPoint(n-1, Three)) + cost[n][Three];
				
			}
			
		}
		
		return dpMin[n][line];
	}
	
	
	
	
}
