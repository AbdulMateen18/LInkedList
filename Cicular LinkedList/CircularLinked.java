import java.util.Arrays;

public class CircularLinked<T> {
	
	private Node first;
	private Node last;
	private int count;
	
	public CircularLinked() {
		first=last=null;
		this.count=0;
	}
	
	public void addFirst(T item) {
		Node n = new Node(item);
		if(first==null && last==null) {
			first=last=n;
			last.setNext(first);
		}
		else {
			n.setNext(first);
			first=n;
			last.setNext(first);
		}
		count++;
	}
	
	public void addLast(T item) {
		Node n = new Node(item);
		if(first==null && last==null) {
			first=last=n;
			last.setNext(first);
		}
		else {
			last.setNext(n);
			last=n;
			n.setNext(first);
		}
		count++;
	}
	
	public void addAll(T[] array) {
		for(int i=0;i<array.length;i++) {
			Node n = new Node(array[i]);
			if(first==null && last==null) {
				first=last=n;
			}
			
			last.setNext(n);
			last=n;
			count++;		
		}
	}
	
	public void addBetween(T item,int position) {
		Node n = new Node(item);
		if(first==null && last==null) {
			first=last=n;
		}
		else {
			Node pre = getNodeAt(position-1);
			Node after = pre.getNext();
			pre.setNext(n);
			n.setNext(after);

		}
		count++;
	}
	
	public void removeFirst() {
		Node sec = first.getNext();
		first.setNext(null);
		first = null;
		first = sec;
		last.setNext(first);
		count--;
	}
	
	public void removeLast() {
		Node current = first;
		while(current.getNext()!=last) {
			current =current.getNext();
		}
		current.setNext(null);
		//last=null;
		last = current;
		last.setNext(first);
		count--;
	}
	
	public void removeAt(int position) {
		Node pre = getNodeAt(position-1);
		Node nodeToRemove = pre.getNext();
		Node after = nodeToRemove.getNext();
		pre.setNext(after);
		nodeToRemove=null;
		count--;
	}
	
	public void clear() {
		first=last=null;
	}
	
	public T[] toArray() {
		T[] arr =(T[]) new Object[count];
		Node current = first;
		for(int i=0;i<arr.length && current!=null;i++) {
			arr[i]=(T) current.getData();
			current=current.getNext();
		}
		
		return arr;
	}

	private Node getNodeAt(int position) {
		// TODO Auto-generated method stub
		Node current = first;
		if(position==count) {
			current = last;
		}else {

			for(int i=1;i<position;i++) {
				current = current.getNext();
			}
		}	
		return current;
	}
	
	public void print() {
		Node current = first;
		do{
			System.out.print(current.getData()+" -> ");
			current = current.getNext();
		}while(current!=first);
		System.out.println();

	}// print
	
	public <T extends Comparable<T>> int indexOf(T value) {
		int index = 0;
		Node cur = first;
		while (cur != null) {
			if (((T) cur.getData()).compareTo(value)==0) {
				return index;
			}
			index++;
			cur = cur.getNext();
		} // while
		return -1;
	}

	public boolean contains(int value) {
		return indexOf(value) != -1;
	}
	
	public T replace(T item,int position) {
		Node nodeToReplace = getNodeAt(position);
		T temp = (T) nodeToReplace.getData();
		nodeToReplace.setData(item);
		return temp;
	}
	
	public T getEntry(int position) {
		return (T) getNodeAt(position).getData();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircularLinked l = new CircularLinked();
		
		l.addLast(2);
		l.addLast(4);
		l.addLast(6);
		l.addLast(8);
//		
//		l.addLast(0);
//		l.addBetween(1, 6);
		
//		l.removeFirst();
//		l.removeLast();
//		
//		
		l.print();

		System.out.println("\n\n");

		l.removeLast();
		l.removeLast();
		l.removeLast();
		l.print();
//		
//		l.removeAt(4);
//		System.out.println();
//		l.print();
//		
		//System.out.println(l.replace(1213, 4));
//		Integer[] arr = {1,2,3,4,5,6,7,8,3,2,1};
//		l.addAll(arr);
//		Node n = new Node(12);
//		Node nodeF = l.first.getNext().getNext().getNext().getNext();
//		Node nodeS = nodeF.getNext();
//		nodeF.setNext(n);
//		n.setNext(nodeS);
//		l.count++;
//		System.out.println(Arrays.toString(l.toArray()));
	}

}
