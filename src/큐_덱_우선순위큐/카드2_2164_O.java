package 큐_덱_우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class 카드2_2164_O {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer> dq = new ArrayDeque<Integer>();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= N; i++) {
			dq.addLast(i);
		}
		
		while(true) {
			if(dq.size() == 1) break;
			dq.removeFirst();
			dq.addLast(dq.removeFirst());
		}
//		System.out.println(dq.size());
		System.out.println(dq.peekFirst());
	}
}
