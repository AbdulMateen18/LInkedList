public class Node<T>{
	private T data;
	private Node prev;
	private Node next;


	public Node(T data){
		this.setData(data);
		this.setNext(null);
		this.setPrev(null);
	}


	public T getData() {
		return data;
	}


	public void setData(T data) {
		this.data = data;
	}


	public Node getPrev() {
		return prev;
	}


	public void setPrev(Node prev) {
		this.prev = prev;
	}


	public Node getNext() {
		return next;
	}


	public void setNext(Node next) {
		this.next = next;
	}

	
}