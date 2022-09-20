package 큐_덱_우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 큐2_18258_O {
	
	private int[] queue;
	private int max;
	private int frontE;
	private int rearE;
	StringBuilder sb = new StringBuilder();
	public 큐2_18258_O() {;}
	
	public 큐2_18258_O(int capacity) {
		this.max = capacity;
		frontE = 0;
		rearE = 0;
		queue = new int[max];
	}
	
	
	public void push(int num) {
		queue[rearE++] = num;
	}
	
	
	public void pop() {
		if(frontE == rearE) sb.append(-1).append("\n");
		else sb.append(queue[frontE++]).append("\n");
	}
	
	
	public void size() {
	    sb.append(rearE - frontE).append("\n");
	}
	
	
	public void empty() {
		if(frontE == rearE) sb.append(1).append("\n");
		
		else sb.append(0).append("\n");
	}
	
	
	public void front() {
		if(frontE == rearE) sb.append(-1).append("\n");
		
        
		else sb.append(queue[frontE]).append("\n");
		
	}
	
	public void back() {
		if(frontE == rearE) sb.append(-1).append("\n");
		
        else sb.append(queue[rearE - 1]).append("\n");
		
	}
	
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String command ="";
		int data = 0;
		
		int N = Integer.parseInt(br.readLine());
		
		큐2_18258_O q = new 큐2_18258_O(N);
		
		StringTokenizer st;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			command = st.nextToken();
			if(st.hasMoreTokens()) data = Integer.parseInt(st.nextToken());
			
			switch(command) {
			
				case "push" :
					q.push(data);
					break;
					
				case "pop" :
                    q.pop();
					break;
					
				case "size" :
                    q.size();
					break;
					
				case "empty" :
                    q.empty();
					break;
					
				case "front" :
                    q.front();
					break;
					
				case "back" :
                    q.back();
					break;
							
			}
		}
        System.out.println(q.sb);
	}
}
