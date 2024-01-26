import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_30803 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int arr [] = new int[n+1];
		boolean check [] = new boolean[n+1];
		long sum = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<n+1;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i];
		}
		StringBuilder sb = new StringBuilder();
		sb.append(sum+"\n");
		int q = Integer.parseInt(br.readLine());
		for(int i=0;i<q;i++) {
			st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			if(h==1) {
				int idx = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());
				if(!check[idx]) {
					sum -= arr[idx];
					arr[idx] = num;
					sum += arr[idx];
				}
				else {
					arr[idx] = num;
				}
			}
			else {
				int idx = Integer.parseInt(st.nextToken());
				if(!check[idx]) {
					check[idx] = true;
					sum -= arr[idx];
				}
				else {
					check[idx] = false;
					sum += arr[idx];
				}
			}
			sb.append(sum+"\n");
		}
		System.out.println(sb);
		


	}



}
