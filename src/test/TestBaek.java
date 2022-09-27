package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class TestBaek {


	    static int[][] d;
	    static int[][] d2;
	    static int[][] arr;

	    static int solve(int i, int j) {
	        if (d[i][j] != -1)
	            return d[i][j];
	        
	        if (i == n - 1)
	            return arr[i][j];
	        
	        d[i][j] = 0;
	        
	        if (j == 0)
	            d[i][j] = arr[i][j] + Math.max(solve(i + 1, 0), solve(i + 1, 1));
	        else if (j == 1)
	            d[i][j] = arr[i][j] + Math.max(solve(i + 1, 0), Math.max(solve(i + 1, 1), solve(i + 1, 2)));
	        else if (j == 2)
	            d[i][j] = arr[i][j] + Math.max(solve(i + 1, 1), solve(i + 1, 2));
	        return d[i][j];
	    }

	    static int solve2(int i, int j) {
	        if (d2[i][j] != 987654321)
	            return d2[i][j];
	        
	        if (i == n - 1)
	            return arr[i][j];
	        
	        d2[i][j] = 0;
	        
	        if (j == 0)
	            d2[i][j] = arr[i][j] + Math.min(solve2(i + 1, 0), solve2(i + 1, 1));
	        else if (j == 1)
	            d2[i][j] = arr[i][j] + Math.min(solve2(i + 1, 0), Math.min(solve2(i + 1, 1), solve2(i + 1, 2)));
	        else if (j == 2)
	            d2[i][j] = arr[i][j] + Math.min(solve2(i + 1, 1), solve2(i + 1, 2));
	        return d2[i][j];
	    }

	    static int n;
	    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	    public static void main(String[] args) throws IOException {
	        n = Integer.parseInt(br.readLine());
	        d = new int[n][3];
	        d2 = new int[n][3];
	        arr = new int[n][3];
	        for (int i = 0; i < n; i++) {
	            StringTokenizer st = new StringTokenizer(br.readLine());
	            arr[i][0] = Integer.parseInt(st.nextToken());
	            arr[i][1] = Integer.parseInt(st.nextToken());
	            arr[i][2] = Integer.parseInt(st.nextToken());
	            Arrays.fill(d[i], -1);
	            Arrays.fill(d2[i], 987654321);
	        }
	        int max = Math.max(Math.max(solve(0, 0), solve(0, 1)), solve(0, 2));
	        int min = Math.min(Math.min(solve2(0, 0), solve2(0, 1)), solve2(0, 2));
	        System.out.println(max + " " + min);


	    }
	}
