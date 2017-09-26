import java.io.File;
import java.util.Arrays;

import edu.princeton.cs.algs4.In;


public class FarestCouple {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File file=new File("C:\\Users\\Llorando\\2Kints.txt");
	    In in=new In(file);
        double[] a = in.readAllDoubles();
        int N=a.length;
		Arrays.sort(a);
		StdOut.print(a[0]+" "+a[N-1]);
	}

}
