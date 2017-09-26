import java.io.File;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UF {
	private int[] id;
	private int count;
	private int visit;
	public UF(int N){
		count=N;
		id=new int[N];
		for(int i=0;i<N;i++){
			id[i]=i;
		}
	}
	public int getcount(){
		return count;
	}
	
	public void printall(){
		StdOut.print("id: ");
		for(int i=0;i<id.length;i++){
			StdOut.print(id[i]+" ");
		}
		StdOut.println("|visit times: "+visit);
	}
	public boolean connected(int p,int q){
		return find(p)==find(q);
	}
	//Quick Find
	public int find(int p){
		return id[p];
	}
	
	public void union(int p,int q){
		int pID=find(p);
		int qID=find(q);
		
		if(pID==qID)
			return;

		for(int i=0;i<id.length;i++){
			//把值为p的分量重命名为q的分量
			if(id[i]==pID){
				id[i]=qID;
				visit++;
			}
		}
		printall();
		
		count--;
	}
	public static void main(String[] args) {
		File file=new File("C:\\Users\\Llorando\\Workspaces\\MyEclipse Professional 2014\\Algorithms\\src\\1.5.1.txt");
		In in=new In(file);
		int N=in.readInt();
		UF uf=new UF(N);
		while(!in.isEmpty()){
			int p=in.readInt();
			int q=in.readInt();
			if(uf.connected(p, q))
				continue;
			uf.union(p, q);
			
		}
		StdOut.println(uf.getcount()+" components");
		
	}
}