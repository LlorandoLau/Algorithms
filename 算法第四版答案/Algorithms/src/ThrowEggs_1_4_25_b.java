public class ThrowEggs_1_4_25_b {
	public static int rank(int[] a, int key) {
		int N = a.length - 1;
		int j = -1;
		if (a[0] == key)
			return 0;
		else {
			for (int i = 1; i < N; i *= 2) {
				if (a[i] > key) {
					j = i;
					break;
				}
			}

			StdOut.println("F: " + j / 2 + " F_higer:" + j);
			return BinarySearch(a, key, j / 2, j);
		}
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

	