package algorithm;

import java.io.*;
import java.util.*;

public class _010_b2583 {
	static int[][] matrix;
	static int[][] visited;
	static int count;
	static ArrayList<Integer> result = new ArrayList<Integer>();
	
	static int[] delta_row = {-1, 1, 0, 0};
	static int[] delta_col = {0, 0, -1, 1};
	
	private static void check(int row, int col, int M, int N) {
		visited[row][col] = 1;
		count++;
		for(int i=0;i<4;i++) {
			int nxt_row = row + delta_row[i];
			int nxt_col = col + delta_col[i];
			if (0 <= nxt_row && nxt_row < M && 0 <= nxt_col && nxt_col < N) {
				if(visited[nxt_row][nxt_col] == 0 && matrix[nxt_row][nxt_col] == 0) {
					check(nxt_row, nxt_col, M, N);
				}
			}
		}
	}
	
	public static void main (String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		matrix = new int[M][N];
		visited = new int[M][N];		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(bf.readLine());
			int cs = Integer.parseInt(st.nextToken());
			int rs = Integer.parseInt(st.nextToken());
			int ce = Integer.parseInt(st.nextToken());
			int re = Integer.parseInt(st.nextToken());
			
			for(int row = rs; row< re; row++) {
				for(int col = cs; col<ce; col++) {
					matrix[M-row-1][col] = 1;
				}
			}
		}
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(matrix[i][j] == 0 && visited[i][j] == 0) check(i, j, M, N);
				if (count != 0)	result.add(count);
				count = 0;
			}
		}
		System.out.printf("%d\n", result.size());
		int[] array = new int[result.size()];
		for(int i=0;i<result.size();i++) {
			array[i] = result.get(i);
		}
		Arrays.sort(array);
		for(int i=0;i<result.size();i++) {
			System.out.printf("%d ", array[i]);
		}
	}
}
