public class ThrowEggs_1_4_25_a{
	public static int rank(int[] a,int key) {
		int N=a.length-1;
		int j=-1;
		for(int i=0;i<Math.sqrt(N);i++){
			if(Math.sqrt(N)*i>key){
				j=i-1;
				break;
			}
		}
		
		int F=(int) (j*Math.sqrt(N));
		int F_higer=(int)((j+1)*Math.sqrt(N));
		StdOut.println("F: "+F+" F_higer:"+F_higer);
		return BinarySearch(a, key,F,F_higer);
	}

	public static int BinarySearch(int[] a, int key, int lo, int hi) {
		if (lo > hi)
			return -1;

		int mid = (int) (lo + (hi - lo) / 2);
		int index = -1;

		if (key > a[mid])
			index = BinarySearch(a, key, mid + 1, hi);
		else if (key < a[mid])
			index = BinarySearch(a, key, lo, mid - 1);
		else
			return mid;
		
		return index;
	}

	public static void main(String[] args) {
		int[] a=new int[10000];
		for(int i=0;i<10000;i++){
			a[i]=i;
		}
		StdOut.print(rank(a, 500));
		
	}
}

	