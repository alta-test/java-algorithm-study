package algorithm;

import java.io.*;
import java.util.*;

public class _014_b14889 {
	static int[][] matrix;
	static int result;

	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());;
		
		matrix = new int[N][N];
		result = 200;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0; j<N; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = combination_count(N, N/2);
		
		boolean[] visited = new boolean[N];
		combination(visited, N, N/2, 0);
		System.out.println(result);
	}
	private static int combination_count(int n, int r) {
		if(n == r || r == 0) return 1;
		else return combination_count(n - 1, r - 1) + combination_count(n - 1, r);
	}
	private static void combination(boolean[] visited, int n, int r, int start) {
		if(r == 0) {
			ArrayList<Integer> set_true = new ArrayList<Integer>(n/2);
			ArrayList<Integer> set_false = new ArrayList<Integer>(n/2);
			for(int i= 0; i<n; i++) {
				if (visited[i]) set_true.add(i);
				else set_false.add(i);
			}
			
			int tmp = Math.abs(member(set_true) - member(set_false));
			result = result > tmp ? tmp : result;
		}
		
		for(int i=start; i<n; i++) {
			visited[i] = true;
			combination(visited, n, r-1, i+1);
			visited[i] = false;
		}
	}
	private static int member(ArrayList<Integer> people) {
		int sum = 0;
		int[] player_set = new int[2];
		boolean[] visited = new boolean[people.size()];
		
		for(int i=0; i< people.size(); i++) {
			player_set[0] = people.get(i);
			for(int j=i+1; j<people.size(); j++) {
				player_set[1] = people.get(j);
				sum += matrix[player_set[0]][player_set[1]] + matrix[player_set[1]][player_set[0]];
			}
		}
		return sum;
	}
}

