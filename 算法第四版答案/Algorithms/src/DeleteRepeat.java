import edu.princeton.cs.algs4.Quick;

public class DeleteRepeat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a = new String[54];
		int i = 0;

		while (i < 13)
			a[i++] = "a";
		while (i < 26)
			a[i++] = "b";
		while (i < 39)
			a[i++] = "c";
		while (i < 54)
			a[i++] = "d";
		a = dedup(a);
		StdOut.println(a.length);

	}

	public static String[] dedup(String[] a) {
		Quick.sort(a);
		int N = a.length;
		String[] b = new String[N];
		b[0] = a[0];
		int i = 1;
		int j = 1;
		while (i < N) {
			if (a[i - 1] == a[i]) {
				i++;
				continue;
			} else {
				/*
				 * b数组的最后一个值恒为空，当i=N-1时，为进行下一次循环，j++(设为index,b[index]的初始值是null)，但之后结束循环，b[index]成为数组最后一个元素
				 *进行运算时，b[index]忽略
				 */
				b[j++] = a[i++];
			}
		}
		//StdOut.println(b[j]);
		String[] c = new String[j];
		for (int k = 0; k < j; k++) {
			c[k] = b[k];
			//StdOut.println(c[k]);
		}
		return c;
	}

}
