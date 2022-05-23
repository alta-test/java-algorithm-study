package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _005_b12034 {
	public static void main (String arg[]) throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(input.readLine());
		
		long start = System.currentTimeMillis();
		for(int i=0;i<T;i++) {
			int N = Integer.parseInt(input.readLine());
			double[] price = new double[N*2];
			double[] result = new double[N];
			StringTokenizer token = new StringTokenizer(input.readLine(), " ");
			
			for(int j=0;j<N*2;j++) {				
				price[j] = Integer.parseInt(token.nextToken());			
			}
			int idx = 0;
			loop:
			for(int j=0;j<N*2;j++) {
				if(price[j] == -100) continue;
				for(int k=j+1;k<N*2;k++) {
					if(price[k] == -100) continue;
					if(price[j] * 4/3 == price[k]) {
						result[idx++] = price[j];
						price[k] = -10;
						if(idx >= N) break loop;
						break;
					}
				}
			}


			StringBuilder b = new StringBuilder();
			b.append("Case #").append(i+1).append(": ");
			for(int u=0;u<result.length;u++) {
				b.append(Math.round(result[u])).append(" ");
			}
			System.out.println(b.toString());
		}
		long end = System.currentTimeMillis();
		System.out.println("SDB���� ������������ ����ð� : " + (end - start)/1000.0);
	}
}
