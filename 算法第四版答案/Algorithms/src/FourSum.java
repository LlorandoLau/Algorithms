import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;


public class FourSum {

	public static int count(int[] a){
		Arrays.sort(a);
		int N=a.length;
		int cnt=0;
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				for(int k=0;k<N;k++)
				if(BinarySearch.rank(-a[i]-a[j]-a[k], a)>k)
					cnt++;
		return cnt;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file=new File("C:\\Users\\Llorando\\1Kints.txt");
		    In in=new In(file);
	        int[] a = in.readAllInts();

	        Stopwatch timer = new Stopwatch();
	        int count = count(a);
	        StdOut.println("elapsed time = " + timer.elapsedTime());
	        StdOut.println(count);
	}

}
