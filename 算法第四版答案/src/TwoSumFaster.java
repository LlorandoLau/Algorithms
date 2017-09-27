import java.io.File;
import java.util.Arrays;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;


public class TwoSumFaster {

	public static int BiggerThanZero(int[] a) {
		Arrays.sort(a);
		for(int i=0;i<a.length;i++)
			if(a[i]>=0)
				return i;
		return -1;
	}
	public static int count(int[] a){
		Arrays.sort(a);
		int N=a.length;
		int cnt=0;
		int j=BiggerThanZero(a);
		if(j==-1)
			return -1;
		for(int i=0;i<j;i++){
			for(int k=j;k<N;k++){
				if(a[i]+a[k]>0)
					continue;
				if(a[i]+a[k]==0)
					cnt++;
				
			}
		}
		return cnt;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file=new File("C:\\Users\\Llorando\\2Kints.txt");
	    In in=new In(file);
        int[] a = in.readAllInts();
        Stopwatch timer = new Stopwatch();
        int count = count(a);
        StdOut.println("elapsed time = " + timer.elapsedTime());
        StdOut.println(count);
	}

}
