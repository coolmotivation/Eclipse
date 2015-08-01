package tree_using_inorder_preorder;

public class Node {
	private Node left;
	private Node right;
	private Node parent;
	private Integer data;   //properties
	public Node(Integer data)
	{
		left=null;
		right=null;
		parent=null;
		this.data=data;
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
