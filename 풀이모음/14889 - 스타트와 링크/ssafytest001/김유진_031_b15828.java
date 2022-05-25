package algorithm;

import java.io.*;
import java.util.*;

public class _031_b15828 {
	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		sout("이거");
		int N = Integer.parseInt(bf.readLine());
		Queue<Integer> queue = new LinkedList<Integer>();
		
		while(true) {
			int input = Integer.parseInt(bf.readLine());
			if (input == - 1) break;
			
			if(input != 0 && queue.size() < N) queue.add(input);
			else if(input == 0 && !queue.isEmpty()) queue.poll();
		}
		print_q(queue);
	}
	private static void print_q(Queue<Integer> queue) {
		if(queue.isEmpty()) System.out.printf("empty");
		else
			while(!queue.isEmpty()) System.out.printf("%d ", queue.poll());
		
		
		return ;
	}
}
