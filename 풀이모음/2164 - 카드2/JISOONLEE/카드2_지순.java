package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _004_b2164 {
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 1; i<=num; i++) q.add(i);
		
		while(q.size() != 1) {
			q.poll();
			q.offer(q.poll());
		}
		
		System.out.println(q.poll());
	}
}
