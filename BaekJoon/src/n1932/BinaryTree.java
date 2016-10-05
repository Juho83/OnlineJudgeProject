package n1932;

public class BinaryTree {
	private BinaryTree parentTree = new BinaryTree();
	private int parentIndex;
	private int leftValue;
	private int rightValue;
	
	public void setParentTree(BinaryTree bt) {
		this.parentTree = bt;
	}
	
	public void setParentIndex(int index) {
		this.parentIndex = index;
	}
	
	public void setLeftValue(int value) {
		this.leftValue = value;
	}
	
	public void setRightValue(int value) {
		this.rightValue = value;
	}
	
	public BinaryTree getParentTree() {
		return this.parentTree;
	}
	
	public int getLeftValue() {
		return this.leftValue;
	}
	
	public int getRightValue() {
		return this.rightValue;
	}
	
	public int getParentIndex() {
		return this.parentIndex;
	}
}
