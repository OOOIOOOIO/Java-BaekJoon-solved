package 큐_덱_우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * PriorityQueue : default가 최소힙이므로 만약 최대힙을 만들고 싶다면 -1을 곱해서 넣어준다.
 * 
 * 
 */
public class 우선_최대힙_11279 {
    public static int [] heap = new int[100001];
    public static int size = 0;
    public static StringBuilder sbbb = new StringBuilder();


    // 힙 구조 만들어서 풀기
    
    public static void swap(int x, int y) {
        int temp = heap[x];
        heap[x] = heap[y];
        heap[y] = temp;
    }
    public static void push(int x) {
        heap[++size] = x;
        //삽입한 것 부터 힙인지 확인, 힙이아니면 계속 부모노드로 올라가고 힙이면 break
        for(int i=size; i>1; i/=2) {
            if(heap[i/2] < heap[i]) {
                swap(i/2, i);
            } else {
                break;
            }
        }
    }
 
    public static void pop() {
        sbbb.append(heap[1]+"\n");
        heap[1] = heap[size];
        heap[size--] = 0;
        for(int i=1; i*2<=size;) { //삭제 후 1에서 부터 힙으로 만들어주는 과정
            if(heap[i] > heap[i*2] && heap[i] > heap[i*2+1]) {
                break;
            }else if(heap[i*2] > heap[i*2+1]) {
                swap(i, i*2);
                i = i*2;
            } else {
                swap(i, i*2+1);
                i = i*2+1;
            }
        }
    }


	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> queue = new PriorityQueue<Integer>();
		StringBuilder sb = new StringBuilder();
		
		// 횟수
		int N = Integer.parseInt(br.readLine());
		
		// 라이브러리 써서 풀기
		while(N-- > 0) {
			
			int X = Integer.parseInt(br.readLine());
			
			if(X != 0) {
				queue.offer(-1 * X);
			}
			else {
				if((queue.isEmpty())) {
					sb.append(0).append("\n");
				}
				else {
					sb.append(-1 * queue.poll()).append("\n");
					
					
				}
				
			}
		}
		
		System.out.println(sb);
		
		// 힙구조만들어서 풀기
        for(int i = 0; i < N; i++) {
            int k = Integer.parseInt(br.readLine());
            if(k==0) {
                if(size == 0) {
                    sb.append(0+"\n");
                } else {
                    pop();
                }
            } else {
                push(k);
            }
        }
        System.out.print(sbbb.toString());


		
	}
}
