package problems.category.큐_덱_우선순위큐;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class 덱_10866_원형_O {
	
	static int front = 0;
	static int back = 0;
	static int size = 0;
	static int[] deque = new int[10000];
	
	/*
	 * Deque 배열에서 front가 최종적으로 가리키는 위치는 항상 비워둔다.
	 * 즉, 가장 앞에있는 원소는 front + 1이 된다.
	 * 
	 * 이유는 만약 front의 최종 위치에 원소를 넣게 되면 다음과 같
	 * 예외가 발생한다.
	 * 
	 * 예로들어  push_front(3) 을 실행하려 하는데 아무 원소도 없을 때  
	 * front--; 감소시킨 뒤 deque[front] = 3; 이 되면
	 * deque[9999] = 3; 이 된다. 이때 front = 9999; back = 0 이 된다.
	 * 
	 * 하지만 원소가 한 개만 있을 경우 해당 원소는 front 이자 back 원소가 된다.
	 * 이러한 경우를 방지하기 위해 deque[front] 에 원소를 넣은 뒤, 
	 * front = (front - 1 + array.length) % array.length; 을 해준다.
	 * 
	 * 결과적으로 front 요소 자체는 deque[(front + 1) % array.length] 위치에 자리한다.
	 * ((front + 1) % array.length == (front + 1) % 10000)
	 */
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
 
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			
			switch(s[0]) {
			
				case "push_front" : {
					push_front(Integer.parseInt(s[1]));
					break;
				}
				
				case "push_back" : {
					push_back(Integer.parseInt(s[1]));
					break;
				}
				
				case "pop_front" : {
					sb.append(pop_front()).append('\n');
					break;
				}
				
				case "pop_back" : {
					sb.append(pop_back()).append('\n');
					break;
				}
				
				case "size" : {
					sb.append(size()).append('\n');
					break;
				}
				
				case "empty" : {
					sb.append(empty()).append('\n');
					break;
				}
				
				case "front" : {
					sb.append(front()).append('\n');
					break;
				}
				
				case "back" : {
					sb.append(back()).append('\n');
					break;
				}
			}
			
		}
		System.out.println(sb);
	}
		
	
	static void push_front(int val) {
		// 원소를 먼저 넣은 뒤 front을 감소시킨다.
		deque[front] = val;
		// 음수가 되지 않도록 배열 크기만큼 더해준다.
		front = (front - 1 + 10000) % 10000;
		size++;
	}
	
	static void push_back(int val) {
		/*
		 *  deque[9999] 까지 꽉 찼을 경우 0으로 가리키기 위해
		 *  배열 크기만큼 나눠 나머지를 구한다.
		 */
		back = (back + 1) % 10000;
		size++;
		deque[back] = val;
	}
	
	static int pop_front() {
		if (size == 0) {
			return -1;
		} 
		/*
		 *  front + 1이 front 원소이므로 해당 원소를 임시 변수에 둔 뒤 
		 *  front 을 +1 증가시킨다.
		 */
		int ret = deque[(front + 1) % 10000];
		front = (front + 1) % 10000;
		size--;	
		return ret;
	}
	
	static int pop_back() {
		if (size == 0) {
			return -1;
		} 
		int ret = deque[back];
		back = (back - 1 + 10000) % 10000;
		size--;
		return ret;
	}
	
	static int size() {
		return size;
	}
	
	static int empty() {
		if(size == 0) {
			return 1;
		}
		return 0;
	}
	
	static int front() {
		if(size == 0) {
			return -1;
		}
		return deque[(front + 1) % 10000];
	}
	
	static int back() {
		if(size == 0) {
			return -1;
		}
		return deque[back];
	}
	
}
