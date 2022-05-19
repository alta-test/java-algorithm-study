package algorithm;

import java.io.*;
import java.util.*;

public class _013_b21735 {
	static int[] yard;
	static int result = -1;
	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int A = 0;

		yard = new int[N+1];
		st = new StringTokenizer(bf.readLine());
		for(int i=1; i<N+1; i++) {
			yard[i] = Integer.parseInt(st.nextToken());
		}
		
		make_ball(0, 0, M, 1);
		System.out.println(result);
		
	}
	
	private static void make_ball(int idx, int cnt, int M, int size) {
		if(cnt > M) return;
		
		if(cnt <= M) {
			if (result < size) result = size;
		}
		
		if(idx+1 < yard.length) make_ball(idx+1, cnt+1, M, size + yard[idx+1]);
		if(idx+2 < yard.length) make_ball(idx+2, cnt+1, M, size/2 + yard[idx+2]);
	}
}
