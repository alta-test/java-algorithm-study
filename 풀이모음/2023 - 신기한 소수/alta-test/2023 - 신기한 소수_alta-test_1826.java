package algorithm;

import java.io.*;
import java.util.Scanner;

public class _008_b2023 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		DFS(0, 0, N);
	}
	private static void DFS(int buffer, int count, int size) {
		if(count == size) {
			System.out.println(buffer);
			return;
		}
		
		int idx = 1;
		if (count == 0) idx=2;
		
		
		buffer *= 10;
				
		loop:
		while (idx < 10) {
			buffer += idx;
			for(int i = 2; i<buffer;i++) {
				if(buffer % i == 0) {
					buffer -= idx;
					idx++;
					continue loop;
				}
			}
			DFS(buffer, count+1, size);
			buffer -= idx;
			idx++;
		}
	}
}
