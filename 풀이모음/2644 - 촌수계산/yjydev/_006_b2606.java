package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _006_b2606 {
	public static int DFS(int[][] links, int[] visited, int cnt, int sp, int size) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
        int i = 0;
		while (stack.size() != 0) {
			int cur = stack.pop();
			if(visited[cur] == 0) {				
				visited[cur] = 1;
				cnt++;
				for(int i = 1; i < size; i++) {
					if(visited[i] == 0 && links[cur][i] == 1) {
						stack.push(i);
					}
				}
			}
		}
		return cnt - 1;
	}
	public static void main (String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int C = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int[] visited = new int[C+1];
		int[][] links = new int[C+1][C+1];
		while(N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] link = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			links[link[0]][link[1]] = 1;
			links[link[1]][link[0]] = 1;
		}
		System.out.println(DFS(links, visited, 0, 1, C+1));
	}
}
