package algorithm;

import java.util.*;
import java.io.*;

public class _030_b2304 {
	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		String[] tmp;
		ArrayList<Integer> poll = new ArrayList<Integer>();
		int[] p = new int[2];
		
		while(N-- > 0) {
			tmp = bf.readLine().split(" ");
			int idx = Integer.parseInt(tmp[0]);
			int height = Integer.parseInt(tmp[1]);
			if (p[1] < height) {
				p[0] = idx;
				p[1] = height;
			}
			
			if(poll.size() < idx+1) {
				for(int i=poll.size(); i<idx; i++) poll.add(0);
				poll.add(height);
			}
			else poll.set(idx, height);
		}
		System.out.println(area(poll, 0, p[0], 1) + area(poll, poll.size()-1, p[0], -1) - poll.get(p[0]));
	}
	private static int area(ArrayList<Integer> poll, int start, int end, int next) {
		int tmp = poll.get(start);
		int result = tmp;
		
		while(start != end) {
			start += next;
			int now = poll.get(start);
			if(tmp < now) {
				result += now;
				tmp = now;
			}
			else result += tmp;
		}		
		return result;
	}
}
