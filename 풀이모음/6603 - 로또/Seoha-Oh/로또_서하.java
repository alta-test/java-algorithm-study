package algorithm;

import java.util.*;
import java.io.*;

public class _027_b2841 {
	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String[] tmp = bf.readLine().split(" ");
		int N = Integer.parseInt(tmp[0]);
		int P = Integer.parseInt(tmp[1]);		
		
		ArrayList<Stack<Integer>> line = new ArrayList<Stack<Integer>>(7);
		for(int i=0; i<7; i++) line.add(new Stack<Integer>());
		int cnt = 0;
		while(N-- > 0) {
			tmp = bf.readLine().split(" ");
			int l = Integer.parseInt(tmp[0]);
			int p = Integer.parseInt(tmp[1]);
			
			if(line.get(l).isEmpty()) {
				line.get(l).push(p);
				cnt++;
			}
			else {
				if(line.get(l).peek() < p) {
					line.get(l).push(p);
					cnt++;
				}
				else {
					while(!line.get(l).isEmpty() && line.get(l).peek() > p) {
						line.get(l).pop();
						cnt++;
					}
					if(line.get(l).isEmpty() || line.get(l).peek() != p) {
						line.get(l).push(p);
						cnt++;
					}
				}
			}
		}
		System.out.println(cnt);
	}
}
