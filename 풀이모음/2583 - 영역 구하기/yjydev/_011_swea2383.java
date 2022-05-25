package algorithm;;

import java.io.*;
import java.util.*;

public class _011_swea2383 {
	private static int[][] matrix;							// �Է� ���� ������ �迭
	private static int[][] people = new int[10][4];			// ����� ��ġ   | row, col, ���, �Ÿ�
	private static int[][] stair = {{-1, -1, 0}, {-1, -1, 0}};	// 1�� ��� ��ġ | row, col, ��� �ð�
	private static int result = 999;
	
	public static void main (String args[]) throws IOException {
//		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader bf = new BufferedReader(new FileReader("D:\\Users\\agang\\Desktop\\java_study\\Beakjoon_algorithm\\sample_input.txt"));
		
		int T = Integer.parseInt(bf.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(bf.readLine());	// �迭 ũ��

			int people_cnt = 0;							// �ο� ��
			matrix = new int[N][N];
			stair[0][0] = -1;
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for(int j=0; j<N; j++) {
					matrix[i][j] = Integer.parseInt(st.nextToken());
					if (matrix[i][j] == 1) {
						people[people_cnt][0] = i;
						people[people_cnt][1] = j;
						people[people_cnt][2] = 0;
						people_cnt++;
					}
					else if(matrix[i][j] >= 2) {
						if (stair[0][0] == -1) {
							stair[0][0] = i;
							stair[0][1] = j;
							stair[0][2] = matrix[i][j];
						}
						else {
							stair[1][0] = i;
							stair[1][1] = j;
							stair[1][2] = matrix[i][j];
						}
					}
				}
			}
		
			// �Է� ����
			boolean[] visited = new boolean[people_cnt];
			for(int i=0; i<=people_cnt;i++) {				
				combination(visited, 0, people_cnt, i);
			}
			
			System.out.printf("#%d %d\n",tc, result);
			result = 999;
		}
	}
	private static void combination(boolean[] visited, int start, int people_cnt, int r) {
		if(r == 0) {
			category(visited, people_cnt);
			return ;
		}
		
		for(int i = start; i<people_cnt; i++) {
			visited[i] = true;
			combination(visited, i+1, people_cnt, r-1);
			visited[i] = false;
		}
	}
	private static void category(boolean[] visited, int people_cnt) {
		byte ROW = 0;	// ��
		byte COL = 1; // ��
		byte stair1_cnt = 0;

		for(int i=0; i<people_cnt;i++) {
			if(visited[i]) {
				people[i][2] = 1;
				stair1_cnt++;
			}
			else people[i][2] = 0;
			people[i][3] = Math.abs(people[i][ROW] - stair[people[i][2]][ROW]) + Math.abs(people[i][COL] - stair[people[i][2]][COL]); // �Ÿ� ���
		}
		int tmp1 = time(0, people_cnt, people_cnt - stair1_cnt);
		int tmp2 = time(1, people_cnt, stair1_cnt);
		int min_time = (tmp1<tmp2 ? tmp2:tmp1);
		result = min_time<result ? min_time:result;
	}
	private static int time(int stair_num, int people_cnt, int exit) {
		if(exit == 0) return 0;
		Queue<Integer> stair_queue = new LinkedList<Integer>();
		Queue<Integer> wait_queue = new LinkedList<Integer>();
		int time_cnt = 0;
		int out_cnt = 0;
		while (true) {
			if (time_cnt >= result) return time_cnt;
 			for(int i=0; i<people_cnt;i++) {
				if(people[i][2] == stair_num) {
					people[i][3]--;
				}
			}
   			for(int i=0; i<people_cnt;i++) {
   				if(people[i][2] == stair_num) {
					if(people[i][3] == -1) {
						if(stair_queue.size() < 3)
							stair_queue.add(i);
						else {						
							wait_queue.add(i);
							people[i][3] = -11;
						}
					}
					else if(people[i][3] == -stair[stair_num][2]-1) {
						stair_queue.poll();
						if(!wait_queue.isEmpty()) {						
							int tmp = wait_queue.poll();
							stair_queue.add(tmp);
							people[tmp][3] = -1;
						}
						out_cnt++;
					}
   				}
			}
			time_cnt++;
			if (out_cnt == exit) return time_cnt;
		}
	}
}
