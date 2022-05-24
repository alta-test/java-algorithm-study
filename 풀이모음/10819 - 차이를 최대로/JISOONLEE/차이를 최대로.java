package algorithm;

import java.io.*;
import java.util.*;

public class _016_b10819 {
	static int result = 0;
	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(bf.readLine());
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		permutation(arr, 0, N, N);		
		System.out.println(result);
	}
	
	private static void permutation(int[] arr, int idx, int n, int r){
		int tmp = 0;
		
		if(idx == r) {
			cal(arr);
		}
		
		for(int i=idx; i<n; i++) {	
			swap(arr, idx, i);
			permutation(arr, idx+1, n, r);
			swap(arr, idx, i);
		}
	}
	private static void swap(int arr[], int idx, int i) {
		int tmp = arr[idx];
		arr[idx] = arr[i];
		arr[i] = tmp;
	}
	private static void cal(int arr[]) {
		int sum = 0;
		for(int i=0; i<arr.length-1;i++) sum += Math.abs(arr[i] - arr[i+1]);
		if(sum > result) result = sum;
	}
}
