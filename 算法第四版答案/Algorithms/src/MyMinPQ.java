import java.awt.DisplayMode;
import java.awt.RenderingHints.Key;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;

import javax.swing.text.DefaultEditorKit.InsertBreakAction;

public class MyMinPQ<Key extends Comparable<Key>> {


	private Key[] pq;
	private int[] I, J;
	private int N = 0;

	public MyMinPQ(int maxN) {
		pq = (Key[]) new Comparable[maxN + 1];
		I = new int[maxN + 1];
		J = new int[maxN + 1];
	}

	public void Display() {
		StdOut.println("value: " + pq[1] + "I: " + I[1] + "J: " + J[1]);
	}

	public boolean isempty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	public void Insert(Key k, int i, int j) throws IOException {
		//StdOut.print(I[1]+" "+J[1]);
		if (N >= 1) {
			if (k==pq[1]) {
				StdOut.println("pq[1]: "+k+"| a: " + I[1] + "| b: " + J[1] +"| k: "+k+ "| c: " + i + "| d: "
						+ j+"\n");
				return;
			}
		}
		pq[++N] = k;
		I[N] = i;
		J[N] = j;
		swim(N);
	}

	public Key delMin() {
		pq[0] = pq[1];
		I[0] = I[1];
		J[0] = J[1];

		Key min = pq[1];
		exch(1, N--);
		pq[N + 1] = null;
		sink(1);

		return min;
	}

	public boolean less(int i, int j) {
		return pq[i].compareTo(pq[j]) < 0;
	}

	private void exch(int i, int j) {
		Key t = pq[i];
		pq[i] = pq[j];
		pq[j] = t;

		int subi = I[i];
		I[i] = I[j];
		I[j] = i;

		int subj = J[i];
		J[i] = J[j];
		J[j] = subj;
	}

	public void sink(int k) {
		while (2 * k <= N) {
			// j是子节点，k是父节点
			int j = 2 * k;
			if (j < N && less(j + 1, j))
				j++;
			// pq[j]>pq[k]，子节点大于父节点
			if (!less(j, k))
				break;
			exch(k, j);
			k = j;
		}
	}

	public void swim(int k) {
		while (k > 1 && less(k, k / 2)) {
			exch(k / 2, k);
			k = k / 2;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int N = (int) Math.pow(10, 6);
	
		MinPQ pq = new MinPQ<>(N);
		for (int i = 0; i < N; i++) {
			for (int j = i; j < N; j++) {
				BigDecimal b1=new BigDecimal(i*i*i);
				BigDecimal b2=new BigDecimal(j*j*j);
				b1=b1.add(b2);
				//StdOut.println(b1);
				pq.Insert(b1, i, j);
				if (pq.size() > N - 1) {
					pq.delMin();
				}
			}
			StdOut.print(i+" ");

		}

	}
}
