package algorithm;

import java.io.*;
import java.util.*;

public class _017_b6603 {
	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int k = Integer.parseInt(st.nextToken());
			if(k == 0) break;
			
			int[] arr = new int[k];
			boolean[] visited = new boolean[k];
			for(int i=0; i<k;i++) 
				arr[i] = Integer.parseInt(st.nextToken());
			combination(visited, arr, k, 6, 0);
			System.out.println();
		}
	}
	
	private static void combination(boolean[] visited, int[] arr, int n, int r, int start) {
		if(r == 0) {
			for(int i=0; i<n; i++) 
				if(visited[i]) 
					System.out.printf("%d ",arr[i]); 
			System.out.println();
		}
		
		for(int i=start; i<n; i++) {
			visited[i] = true;
			combination(visited, arr, n, r-1, i + 1);
			visited[i] = false;
		}
	}
}
