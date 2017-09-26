import java.awt.RenderingHints.Key;

public class MaxPQOfBinaryTree<Key extends Comparable<Key>> {
	private Node root = null;
	private int size = 0;

	private class Node {
		private Node Left, Right, Father;
		private Key key;

		public Node() {
			Left = Right = Father = null;
			key = null;
		}

		public void setRight(Node n) {
			//�ҽڵ���n��n�ĸ��ڵ��Ǹýڵ�
			this.Right = n;
			n.Father = this;
		}

		public void setLeft(Node n) {
			this.Left = n;
			n.Father = this;
		}
	}

	public boolean isempty() {
		return root == null;
	}

	public int size() {
		return size;
	}

	public void insert(Key k) {
		Node node = root;
		Node v = new Node();
		Node parent;
		v.key = k;
		//����������û��Ԫ��
		if (root == null) {
			root = v;
			root.Left = root.Right = root.Father = null;
			size++;
			return;
		}
		//���ڸ��ڵ�����ߣ�С�ڲ���ұߣ��Դ�����
		while (true) {
			//��¼��ǰ�ڵ�
			parent = node;
			if (less(v, node)) {  //v.key<node.key,��ת
				node = node.Right;
				if (node == null) {
					parent.setRight(v);
					size++;
					return;
				}
			} else {//v.key>node.key,��ת
				node = node.Left;
				if (node == null) {
					parent.setLeft(v);
					size++;
					return;
				}
			}
		}

	}

	public Key delmax() {
		//��������ֻʣ�¸��ڵ�
		if(size==1){
			Key max=root.key;
			root=null;
			size--;
			return max;
		}
		//������û����ڵ㣬���ֵ�Ǹ��ڵ㣬ɾ�����ڵ㣬������root.key
		if (root.Left == null) {
			Key max=root.key;
			root=root.Right;
			size--;
			return max;
		}else{
			Node node=root;
			while (true) {
				/*
				 * ���ֵһֱ��node.left��һ·����
				 */
				while(node.Left != null)
					node = node.Left;
				
				Node father = node.Father;
				Key max = node.key;
				
				if (node.Right == null) {
					father.Left = null;
					size--;
					return max;				
				} else {
					//�����ɾ���ڵ㻹���ҽڵ㣬node��ֵ��Ϊ�ҽڵ��ֵ��node=Right�ÿ�
					node.key=node.Right.key;
					node.Right=null;
					size--;
					return max;
				}
			}
		}
		
		
	}


	public boolean less(Node i, Node j) {
		return i.key.compareTo(j.key) < 0;
	}

	public static void main(String[] args) {
		MaxPQOfBinaryTree BT = new MaxPQOfBinaryTree<>();
		BT.insert(388);
		BT.insert(10);
		BT.insert(720);1
		BT.insert(550);

		int size = BT.size();
		for (int i = 0; i < size; i++) {
			StdOut.print(BT.delmax()+" ");
		}

	}

}
