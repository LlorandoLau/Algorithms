import java.io.File;

import edu.princeton.cs.algs4.In;


public class PartMinOfArray {

	public static int find(double a[],int lo,int hi) {
		int mid=lo+(hi-lo)/2;
		int index=-1;
		//只有a[mid]是局部最小值时返回a[mid]的索引mid，其它情况返回-1
		if(a[mid]<a[mid+1] && a[mid]>a[mid-1])
			index=find(a,lo,mid-1);
		else if(a[mid]<a[mid-1] && a[mid]>a[mid+1])
			index=find(a, mid+1, hi);
		else if(a[mid]>a[mid-1] && a[mid]>a[mid+1]){
	       index=find(a, lo, mid-1);
	       if(index==-1)
	    	   index=find(a, mid+1, hi);
	       return index;
		}else {
			return mid;
		}
		return index;
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File file=new File("C:\\Users\\Llorando\\2Kints.txt");
	    In in=new In(file);
        double[] a = in.readAllDoubles();
        int min=find(a,0,a.length-1);
        if(min!=-1)
        	StdOut.print(a[min-1]+" "+a[min]+" "+a[min+1]);
        StdOut.println(min);
	}

}
