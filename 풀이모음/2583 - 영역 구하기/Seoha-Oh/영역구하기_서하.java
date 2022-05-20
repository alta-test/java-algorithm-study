package algorithm;

import java.util.*;
import java.io.*;

public class _028_b5464 {
	static int result = 0;
	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = bf.readLine().split(" ");
		
		int N = Integer.parseInt(tmp[0]);
		int M = Integer.parseInt(tmp[1]);
		
		int[][] park = new int[N][2];
		for(int i=0; i<N; i++) {
			park[i][0] = Integer.parseInt(bf.readLine());
		}
		
		int[] weight = new int[M+1];
		for(int i=1; i<M+1; i++) {
			weight[i] = Integer.parseInt(bf.readLine());
		}
		
		Queue<Integer> wq = new LinkedList<Integer>();
		for(int i=0; i<2*M; i++) {
			int car_num = Integer.parseInt(bf.readLine());
			
			if(car_num > 0) {
				if(!parking(park, car_num)) {
					wq.add(car_num);
				}
			}
			else {
				car_num = -car_num;
				out(park, wq, weight, car_num);
			}
		}
		System.out.println(result);
	}
	private static boolean parking(int[][] park, int num) {
		for(int i=0; i<park.length; i++) {
			if(park[i][1] == 0) {
				park[i][1] = num;
				return true;
			}
		}
		
		return false;
	}
	private static void out(int[][] park, Queue<Integer> wq, int[] weight, int num) {
		for(int i=0; i<park.length; i++) {
			if(park[i][1] == num) {
				result += weight[num] * park[i][0];
				park[i][1] = 0;
				
				if(!wq.isEmpty()) {
					park[i][1] = wq.poll();
				}
				return;
			}
		}
	}
}
