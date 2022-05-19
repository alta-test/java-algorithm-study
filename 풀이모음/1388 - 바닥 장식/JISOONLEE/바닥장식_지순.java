package algorithm;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class _009_b1388 {
	private static int check(int row, int col, char[][] tile, char target) {
		int count = 0;
		Stack<Character> stack = new Stack<Character>();
		
		if (target == '|') {
			for(int j=0; j<col; j++) {
				char flag = '+';
				for(int i=0; i<row; i++) {
					if(flag != tile[i][j] && target == tile[i][j]) {
						count++;
					}
					flag = tile[i][j];
				}
			}
		}
		else {
			for(int i=0; i<row; i++) {
				char flag = '+';
				for(int j=0; j<col; j++) {
					if(flag != tile[i][j] && target == tile[i][j]) {
						count++;
					}
					flag = tile[i][j];
				}
			}
		}

		return count;
	}
	public static void main (String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] tile = new char[N][M];
		for(int i=0; i<N; i++) {
			String tmp = bf.readLine();
			for(int j=0; j<M; j++) {
				tile[i][j] = tmp.charAt(j);
			}
		}
		System.out.println(check(N, M, tile, '-') + check(N, M, tile, '|'));
	}
}
