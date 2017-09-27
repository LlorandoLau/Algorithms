import edu.princeton.cs.algs4.Quick;


public class select {

	 private static boolean less(Integer v, Integer w) {
	        return v.compareTo(w) < 0;
	    }
	        
	    // exchange a[i] and a[j]
	    private static void exch(Object[] a, int i, int j) {
	        Object swap = a[i];
	        a[i] = a[j];
	        a[j] = swap;
	    }

	 private static int partition(Integer[] a, int lo, int hi) {
	        int i = lo;
	        int j = hi + 1;
	        Integer v = a[lo];
	        while (true) { 

	            // find item on lo to swap
	            while (less(a[++i], v))
	                if (i == hi) break;

	            // find item on hi to swap
	            while (less(v, a[--j]))
	                if (j == lo) break;      // redundant since a[lo] acts as sentinel

	            // check if pointers cross
	            if (i >= j) break;

	            exch(a, i, j);
	        }

	        // put partitioning item v at a[j]
	        exch(a, lo, j);

	        // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
	        return j;
	    }

	public static Integer select(Integer[] a,int k,int lo,int hi){
		if(lo>hi)
			return -1;
		int kmin=k-1;
		int j=partition(a,lo,hi);
		Integer sub=-1;
		if(j==kmin)
			sub= a[kmin];
		else if(j>kmin)
			sub= select(a,kmin,lo,j-1);
		else if(j<kmin)
			 sub= select(a,kmin,j+1,hi);
		return sub;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] a={1,2,3,4,50,6,7,8,9};
		StdOut.print(select(a, 5, 0, a.length-1));
	}

}
