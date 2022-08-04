import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_BJ_2164_카드2 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> queue = new LinkedList<>();
		int N = Integer.parseInt(br.readLine());
		
		for(int i=1;i<=N;i++) {
			queue.offer(i);
		}
		
		while(queue.size()!=1) {
			queue.poll();
			queue.add(queue.poll());			
		}
		
		System.out.println(queue.poll());

	}

}
