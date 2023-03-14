package problems.category.dfs_bfs_그래프순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DSLR_9019 {
	static boolean[] visited;
	static String[] ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		
		while(T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			visited = new boolean[10000];
			ans = new String[10000];
			Arrays.fill(ans, "");
			
			bfs(A, B);
		}
		
	}
	
	static void bfs(int start, int target) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			
			if(curr == target) {
				break;
			}
			
			int D = (curr * 2) % 10000;
			int S = (curr == 0 ? 9999 : curr -1);
			int L = (curr % 1000) * 10 + (curr / 1000);
			int R = (curr / 10) + (curr % 10) * 1000;
			
			if(!visited[D]) {
				queue.offer(D);
				visited[D] = true;
				ans[D] = ans[curr] + "D"; 
			}
			if(!visited[S]) {
				queue.offer(S);
				visited[S] = true;
				ans[S] = ans[curr] + "S"; 
				
			}
			if(!visited[L]) {
				queue.offer(L);
				visited[L] = true;
				ans[L] = ans[curr] + "L"; 
				
			}
			if(!visited[R]) {
				queue.offer(R);
				visited[R] = true;
				ans[R] = ans[curr] + "R"; 
				
			}
			
		}
		System.out.println(ans[target]);
		
	}
}


