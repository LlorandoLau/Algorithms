import java.io.File;
import java.util.Arrays;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.In;


public class ClosestCouple {

	public static int rank(double key,double[] a) {
		  int lo = 0;
	      int hi = a.length - 1;
	      while (lo <= hi) {
	            // Key is in a[lo..hi] or not present.
	            int mid = lo + (hi - lo) / 2;
	            if      (key < a[mid]) hi = mid - 1;
	            else if (key > a[mid]) lo = mid + 1;
	            else return mid;
	        }
	       return -1;
	}
	public static void minDvalue(double[] a) {
		Arrays.sort(a);
		int N=a.length;
		double[] b=new double[N-1];
		int i=0;
		
		while(i<N-1){
			b[i]=a[i+1]-a[i];
			i++;
		}
		
		int min=0;
		for(int j=0;j<N-1;j++)
			if(b[j]<b[min])
				min=j;
		
		if(min>0){
		StdOut.print(a[min]+" "+a[min+1]+" "+(a[min+1]-a[min])+" "+b[min]);
		}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file=new File("C:\\Users\\Llorando\\2Kints.txt");
	    In in=new In(file);
        double[] a = in.readAllDoubles();
        minDvalue(a);
	}

}
