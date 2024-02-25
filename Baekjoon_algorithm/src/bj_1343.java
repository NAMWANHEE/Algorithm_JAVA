import java.util.Scanner;

public class bj_1343 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		int count = 0;
		String ans = "";
		for(int i=0;i<str.length();i++) {

			if(str.charAt(i)=='X' && str.length()-1 != i) count++;
			else if(str.charAt(i) =='.'|| i==str.length()-1) {
				if(i == str.length()-1&& str.charAt(i)=='X') count++;
				if(count == 0) {
					ans += ".";
					continue;
				}
				if(count % 2 != 0) {
					System.out.println(-1);
					System.exit(0);
				}
				int A = count /4;
				count = count % 4;
				for(int z=0;z<A;z++) {
					ans+="AAAA";
				}
				int B = count / 2;
				count = count % 2;
				for(int z=0;z<B;z++) {
					ans+="BB";
				}
				if(str.charAt(i)!='X')
					ans+=".";
				
			}
		}
		System.out.println(ans);

	}

}
