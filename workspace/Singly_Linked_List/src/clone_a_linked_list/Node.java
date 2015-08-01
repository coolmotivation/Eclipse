package clone_a_linked_list;

public class Node {
	private Node next;
	private Node arb;
	private Integer data;
	public Node()
	{
		this.data=null;
		this.next=null;
		this.arb=null;
	}
	public void setData(Integer data)
	{
		this.data=data;
	}
	public Integer getData()
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
	public void setArb(Node temp)
	{
		this.arb=temp;
	}
	public Node getArb()
	{
		return this.arb;
	}
}