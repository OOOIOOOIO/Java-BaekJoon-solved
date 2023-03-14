package problems.category.스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스택_10828_O {
	

	private int ptr;
	private int max;
	private int[] data;
	
	public 스택_10828_O() {;}
	
	public 스택_10828_O(int capacity) {
		this.max = capacity;
		ptr = 0;
		data = new int[max];
		
	}
	// empty
	public int empty() {
		if(ptr <= 0) {
			return 1;
		}
		
		return 0;
	}
	
	
	// push
	public  void push(int num) {
		data[ptr++] = num;
	}
	
	//pop
	public int pop() {
		if(ptr <= 0) {
			return -1;
		}
		
		return data[--ptr];
	}
	
	//size
	public int size() {
		return ptr;
	}
	
	
	// top
	public int top() {
		if(ptr <= 0) {
			return -1;
		}
		
		return data[ptr-1];
	}
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		
		스택_10828_O s = new 스택_10828_O(N);

		for (int i = 0; i < N; i++) {
			int num = 0;
			st = new StringTokenizer(br.readLine());
			String word = st.nextToken();
			if(st.hasMoreTokens()) num = Integer.parseInt(st.nextToken());
			
			switch(word) {
			
			
				case "push" :
					s.push(num);
					break;
					
				case "pop" :
					System.out.println(s.pop());
					break;
					
				case "size" :
					System.out.println(s.size());
					break;
					
				case "empty" :
					System.out.println(s.empty());
					break;
					
				case "top" :
					System.out.println(s.top());
					break;

			}
		}
		
	}
}
