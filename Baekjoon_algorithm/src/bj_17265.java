import java.util.Arrays;
import java.util.Scanner;

public class bj_17265 {
	static char map[][];
	static int map2[][], map3[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		map = new char[n][n];
		map2 = new int[n][n];
		map3 = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				map[i][j] = sc.next().charAt(0);
				if(map[i][j] != '+' && map[i][j] != '-' && map[i][j] != '*') {
					map2[i][j] = Integer.MAX_VALUE;
					map3[i][j] = Integer.MIN_VALUE;
				}
			}
		}
		map3[0][0] = map[0][0]-'0';
		map2[0][0] = map[0][0]-'0';
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j] != '+' && map[i][j] != '-' && map[i][j] != '*') {
					if(i>=2) {
						map2[i][j] = Math.min(map2[i][j], method(map[i][j]-'0',map[i-1][j],map2[i-2][j]));
						map3[i][j] = Math.max(map3[i][j], method(map[i][j]-'0',map[i-1][j],map3[i-2][j]));
					}
					if(j>=2) {
						map2[i][j] =  Math.min(map2[i][j], method(map[i][j]-'0',map[i][j-1],map2[i][j-2]));
						map3[i][j] =  Math.max(map3[i][j], method(map[i][j]-'0',map[i][j-1],map3[i][j-2]));
					}
					if(i>=1 && j>=1) {
						map2[i][j] =  Math.min(map2[i][j], method(map[i][j]-'0',map[i][j-1],map2[i-1][j-1]));
						map2[i][j] =  Math.min(map2[i][j], method(map[i][j]-'0',map[i-1][j],map2[i-1][j-1]));
						map3[i][j] =  Math.max(map3[i][j], method(map[i][j]-'0',map[i][j-1],map3[i-1][j-1]));
						map3[i][j] =  Math.max(map3[i][j], method(map[i][j]-'0',map[i-1][j],map3[i-1][j-1]));
					}
				}
			}
		}


		System.out.println(map3[n-1][n-1]+" "+map2[n-1][n-1]);

	}
	private static int method(int left, char mid, int right) {
		if(mid == '+') {
			return left+right;
		}
		else if(mid=='*') {
			return left*right;
		}
		else {

			return right-left;
		}
	}

}
