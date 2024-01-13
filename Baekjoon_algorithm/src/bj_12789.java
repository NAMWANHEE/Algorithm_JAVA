import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class bj_12789 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Queue<Integer> q = new ArrayDeque<>();
		int cnt = 1;
		boolean ans = true;
		for(int i=0;i<n;i++) {
			q.add(sc.nextInt());
		}
		Stack<Integer> s = new Stack<>();
		while(true) {
			if(q.size()==0 && s.size()!=0 && s.peek() != cnt) {
				ans = false;
				break;
			}
			if(q.isEmpty() && s.isEmpty()) {
				break;
			}
			if(s.size()==0) {
				int num = q.poll();
				if(num == cnt) cnt+=1;
				else {
					s.add(num);
				}
			}
			else {
				int num1 = q.peek();
				int num2 = s.peek();
				if(num1 == cnt) {
					q.poll();
					cnt+= 1;
				}
				else if(num2 == cnt) {
					s.pop();
					cnt+=1;
				}
				else {
					s.add(q.poll());
				}
			}
		}
		
		
		if(ans) System.out.println("Nice");
		else System.out.println("Sad");

	}

}
