import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class softeer_XmarkstheSpot {

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb  = new StringBuilder();
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str1 = st.nextToken();
            String str2 = st.nextToken();
            for(int j=0;j<str1.length();j++){
                if(str1.charAt(j) == 'x'){
                    sb.append(String.valueOf(str2.charAt(j)).toUpperCase());
                    break;
                }
                else if(str1.charAt(j) == 'X'){
                    sb.append(String.valueOf(str2.charAt(j)).toUpperCase());
                    break;
                }
            }
        }
        System.out.println(sb);

    }

}
