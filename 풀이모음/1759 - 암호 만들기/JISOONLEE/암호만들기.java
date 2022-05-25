package algorithm;

import java.io.*;
import java.util.*;

public class _015_b1759 {
	static char[] alpha;
	static ArrayList<String> codes = new ArrayList<String>();
	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int L = Integer.parseInt(st.nextToken());;
		int C = Integer.parseInt(st.nextToken());
		alpha = new char[C];
		st = new StringTokenizer(bf.readLine());
		for(int i=0; i<C; i++) alpha[i] = st.nextToken().charAt(0);
		
		boolean[] visited = new boolean[C];
		combination(visited, C, L, 0, L);
		
		codes.sort(null);
		for(int i=0; i<codes.size(); i++) System.out.println(codes.get(i));
	}
	
	private static void combination(boolean[] visited, int n, int r, int start, int l) {
		if(r == 0) {
			check(visited, n, l, 0);
			return;
		}
		
		for(int i=start; i<n; i++) {
			visited[i] = true;
			combination(visited, n, r-1, i+1, l);
			visited[i] = false;
		}
	}
	
	private static void check(boolean[] visited, int n, int l, int v_idx) {
		char[] code = new char[l];
		int idx = 0;
		int	con_cnt = 0;
		int vo_cnt = 0;
		while(idx < l) {
			if(visited[v_idx]) {
				code[idx] = alpha[v_idx];
				if(alpha[v_idx] == 'a' || 
					alpha[v_idx] == 'e' || 
					alpha[v_idx] == 'i' || 
					alpha[v_idx] == 'o' || 
					alpha[v_idx] == 'u') vo_cnt++;
				else con_cnt++;
				idx++;
			}
			v_idx++;
		}
		Arrays.sort(code);
		if(vo_cnt > 0 && con_cnt > 1) codes.add(new String(code));
	}
}
