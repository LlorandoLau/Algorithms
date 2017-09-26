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
				 * b��������һ��ֵ��Ϊ�գ���i=N-1ʱ��Ϊ������һ��ѭ����j++(��Ϊindex,b[index]�ĳ�ʼֵ��null)����֮�����ѭ����b[index]��Ϊ�������һ��Ԫ��
				 *��������ʱ��b[index]����
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
