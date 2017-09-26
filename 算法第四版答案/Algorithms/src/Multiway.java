import edu.princeton.cs.algs4.IndexMinPQ;


public class Multiway {

	public static void merge(In[] a){
		int N=a.length;
		IndexMinPQ<String> pq=new IndexMinPQ<>(N);
		
	
		for(int i=0;i<N;i++){
			if(!a[i].isEmpty())
				pq.insert(i, a[i].readString());
		}
		
		
		while(!pq.isEmpty()){
			StdOut.print(pq.minKey());
			int i=pq.delMin();
			
			if(!a[i].isEmpty())
				pq.insert(i, a[i].readString());
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		In[] in=new In[3];
		in[0]=new In("C:\\Users\\Llorando\\m1.txt");
		in[1]=new In("C:\\Users\\Llorando\\m2.txt");
		in[2]=new In("C:\\Users\\Llorando\\m3.txt");
		merge(in);
		}

}
