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
			//右节点是n，n的父节点是该节点
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
		//若二叉树中没有元素
		if (root == null) {
			root = v;
			root.Left = root.Right = root.Father = null;
			size++;
			return;
		}
		//大于根节点插进左边，小于插进右边，以此类推
		while (true) {
			//记录当前节点
			parent = node;
			if (less(v, node)) {  //v.key<node.key,右转
				node = node.Right;
				if (node == null) {
					parent.setRight(v);
					size++;
					return;
				}
			} else {//v.key>node.key,左转
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
		//二叉树中只剩下根节点
		if(size==1){
			Key max=root.key;
			root=null;
			size--;
			return max;
		}
		//二叉树没有左节点，最大值是根节点，删除根节点，并返回root.key
		if (root.Left == null) {
			Key max=root.key;
			root=root.Right;
			size--;
			return max;
		}else{
			Node node=root;
			while (true) {
				/*
				 * 最大值一直是node.left，一路到底
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
					//如果待删除节点还有右节点，node的值变为右节点的值，node=Right置空
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
