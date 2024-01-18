import java.util.Scanner;
import java.util.Stack;
import java.util.Stack;

public class softeer_8단변속기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0;i<8;i++) {
			stack.add(sc.nextInt());
		}
		boolean ascending = false;
		boolean descending = false;
		int nowNum = stack.pop();
		while(!stack.isEmpty()) {
			int popNum = stack.pop();
			if(nowNum > popNum) {
				ascending = true;
			}
			else {
				descending = true;
			}
			nowNum = popNum;
		}
		
		if(ascending && !descending) System.out.println("ascending");
		else if(!ascending && descending) System.out.println("descending");
		else System.out.println("mixed");

	}

}
