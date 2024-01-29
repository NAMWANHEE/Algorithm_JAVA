import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj_9935 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String str2 = br.readLine();
		int len = str2.length();
		Stack<Character> stack = new Stack<>();
		for(int i=0;i<str.length();i++) {
			stack.push(str.charAt(i));
			int cnt = 0;
			if(stack.size() >= len) {
				for(int j=0;j<len;j++) {
					if(stack.get(stack.size()-len+j) == str2.charAt(j)) {
						cnt++;
					}
				}
				if(cnt == len) {
					for(int j=0;j<len;j++) {
						stack.pop();
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		if(stack.isEmpty()) {
			System.out.println("FRULA");
		}
		else
			for(char i : stack) sb.append(i);
		System.out.println(sb);
		
		
	}

}
