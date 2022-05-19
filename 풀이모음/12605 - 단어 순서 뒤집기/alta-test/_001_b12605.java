package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _001_b12605 {

	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(input.readLine());
		int idx = 0;
		while(idx++ < n) {
			String st = input.readLine();
			String []tokens = st.split(" ");
			StringBuilder builder = new StringBuilder();
			builder.append("Case #").append(n).append(": ");
			for(int i = tokens.length - 1 ; i >= 0 ; i--) {
				builder.append(tokens[i]).append(" ");
			}
			System.out.println(builder.toString());
		}
	}
}
