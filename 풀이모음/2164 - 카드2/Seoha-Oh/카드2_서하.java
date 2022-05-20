package algorithm;

import java.util.*;
import java.io.*;

public class _033_b7576 {
	
	static final int RIPE = 1;
	static final int UNRIPE = 0;
	static final int EMPTY = -1;
	static int[] delta_row = {-1, 1, 0, 0};
	static int[] delta_col = {0, 0, -1, 1};
	
	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String[] tmp = bf.readLine().split(" ");
		int ROW = Integer.parseInt(tmp[1]);
		int COL = Integer.parseInt(tmp[0]);
		int tomato_cnt = ROW * COL;
		
		int[][] box = new int[ROW][COL];
		Queue<int[]> queue = new LinkedList<int[]>();
		for(int r=0; r<ROW; r++) {
			tmp = bf.readLine().split(" ");
			for(int c=0; c<COL; c++) {
				box[r][c] = Integer.parseInt(tmp[c]);
				if(box[r][c] == RIPE) queue.add(new int[] {r, c});
				if(box[r][c] == EMPTY) tomato_cnt--;
			}
		}
		
		System.out.println(BFS(box, queue, tomato_cnt));
	}
	private static int BFS(int[][] box, Queue<int[]> queue, int tomato_cnt) {
		
		int turn = 0;
		int cnt = queue.size();
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int idx=0; idx<size; idx++) {
				int[] tmp = queue.poll();
				int row = tmp[0];
				int col = tmp[1];
				
				for(int i=0; i<4; i++) {
					int nxt_row = row + delta_row[i];
					int nxt_col = col + delta_col[i];
					if(0 <= nxt_row && nxt_row < box.length && 0 <= nxt_col && nxt_col < box[row].length) {
						if(box[nxt_row][nxt_col] == 0) {
							queue.add(new int[] {nxt_row, nxt_col});
							box[nxt_row][nxt_col] = 1;
							cnt++;
						}
					}
				}
			}
			turn++;
		}
		return cnt == tomato_cnt ? turn-1:-1;
	}
}
 