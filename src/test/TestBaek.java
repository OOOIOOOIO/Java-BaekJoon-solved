package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.InputStream;
 
public class TestBaek {
	static class Shark{

		int x;
		int y;
		
		public Shark(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {

		Queue<Shark> queue = new PriorityQueue<TestBaek.Shark>(new Comparator<Shark>() {
			@Override
			public int compare(Shark o1, Shark o2) {
				if(o1.y - o2.y < 0) {
					return -1;
				}
				else if(o1.y - o2.y > 0) {
					return 1;
				}
				else {
					return o1.x - o2.x < 0 ? -1 : 1;
				}
			}
		});
		
		queue.offer(new Shark(5, 10));
		queue.offer(new Shark(3, 10));
		queue.offer(new Shark(10, 10));
		queue.offer(new Shark(2, 10));
		queue.offer(new Shark(7, 10));
		queue.offer(new Shark(1, 10));
		
		for(Shark sh : queue) {
			System.out.println(sh.x + " : " + sh.y);
		}
	}
 

	
    
}
