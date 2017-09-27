import java.awt.RenderingHints.Key;

import javax.xml.soap.Node;

import org.omg.CORBA.portable.ValueBase;

public class GPA<Key, Value> {
	private Node first;

	private class Node {
		String key;
		double val;
		int sum;
		Node next;

		public Node(String key, double val, int sum, Node next) {
			this.key = key;
			this.val = val;
			this.sum = sum;
			this.next = next;
		}
	}

	private class Average {
		double sum;
		int num;

		public Average(double sum, int num) {
			this.sum = sum;
			this.num = num;
		}

		public Average() {
			this.sum = 0;
			this.num = 0;
		}

		public double Average() {
			StdOut.println(this.sum+" "+this.num);
			return this.sum / this.num;
		}
	}

	public double get(Key key) {
		for (Node x = first; x != null; x = x.next) {
			if (key.equals(x.key))
				return x.val;
		}
		return -1;
	}

	public void put(String key, double val) {
		for (Node x = first; x != null; x = x.next) {
			if (key.equals(x.key)) {
				x.val += val;
				return;
			}
		}
		first = new Node(key, val, 1, first);

	}

	public void printAverage() {
		Average A = new Average();
		Average B = new Average();
		Average C = new Average();
		Average D = new Average();

		for (Node s = first; s != null; s = s.next) {

			if(s.key.contains("A"))
				A=test(A, s);
			else if(s.key.contains("B"))
				B=test(B, s);
			else if(s.key.contains("C"))
				C=test(C, s);
			else if(s.key.contains("D"))
				D=test(D, s);

			
		}
		
		StdOut.println(A.Average() + " " + B.Average() + " " + C.Average()
				+ " " + D.Average());
	}

	public Average test(Average sub, Node s) {

		
			if (sub.sum == 0) {
				sub = new Average(s.val, 1);
			} else {
				sub.sum += s.val;
				sub.num += 1;
			}
			return sub;
	
		

	}

	public void average() {
		int a = 0;
		for (Node x = first; x != null; x = x.next) {
			if (x.key.contains("A"))
				a += x.val;
		}
		StdOut.println(a);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GPA s = new GPA();
		s.put("A+", 4.33);
		s.put("A", 4.00);
		s.put("A-", 3.67);
		s.put("B+", 3.33);
		s.put("B", 3.00);
		s.put("B-", 2.67);
		s.put("C+", 2.33);
		s.put("C", 2.00);
		s.put("C-", 1.67);
		s.put("D", 1.00);
		s.put("F", 0.00);
		s.printAverage();

	}

}
