import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class bj_3649 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int x = sc.nextInt() * 10000000;
			int n = sc.nextInt();
			List<Integer> list = new ArrayList<>();
			for(int i=0;i<n;i++) {
				list.add(sc.nextInt());
			}
			Collections.sort(list);
			int left = 0;
			int right = n-1;
			boolean check = true;
			while(left<right) {
				int num = (list.get(left)+list.get(right));
				if(num == x) {
					System.out.println("yes "+list.get(left)+" "+list.get(right));
					check = false;
					break;
				}
				if(num > x) {
					right--;
				}
				else {
					left++;
				}
				
			}
			if(check) {
				System.out.println("danger");
			}
		}
		

	}

}
