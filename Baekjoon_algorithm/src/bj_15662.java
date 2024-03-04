import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class bj_15662 {
	static int left = 6;
	static int right = 2;
	static int arr[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		arr = new int[t][8];
		for(int i=0;i<t;i++) {
			String str = br.readLine();
			for(int j=0;j<8;j++) {
				arr[i][j] = str.charAt(j)-'0';
			}
		}
		int k = Integer.parseInt(br.readLine());
		for(int i=0;i<k;i++) {
			List<int[]> list = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			int number = Integer.parseInt(st.nextToken())-1;
			int direction = Integer.parseInt(st.nextToken());
			list.add(new int[] {number,direction});
			int l = number;
			int ld = direction*-1;
			int r = number;
			int rd = direction *-1;
			for(int j=number-1;j>=0;j--) {
				if(arr[l][left] != arr[j][right]) {
					l = j;
					list.add(new int[] {j,ld});
					ld *= -1;
				}
				else break;
			}
			
			for(int j=number+1;j<t;j++) {
				if(arr[r][right] != arr[j][left]){
					r = j;
					list.add(new int[] {j,rd});
					rd *= -1;
				}
				else break;
			}
			for(int [] a: list) {
				move(a[0],a[1]);
			}
			
		}
		int ans = 0;
		for(int i=0;i<t;i++) {
			if(arr[i][0] ==1) ans++;
		}
		System.out.println(ans);

	}
	private static void move(int number, int direction) {
		int copy [] = new int[8];
		for(int i=0;i<8;i++) {
			copy[i] = arr[number][i];
		}
		if(direction==1) {
			for(int i=0;i<8;i++) {
				arr[number][i] = copy[(i+7)%8];
			}
		}
		else {
			for(int i=0;i<8;i++) {
				arr[number][i] = copy[(i+1)%8];
			}
		}
		
	}

}
