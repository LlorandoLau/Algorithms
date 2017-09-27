import edu.princeton.cs.algs4.MaxPQ;


public class TopM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="E A S Y Q U E S T I O N";
		char[] ch=s.toCharArray();
		MaxPQ pq=new MaxPQ<>(ch.length);
		
		for(int i=0;i<ch.length;i++){
			pq.insert(ch[i]);
		}
		for(int i=0;i<ch.length;i++){
			StdOut.print(pq.delMax());
		}

	}

}
