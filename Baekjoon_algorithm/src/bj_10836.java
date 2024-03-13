import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_10836 {
	static int map[][];
	static int m,n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new int[m][m];
		for(int i=0;i<m;i++) {
			for(int j=0;j<m;j++) {
				map[i][j] = 1;
			}
		}
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int zero = Integer.parseInt(st.nextToken());
			int one  =Integer.parseInt(st.nextToken());
			int two =Integer.parseInt(st.nextToken());
			
			
			for(int j=m-1;j>=0;j--) {
				if(zero !=0) {
					zero--;
				}
				else if(one !=0) {
					one--;
					map[j][0]+=1;
				}
				else if(two!=0) {
					two--;
					map[j][0]+=2;
				}

			}
			for(int j=1;j<m;j++) {
				if(zero !=0) {
					zero--;
				}
				else if(one !=0) {
					one--;
					map[0][j]+=1;
				}
				else if(two !=0) {
					two--;
					map[0][j]+=2;
				}
			}
			
		}
		grow();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<m;i++) {
			for(int j=0;j<m;j++) {
				sb.append(map[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	private static void grow() {
		for(int i=1;i<m;i++) {
			for(int j=1;j<m;j++) {
				int max = Math.max(map[i-1][j],Math.max(map[i][j-1], map[i-1][j-1]));
				map[i][j] = max;
			}
		}
		
	}

}
