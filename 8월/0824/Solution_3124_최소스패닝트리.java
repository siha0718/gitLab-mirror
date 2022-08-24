import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_3124_최소스패닝트리 {
	
	static int T, V, E;
	static ArrayList<Node>[] nodeList;
	static boolean[] visited;
	static int[] minEdge;
	static long res;
	static StringBuilder sb = new StringBuilder();
	static class Node{
		
		int a, b;
		long c;

		public Node(int a, int b, long c) {

			this.a = a;
			this.b = b;
			this.c = c;
		}
		
		
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		
		T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			
			res = 0;
			sb.append("#" + tc + " ");
			
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
		
			visited = new boolean[V+1];
			nodeList = new ArrayList[V+1];
			
			for(int i=1;i<=V;i++) {
				nodeList[i] = new ArrayList<Node>();
			}
			
			for(int i=0;i<E;i++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				long C = Integer.parseInt(st.nextToken());
				
				nodeList[A].add(new Node(A,B,C));
				nodeList[B].add(new Node(B,A,C));
			}
		
		
			Prim();
			
			sb.append("\n");
		}//end tc
		
		System.out.println(sb);
	}

	private static void Prim() {
		
		Comp cp = new Comp();
		PriorityQueue<Node> pq = new PriorityQueue<>(cp);
		Deque<Integer> dq = new ArrayDeque<>();
		dq.add(1);
		ArrayList<Node> tempList;
		Node tempNode;
		
		while(!dq.isEmpty()) {
			
			int currentNode = dq.poll();
			visited[currentNode] = true;
			tempList = nodeList[currentNode];
			for(int i=0;i<tempList.size();i++) {
				if(!visited[tempList.get(i).b]) {
					pq.add(tempList.get(i));
				}
			}
			
			
			while(!pq.isEmpty()) {
				tempNode = pq.poll();
				if(!visited[tempNode.b]) {
					visited[tempNode.b]= true;
					res += tempNode.c;
					dq.add(tempNode.b);
					break;
				}
			}
			
			
		}//end while
		
		
		sb.append(res);
		
	}
	
	
	static class Comp implements Comparator<Node>{
		
		@Override
		public int compare(Node o1, Node o2) {
			// TODO Auto-generated method stub
			return o1.c > o2.c ? 1: -1;
		}
	}
	
	
}//end class
