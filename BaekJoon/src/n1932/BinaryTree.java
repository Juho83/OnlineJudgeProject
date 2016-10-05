package n1932;

public class BinaryTree {
	private int data = 0;
	private BinaryTree leftNode;
	private BinaryTree rightNode;
	
	public void setData(int data) {
		this.data = data;
	}
	
	public void setLeftNode(BinaryTree leftNode) {
		this.leftNode = leftNode;
	}

	public void setRightNode(BinaryTree rightNode) {
		this.rightNode = rightNode;
	}
	
	public int getData() {
		return this.data;
	}
	
	public BinaryTree getLeftNode() {
		return this.leftNode;
	}

	public BinaryTree getRightNode() {
		return this.rightNode;
	}
}
