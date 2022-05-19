package algorithm;

import java.io.*;
import java.util.*;

public class _012_b2667 {
	static int[][] matrix;
	static int[][] visited;
	
	static int[] delta_row = {-1, 1, 0, 0};
	static int[] delta_col = {0, 0, -1, 1};
	
	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		ArrayList<Integer> result = new ArrayList<Integer>(1);
		
		matrix = new int[N][N];
		visited = new int[N][N];
		
		for(int i=0; i<N; i++) {
			String str = bf.readLine();
			for(int j=0; j<N; j++) {
				matrix[i][j] = Character.getNumericValue(str.charAt(j));
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int tmp = 0;
				if(matrix[i][j] == 1 && visited[i][j] == 0) tmp = check(i, j, N);
				if(tmp != 0)
					result.add(tmp);
			}
		}
		result.sort(null);
		System.out.println(result.size());
		for(int i=0; i<result.size(); i++) {
			System.out.println(result.get(i));
		}
	}
	
	private static int check(int row, int col, int size) {
		int result = 1;
		visited[row][col] = 1;
		for(int i=0; i<4; i++) {
			int nxt_row = row + delta_row[i];
			int nxt_col = col + delta_col[i];
			if(0 <= nxt_row && nxt_row < size && 0 <= nxt_col && nxt_col < size) {
				if(matrix[nxt_row][nxt_col] == 1 && visited[nxt_row][nxt_col] == 0) {
					result += check(nxt_row, nxt_col, size);	
				}
			}
		}
		return result;
	}
}
