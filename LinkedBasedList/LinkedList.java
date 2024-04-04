public class LinkedList<T> implements ListInterface<T>{
	private Node<T> first;
	private Node<T> last;
	private int count;
	
	public LinkedList(){
		this.first = null;
		this.last = null;
		this.count = 0;
	} 

	public void add(T item){
		Node<T> n = new Node<T>(item);
		if(this.first == null){
			this.first = n;
			this.last = n;
		}
		else
			{
				// Node<T> last = this.first;
				// while(last.getNext() != null){
				// 	last = last.getNext();
				// }
				// last.setNext(n);
				this.last.setNext(n);
				this.last = n;
			}
			this.count++;
	}
	public void add(int position, T item){
		Node n = new Node<T>(item);
		Node nodeBefore = getNodeAt(position-1);
		Node nodeAfter = nodeBefore.getNext();
		nodeBefore.setNext(n);
		n.setNext(nodeAfter);
		count++;

	}

	private Node getNodeAt(int position){
		assert (first!=null) && (position>=1) && (position<count) ;
			Node current = first;
			for (int i=1;i<position ;i++ ) {
				current = current.getNext();
			}	
			return current;
	}

	public T remove(int position){
		T result = null; // Return value
		 if ((position >= 1) && (position <= count))
		 {
		 assert !isEmpty();
		 if (position == 1) // Case 1: Remove first entry
		 {
		 result = first.getData(); // Save entry to be removed
		 first = first.getNext(); // Remove entry
		 }else // Case 2: Not first entry
		 {
			 Node nodeBefore = getNodeAt(position-1);
			 Node nodeToRemove = nodeBefore.getNext();
			 result = (T) nodeToRemove.getData(); // Save entry to be removed
			 Node nodeAfter = nodeToRemove.getNext();
			 nodeBefore.setNext(nodeAfter); // Remove entry
			 } // end if
			 count--; // Update count
			 return result; // Return removed entry
			 }
			 else
			 throw new IndexOutOfBoundsException( 
			 "Illegal position given to remove operation.");
	} // end remove


	// public T replace(int position, T item){
	// }
	// public void clear(){

	// }
	public boolean isEmpty(){
		return count==0;
	}
	// public T getEntry(int position){
	// }
	// public boolean contains(T item){
	// }
	// public int search(T item){
	// }
	// public int getLength(){
	// }
	// public T[] toArray(){

	// }

	@Override
	public void print(){
		Node current = first;
		// loop over list
		while (current != null) {
			System.out.print(current.getData() + " -> ");
			current = current.getNext();
		}
	}

	public static void main(String[] args) {
		LinkedList<Integer> l  =new LinkedList<>();
		l.add(22);
		l.add(26);
		l.add(12);
		l.add(76);
		l.add(5,69);
		l.print();
		System.out.println();
		l.remove(0);
		l.print();
		
	}
}