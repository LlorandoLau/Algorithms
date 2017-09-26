import java.io.File;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class WeightedQuickUnionUF {
	private int[] id;
	private int[] sz;  //���Ĵ�С
	private int count;
	private int visit;
	public WeightedQuickUnionUF(int N){
		count=N;
		id=new int[N];
		for(int i=0;i<N;i++){
			id[i]=i;
		}
		sz=new int[N];
		for(int i=0;i<N;i++){
			sz[i]=1;      //��ʼ��ʱ��ÿ���ڵ㿴��һ����
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
		StdOut.print("|sz: ");
		for(int i=0;i<sz.length;i++){
			StdOut.print(sz[i]+" ");
		}
		StdOut.println("|visit times: "+visit);
	}
	public boolean connected(int p,int q){
		return find(p)==find(q);
	}
	//Quick Find
	public int find(int p){
		while(p!=id[p])
			p=id[p];
		return p;
	}
	
	public void union(int p,int q){
		int i=find(p);
		int j=find(q);
		if(i==j)
			return;
		//С��id�ĳɴ���id������sz����С����
		if(sz[i]<sz[j]){
			id[i]=j;
			sz[j]+=sz[i];
		}else{
			id[j]=i;
			sz[i]+=sz[j];
		}
		visit++;
		printall();
		
		count--;
	}
	public static void main(String[] args) {
		File file=new File("C:\\Users\\Llorando\\Workspaces\\MyEclipse Professional 2014\\Algorithms\\src\\1.5.1.txt");
		In in=new In(file);
		int N=in.readInt();
		WeightedQuickUnionUF uf=new WeightedQuickUnionUF(N);
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