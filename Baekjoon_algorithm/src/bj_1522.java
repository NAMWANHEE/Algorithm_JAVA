import java.util.Scanner;

public class bj_1522 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int count = 0;
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='a') count++;
		}
		int ans = Integer.MAX_VALUE;
		for(int i=0;i<str.length();i++) {
			int cnt = 0;
			for(int k=i;k<i+count;k++) {
				int idx = k%str.length();
				if(str.charAt(idx)=='b')cnt++;
			}
			ans = Math.min(ans, cnt);
		}
		System.out.println(ans);

	}

}
