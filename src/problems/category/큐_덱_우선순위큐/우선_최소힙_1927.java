package problems.category.큐_덱_우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 우선_최소힙_1927 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		Queue<Integer> queue = new PriorityQueue<Integer>();
		StringBuilder sb = new StringBuilder();
		
		// 개수
		int N = Integer.parseInt(br.readLine());
		// 정수
		
		while(N-- > 0) {
			int X  = Integer.parseInt(br.readLine());
			
			if(X == 0) {
				if(!(queue.isEmpty())) {
					sb.append(queue.poll()).append("\n");
				}else {
					sb.append(0).append("\n");
				}
			}
			else {
				queue.offer(X);
			}
			
		}
		
		System.out.println(sb);
	}
}
