package algorithm;

import java.io.*;
import java.util.*;

public class _032_b3184 {
	static final String FIELD = ".";
	static final String FENCE = "#";
	static final String SHEEP = "o";
	static final String WOLF = "v";
	static int[] delta_row = {-1, 1, 0, 0};
	static int[] delta_col = {0, 0, -1, 1};
	static int[] result = {0, 0};
	
	public static void main(String args[]) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String[] tmp = bf.readLine().split(" ");
		int ROW = Integer.parseInt(tmp[0]);
		int COL = Integer.parseInt(tmp[1]);
		
		int[][] matrix = new int[ROW][COL];
		boolean[][] visited = new boolean[ROW][COL];
		
		for(int r=0; r<ROW; r++) {
			tmp = bf.readLine().split("");
			for(int c=0; c<COL; c++)
				matrix[r][c] = what(tmp[c]);
		}

		for(int r=0; r<ROW; r++) {
			for(int c=0; c<COL; c++) {
				if(!visited[r][c] && matrix[r][c] < 3) {
					int[] cnt = {0, 0, 0};
					DFS(matrix, visited, r, c, cnt);
					
					int sheep = cnt[1];
					int wolf = cnt[2];
					
					if(sheep > wolf) result[0] += sheep;
					else result[1] += wolf;
				}
			}
		}
		System.out.printf("%d %d", result[0], result[1]);
		
	}
	private static void DFS(int[][] matrix, boolean[][] visited, int row, int col, int[] cnt) {
		visited[row][col] = true;
		if(0 < matrix[row][col] && matrix[row][col] < 3) cnt[matrix[row][col]]++;
		
		for(int i=0; i<4; i++) {
			int nxt_row = row + delta_row[i];
			int nxt_col = col + delta_col[i];
			if(nxt_row >= 0 && nxt_row < matrix.length && nxt_col >= 0 && nxt_col < matrix[row].length) {				
				if(!visited[nxt_row][nxt_col] && matrix[nxt_row][nxt_col] < 3) {
					DFS(matrix, visited, nxt_row, nxt_col, cnt);
				}
			}
		}
	}
	
	private static int what(String el) {
		switch(el) {
		case FENCE: return 3;
		case WOLF: return 2;
		case SHEEP: return 1;
		default : return 0;		
		}
	}
}
