import edu.princeton.cs.algs4.BinarySearch;


public class BitonicSearch {
	public static boolean exist(int[] a,int key) {
		int max=FindMax(a,0,a.length);
		boolean exist=false;
		/*if(rank1(a, key, 0, max)!=-1 || rank2(a, key, max+1, a.length-1)!=-1)
			exist=true;*/
		if(rank1(a, key, 0, max)!=-1)
			exist=true;
		else if(rank2(a, key, max+1, a.length-1)!=-1)
			exist=true;
		return exist;
		
	}

	public static int rank1(int[] a,int key,int lo,int hi){
		if(lo>hi)
			return -1;
		
		int mid=lo+(hi-lo)/2;
		int indexOfKey=-1;
		if(key<a[mid])
			indexOfKey=rank1(a, key, lo, mid-1);
		else if(key>a[mid])
			indexOfKey=rank1(a, key, mid+1, hi);
		else 
			return mid;
		return indexOfKey;
	}
	public static int rank2(int[] a,int key,int lo,int hi) {
		if(lo>hi)
			return -1;
		
		int mid=lo+(hi-lo)/2;
		int indexOfKey=-1;
		if(key<a[mid])
			indexOfKey=rank2(a, key, mid+1, hi);
		else if(key>a[mid])
			indexOfKey=rank2(a, key, lo, mid-1);
		else 
			return mid;
		return indexOfKey;
		
	}
	public static int FindMax(int[] a,int lo,int hi) {
			int mid=lo+(hi-lo)/2;
			int indexOfMax=-1;
			/*双调数组中的数字关系有三种情况，一下分别对应：
			 * 2<3<5
			 * 5>4>3
			 * 1<3>2
			 */
			if(a[mid]<a[mid-1] && a[mid]<a[mid+1])
				indexOfMax=FindMax(a, mid+1, hi);
			else if(a[mid]>a[mid+1] && a[mid]<a[mid-1])
				indexOfMax=FindMax(a, lo, mid-1);
			else 
				return indexOfMax;
		
		return -1;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={1,2,3,4,5,6,5,4,3,2,1,0};
		StdOut.print(exist(a, 0));

	}

}
