package point_to_next_higher_value;

public class Node {
	private Node next;
	private Node arb;
	private Integer data;

	public Node()
	{
		this.data=null;
		this.arb=null;
		this.next=null;
		
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
