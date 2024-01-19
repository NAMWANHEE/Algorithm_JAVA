import java.util.Scanner;
import java.util.Stack;

public class softeer_비밀메뉴 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int k = sc.nextInt();
		int secret[] = new int[m];
		for(int i=0;i<m;i++) {
			secret[i] = sc.nextInt();
		}
		int idx = 0;
		int arr [] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		for(int i=0;i<n-m+1;i++) {
			int index=0;
			boolean check = true;
			System.out.println(i+" "+index);
			
			for(int j=i;j<i+m;j++) {
				if(arr[j] != secret[index]) {
					check = false;
					break;
				}
				index++;
			}
			if(check) {
				idx = 1;
				break;
			}
		}
		if(idx==1) System.out.println("secret");
		else System.out.println("normal");
		

	}

}
