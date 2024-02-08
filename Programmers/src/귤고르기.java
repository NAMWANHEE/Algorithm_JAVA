import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ±Ö°í¸£±â {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i: tangerine){
            if(map.containsKey(i)) map.put(i,map.get(i)+1);
            else map.put(i,1);
        }
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list);
        for(int i= list.size()-1;i>=0;i--){
            answer++;
            k -= list.get(i);
            if(k<=0) break;
        }
        return answer;
    }

}
