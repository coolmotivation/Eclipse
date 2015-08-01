package singly_linked_list_plaindrome;

public class Node {
	private Node next;
	private Character data;

	public Node()
	{
		this.data=null;
		this.next=null;
	}
	public void setData(Character data)
	{
		this.data=data;
	}
	public Character getData()
	{
		return this.data;
	}
	public void setNext(Node temp)
	{
		this.next=temp;
	}
	public Node getNext()
	{
		return this.next;
	}

}
