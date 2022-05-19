package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _002_b1158 {

	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(input.readLine(), " ");
		StringBuilder result = new StringBuilder();
		result.append("<");

		int N = Integer.parseInt(token.nextToken());
		int K = Integer.parseInt(token.nextToken());
		int[] nums = new int[N];
		
		for(int idx = 0; idx< N; idx++) {
			nums[idx] = idx + 1;
		}
		int idx = 0;
		int length = N;
		while (length > 0) {
			idx = (idx + K - 1) % length;
			result.append(nums[idx]).append(", ");
			for(int i = idx; i < length - 1; i++) {
				nums[i] = nums[i+1];
			}
			length--;
		}
		result.setLength(result.length()-2);
		result.append(">");
		System.out.println(result.toString());
	}
}
