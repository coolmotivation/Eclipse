package tree_traversal;

public class Node {
	private Node left;
	private Node right;
	private Node parent;
	private String color;
	private Integer data;   //properties
	public Node()
	{
		left=null;
		color="White";
		right=null;
		parent=null;
		data=null;
	}
	public void setColor(String color)
	{
		this.color=color;
	}
	public String getColor()
	{
		return this.color;
	}
	public void setData(Integer key)
	{
		this.data=key;
	}
	public Integer getData()
	{
		return this.data;
	}
	public void setLeft(Node l)
	{
		this.left=l;
	}
	public Node getLeft()
	{
		return this.left;
	}
	public void setRight(Node r)
	{
		this.right=r;
	}
	public Node getRight()
	{
		return this.right;
	}
	public void setParent(Node p)
	{
		this.parent=p;
	}
	public Node getParent()
	{
		return this.parent;
	}

}
