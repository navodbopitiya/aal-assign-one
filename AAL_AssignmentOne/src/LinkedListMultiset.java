import java.io.PrintStream;

public class LinkedListMultiset<T> extends Multiset<T>
{
	
	protected Node mHead;
	protected Node mTail;
	protected int mLength;
	
	
	public LinkedListMultiset() {
		// Implement me!
		
		 mHead = null; 
	     mTail = null;
	     mLength = 0;
			
	
	} // end of LinkedListMultiset()
	
	
	public void add(T item) {
		// Implement me!
		
		 Node newNode = new Node(item);
		 
		 	
	        if (mHead == null) {
	        	// If head is empty, then the list is empty
	            mHead = newNode;
	            mTail = newNode;
	            mLength++;
	        }else if(search(item) != 0){
	        	//Item already exists in the list - increase count
	        	
	        }else {
	        	// item doesn't exist, add node to the head of list.
	            newNode.setNext(mHead);
	            mHead.setPrev(newNode);
	            mHead = newNode;
	            mLength++;
	        }
	        
	        
	} // end of add()
	
	
	@Override
	public int search(T item) {
		// Implement me!

		Node currNode = mHead;
		int instances = 0;
		
        for (int i = 0; i < mLength; ++i) {
        	if (currNode.getValue() == item) {
        		instances++;
        	}
            currNode = currNode.getNext();
        }
        
        return instances;
		
	} // end of search()
	
	
	public void removeOne(T item) {
		// Implement me!
		
        Node currNode = mHead;

       // check if value is head node
        if (currNode.getValue() == item) {
            // check if length of 1
            if (mLength == 1) {
                mHead = mTail= null;
            }
            else {
                mHead = currNode.getNext();
                mHead.setPrev(null);
                currNode = null;
            }
            
            mLength--;
         }
        // search for value in rest of list
        else {
            currNode = currNode.getNext();

            while (currNode != null) {
                if (currNode.getValue() == item) {
                    Node prevNode = currNode.getPrev();
                    prevNode.setNext(currNode.getNext());
                    // check if tail
                    if (currNode.getNext() != null) {
                    	currNode.getNext().setPrev(prevNode);
                    }
                    else {
                    	mTail = prevNode;
                    }
                    currNode = null;
                    mLength--;
               }
 
                currNode = currNode.getNext();
            }	
        }

        // couldn't find a node with value
       
	} // end of removeOne()
	
	
	public void removeAll(T item) {
		// Implement me!
	} // end of removeAll()
	
	
	public void print(PrintStream out) {
		// Implement me!
	} // end of print()
	
	/* Creating Node class */
	
	class Node {
		
		private T mItem;
		private Node mNext, mPrev;
		
		public Node(T item) {
			
			mItem = item;
			mNext = null;
			mPrev = null;
					
		}
		
		/* Get the values */
				
		 public T getValue() {
	            return mItem;
	        }

	        public Node getNext() {
	            return mNext;
	        }
	        
	        
	        public Node getPrev() {
	            return mPrev;
	        }


	        public void setValue(T item) {
	            mItem = item;
	        }


	        public void setNext(Node next) {
	            mNext = next;
	        }
	        
	        public void setPrev(Node prev) {
	            mPrev = prev;
	        }
		
	
		
		
	}
	
} // end of class LinkedListMultiset