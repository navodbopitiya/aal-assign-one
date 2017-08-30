import java.io.PrintStream;
import java.util.*;

public class BstMultiset<T> extends Multiset<T>
{
	private Node mRoot;
	
	public BstMultiset() {
		// Implement me!
		mRoot = null;
	} // end of BstMultiset()

	public void add(T item) {
		// Implement me!
	} // end of add()


	public int search(T item) {
		// Implement me!

		// default return, please override when you implement this method
		return 0;
	} // end of add()


	public void removeOne(T item) {
		// Implement me!
	} // end of removeOne()
	
	
	public void removeAll(T item) {
		// Implement me!
	} // end of removeAll()


	public void print(PrintStream out) {
		// Implement me!
	} // end of print()

	public class Node{
		/* Stored item of node */
		private T mItem;
		/* Reference to left child sub-tree */
		private Node mLeft;
		/* Reference to right child sub-tree */
		private Node mRight;
		/* Count of duplicate items in node */
		private int mCount;
		
		public Node(T item){
			mItem = item;
			mLeft = null;
			mRight = null;
			mCount = 1; 
		}

		public Node getLeft() {
			return mLeft;
		}

		public void setLeft(Node mLeft) {
			this.mLeft = mLeft;
		}

		public Node getRight() {
			return mRight;
		}

		public void setRight(Node mRight) {
			this.mRight = mRight;
		}

		public T getItem() {
			return mItem;
		}

		public int getCount() {
			return mCount;
		}
		
		public void increaseCount() {
			mCount++;
		}

		public void decreaseCount() {
			mCount--;
		}

	}
} // end of class BstMultiset
