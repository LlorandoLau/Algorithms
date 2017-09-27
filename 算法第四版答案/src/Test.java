import java.io.ObjectOutputStream.PutField;

import edu.princeton.cs.algs4.SparseVector;
public class Test{
public static void main(String[] args){
	/*SparseVector a=new SparseVector(5);
	a.put(4, 6);
	a.put(1, 5);
	a.put(1, 8);
	StdOut.print(a);*/
	SparseVector[] a=new SparseVector[5];
	for(int i=0;i<5;i++){
		a[i]=new SparseVector(5);
		for(int j=0;j<5;j++){
			if(i==j)
				a[i].put(j,i*j);
		}
	}
	for(int i=0;i<5;i++)
		StdOut.println(a[i].get(i));
	}
}