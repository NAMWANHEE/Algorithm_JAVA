import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class bj_2217 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<n;i++) {
			list.add(sc.nextInt());
		}
		Collections.sort(list,Collections.reverseOrder());
		int ans = 0;
		for(int i=0;i<n;i++) {
			if(ans< list.get(i)*(i+1)) {
				ans = list.get(i)*(i+1);
			}
		}
		System.out.println(ans);

	}

}
