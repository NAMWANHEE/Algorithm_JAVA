import java.util.Scanner;

public class bj_16395 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int [][] arr = new int[31][31];
		if(k == 1 || n== k) {
			System.out.println(1);
		}
		else {
			arr[2][1] = 1;
			arr[2][2] = 1;
			for(int i=3;i<=n;i++) {
				for(int j=1;j<=i;j++) {
					if(j==1 || j == i) arr[i][j] = 1;
					else arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
				}
			}
			System.out.println(arr[n][k]);
		}

	}

}
