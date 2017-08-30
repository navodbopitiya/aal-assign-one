import java.io.PrintStream;
import java.util.*;

public class BstMultiset<T> extends Multiset<T> {
	private Node mRoot;

	public BstMultiset() {
		mRoot = null;
	} // end of BstMultiset()

	public void add(T item) {
		mRoot = insert(mRoot, item);
	} // end of add()

	public Node insert(Node node, T item) {

		if (node == null) {
			Node newNode = new Node(item);
			return newNode;
		}
		if (((String) item).compareTo((String) node.getItem()) > 0) {
			// add to the right
			node.setRightChild(insert(node.getRightChild(), item));

		} else if (((String) item).compareTo((String) node.getItem()) < 0) {
			// add to the left
			node.setLeftChild(insert(node.getLeftChild(), item));
		} else {
			// Item already exists in the tree, increase count.
			node.increaseCount();
		}
		return node;
	}// end of insert

	public Node find(Node node, T item) {

		while (node != null) {
			if (((String) item).compareTo((String) node.getItem()) == 0) {
				return node;
			} else if (((String) item).compareTo((String) node.getItem()) < 0) {
				node = node.getLeftChild();
			} else {
				node = node.getRightChild();
			}
		}
		return null;
	}// end of find

	public int search(T item) {
		Node node = find(mRoot, item);
		if (node == null) {
			return 0;
		} else {
			return node.getCount();
		}
	} // end of add()

	public void removeOne(T item) {
		Node node = find(mRoot, item);

		if (node != null) {
			node.decreaseCount();
			if (node.getCount() == 0) {
				// If Count is zero, we need to remove entire node
				removeNode(mRoot, item);
			}
		}
	} // end of removeOne()

	public void removeAll(T item) {
		Node node = find(mRoot, item);
		if (node != null) {
			removeNode(mRoot, item);
		}
	} // end of removeAll()

	public void removeNode(Node node, T item) {
		Node leftNode;
		Node rightNode;
		Node parentNode = null;
		int check = 0;

		while (check != 1) {
			if (((String) item).compareTo((String) node.getItem()) == 0) {
				if (parentNode == null) {
					if (node.getRightChild() != null) {
						rightNode = node.getRightChild();
						if (node.getLeftChild() != null) {
							mRoot = node.getLeftChild();
							/* insert right node into left subtree */
							insert(mRoot, rightNode.getItem());
						} else {
							mRoot = node.getRightChild();
						}
					} else if (node.getLeftChild() != null) {
						mRoot = node.getLeftChild();
					} else {
						mRoot = null;
					}

				} else {
					/* item is in parent's left sub-tree */
					if (((String) item).compareTo((String) node.getItem()) < 0) {

						rightNode = node.getRightChild();
						parentNode.setLeftChild(node.getLeftChild());
						if (rightNode != null) {
							insert(mRoot, rightNode.getItem());
						}
						/* item is in parent's right sub-tree */
					} else if (((String) item).compareTo((String) node.getItem()) > 0) {

						leftNode = node.getLeftChild();
						parentNode.setRightChild(node.getRightChild());
						if (leftNode != null) {
							insert(mRoot, leftNode.getItem());
						}
					}
				}
				check = 1;
			} else if (((String) item).compareTo((String) node.getItem()) < 0) {
				parentNode = node;
				node = node.getLeftChild();
			} else {
				parentNode = node;
				node = node.getRightChild();
			}
		}
	}// end of removeNode

	public void print(PrintStream out) {
		inOrder(mRoot, out);
	} // end of print()

	public void inOrder(Node root, PrintStream out) {
		if (root == null) {
			return;
		}
		inOrder(root.getLeftChild(), out);
		out.println(root.getItem() + printDelim + root.getCount());
		inOrder(root.getRightChild(), out);
	}// end of inOrder

	public class Node {
		private T mItem;
		private int mCount;
		private Node mRightChild;
		private Node mLeftChild;

		public Node(T item) {
			mItem = item;
			mCount = 1;
			mRightChild = null;
			mLeftChild = null;

		}

		public T getItem() {
			return mItem;
		}

		public Node getLeftChild() {
			return mLeftChild;
		}

		public void setLeftChild(Node node) {
			mLeftChild = node;
		}

		public Node getRightChild() {
			return mRightChild;
		}

		public void setRightChild(Node node) {
			mRightChild = node;
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

	}// end of inner class Node

} // end of class BstMultiset
