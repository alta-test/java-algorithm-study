package algorithm;

import java.io.*;
import java.util.*;

public class _029_b1052 {
	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String[] tmp = bf.readLine().split(" ");
		int N = Integer.parseInt(tmp[0]);
		int K = Integer.parseInt(tmp[1]);
		int result = 0;
		
		while (true) {
            char[] binary = Integer.toBinaryString(N).toCharArray();
            int cnt = 0;

            for (int i = 0; i < binary.length; i++) if (binary[i] == '1') cnt++;

            if (cnt <= K) {
                System.out.println(result);
                break;
            }

            N++;
            result++;
        }
	}
}
