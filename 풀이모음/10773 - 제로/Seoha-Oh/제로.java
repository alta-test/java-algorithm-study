package algorithm;

import java.io.IOException;
import java.util.Scanner;

public class _003_b10773 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		int idx = 0;
		int[] result = new int[K];
		for (int i = 0; i< K; i++) {
			int num = sc.nextInt();
			if (num != 0) {
				result[idx++] = num;
			}
			else {
				result[--idx] = 0;
			}
		}
		if (idx == 0) {
			System.out.println(idx);
		}
		else {
			int answer = 0;
			for (int j = 0; j < idx; j++) {
				answer += result[j];
			}
			System.out.println(answer);
		}
	}
}
