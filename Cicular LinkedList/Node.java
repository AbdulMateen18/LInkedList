public class Node<T>{
	private T data;
	private Node next;

	public Node(T data){
		this.setData(data);
		this.setNext(null);
	}

	public void setData(T data){
		this.data = data;
	}

	public void setNext(Node next){
		this.next = next;
	}

	public T getData(){
		return this.data;
	}

	public Node getNext(){
		return this.next;
	}
}