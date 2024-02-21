import java.util.Scanner;

public class bj_1011 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc=0;tc<t;tc++) {
			long start = sc.nextInt();
			long end = sc.nextInt();
			long length = end-start+1;
			
			long m = 1;
			long l = 2;
			long ans = 1;
			while(length >= l) {
				
				for(int i=0;i<2;i++) {
					l+= m;
					if(length < l) break;
					ans+= 1;
				}
				m++;
			}
			System.out.println(ans);
		}

	}

}
