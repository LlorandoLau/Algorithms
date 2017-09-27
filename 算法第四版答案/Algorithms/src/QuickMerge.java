public class QuickMerge {

	private static Integer[] aux;

	public static Integer[] QuickMerge(Integer[] a) {
		int lo = 0, hi = a.length - 1;
		int mid = lo + (hi - lo) / 2;
		int j = mid + 1;
		for (int k = 0; k < hi - mid; k++)
			aux[k] = a[j++];
		j = mid + 1;
		int k = 0;
		int subhi = mid;
		while (k < hi - mid) {
			if (aux[k] > a[subhi - 1])
				a[subhi] = aux[k++];
			else {
				StdOut.print("aux[" + k + "]: " + aux[k] + " ");
				for (int h = 0; h < hi; h++) {
					StdOut.println("a[" + h + "]: " + a[h] + " ");
					if (aux[k] < a[h]) {
						StdOut.println(aux[k] + " " + a[h]);
						for (int l = ++subhi; l > h; l--)
							a[l] = a[l - 1];
						a[h] = aux[k++];
						break;
					}
				}
			}
		}
		return a;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] a = { 1, 5, 7, 8, 9,56,1,2,3, 4, 6, 11, 52, 65 };
		aux = new Integer[a.length];
		a = QuickMerge(a);
		for (int i = 0; i < a.length; i++) {
			StdOut.println(a[i]);
		}
	}

}
