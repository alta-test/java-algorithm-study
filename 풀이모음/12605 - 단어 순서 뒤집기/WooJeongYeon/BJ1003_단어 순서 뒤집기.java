
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class 단어순서뒤집기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(in.readLine());
		Fibo[] fibos = new Fibo[41];
		fibos[0] = new Fibo(1, 0);
		fibos[1] = new Fibo(0, 1);
		for(int i = 2 ; i < fibos.length ; i++) {
			fibos[i] = new Fibo(fibos[i - 1].callZeroNum + fibos[i - 2].callZeroNum
						, fibos[i - 1].callOneNum + fibos[i - 2].callOneNum);
		}
		for(int tc = 0 ; tc < TC ; tc++) {
			int n = Integer.parseInt(in.readLine());
			sb.append(fibos[n].callZeroNum + " " + fibos[n].callOneNum + "\n");
		}
		System.out.println(sb);
	}
	static class Fibo {
		int callZeroNum;
		int callOneNum;
		public Fibo(int callZeroNum, int callOneNum) {
			this.callZeroNum = callZeroNum;
			this.callOneNum = callOneNum;
		}
	}
}
