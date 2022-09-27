package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class 내려가기_2096_sliding_window_재귀법 {

	final static int One = 0;
	final static int Two = 1;
	final static int Three = 2;
	
    static int N;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] maxDP;
    static int[][] minDP;
    static int[][] cost;


    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        maxDP = new int[N][3];
        minDP = new int[N][3];
        cost = new int[N][3];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cost[i][One] = Integer.parseInt(st.nextToken());
            cost[i][Two] = Integer.parseInt(st.nextToken());
            cost[i][Three] = Integer.parseInt(st.nextToken());
            
            // cost에 0이 포함되고 위로 올라가기 때문에 초기화를 해줘야 한다.
            Arrays.fill(maxDP[i], -1);
            Arrays.fill(minDP[i], 987654321);
        }
        
        int max = Math.max(Math.max(maxPoint(0, One), maxPoint(0, Two)), maxPoint(0, Three));
        int min = Math.min(Math.min(minPoint(0, One), minPoint(0, Two)), minPoint(0, Three));
        
        System.out.println(max + " " + min);


    }
    
    static int maxPoint(int n, int line) {
        if (maxDP[n][line] != -1)
            return maxDP[n][line];
        
        if (n == N - 1)
            return cost[n][line];
        
        maxDP[n][line] = 0;
        
        if (line == One)
            maxDP[n][line] = cost[n][line] + Math.max(maxPoint(n + 1, One), maxPoint(n + 1, Two));
        else if (line == Two)
            maxDP[n][line] = cost[n][line] + Math.max(maxPoint(n + 1, One), Math.max(maxPoint(n + 1, Two), maxPoint(n + 1, Three)));
        else if (line == Three)
            maxDP[n][line] = cost[n][line] + Math.max(maxPoint(n + 1, Two), maxPoint(n + 1, Three));
        
        return maxDP[n][line];
    }

    static int minPoint(int n, int line) {
        if (minDP[n][line] != 987654321)
            return minDP[n][line];
        
        if (n == N - 1)
            return cost[n][line];
        
        minDP[n][line] = 0;
        
        if (line == One)
            minDP[n][line] = cost[n][line] + Math.min(minPoint(n + 1, One), minPoint(n + 1, Two));
        else if (line == Two)
            minDP[n][line] = cost[n][line] + Math.min(minPoint(n + 1, One), Math.min(minPoint(n + 1, Two), minPoint(n + 1, Three)));
        else if (line == Three)
            minDP[n][line] = cost[n][line] + Math.min(minPoint(n + 1, Two), minPoint(n + 1, Three));
      
        return minDP[n][line];
    }
}
