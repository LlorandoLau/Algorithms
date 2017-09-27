import java.math.BigDecimal;

import edu.princeton.cs.algs4.MinPQ;
public class CubeSum  implements Comparable<CubeSum>{
	  private final double sum;
	    private final int i;
	    private final int j;

	    public CubeSum(int i, int j) {
	    	BigDecimal b1=new BigDecimal(i*i*i);
	    	BigDecimal b2=new BigDecimal(j*j*j);
	    	b1=b1.add(b2);
	  
	        this.sum = b1.doubleValue();
	        this.i = i;
	        this.j = j;
	    }

	    public int compareTo(CubeSum that) {
	        if (this.sum < that.sum) return -1;
	        if (this.sum > that.sum) return +1;
	        return 0;
	    }

	    public String toString() {
	        return sum + " = " + i + "^3" + " + " + j + "^3";
	    }


	    public static void main(String[] args) {

	        int n = 1000000;

	        // initialize priority queue
	        MinPQ<CubeSum> pq = new MinPQ<CubeSum>();
	        for (int i = 0; i <= n; i++) {
	            pq.insert(new CubeSum(i, i));
	        }

	        CubeSum pre=new CubeSum(-1, -1);
	        // find smallest sum, print it out, and update
	        while (!pq.isEmpty()) {
	            CubeSum s = pq.delMin();
	            if(pre.compareTo(s)==0)
	            	StdOut.println(s+" = " + pre.i + "^3" + " + " + pre.j + "^3");
	            if (s.j < n)
	                pq.insert(new CubeSum(s.i, s.j + 1));
	            pre=s;
	        }
	    }
}
