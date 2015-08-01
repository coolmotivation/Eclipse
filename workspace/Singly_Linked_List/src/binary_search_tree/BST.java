package binary_search_tree;

import java.util.Scanner;

public class BST {
    static Node root=new Node();
 //Main method
    public static void main(String args[])
    {
    	Scanner sc=new Scanner(System.in);
    	while(true)
    	{
    		System.out.println("Enter 1:Insertion 2:Deletion 3:Max 4:Min 5:Successor 6:Predecessor 7:Exit");
    		int n=Integer.parseInt(sc.nextLine());
    		switch(n)
    		{
    		case 1:
    			{
    			  System.out.println("Enter the key to be inserted::");
    			  int k=Integer.parseInt(sc.nextLine());
    			  insertion(k);
    			  inorder(root);
    			  System.out.println(" ");
    			  break;
    			}
    		case 2:
    			{
    			   System.out.println("Enter the key to be deleted::");
    			   int k=Integer.parseInt(sc.nextLine());
    			   deletion(k);
    			   inorder(root);
    			   System.out.println(" ");
    			   break;
    			}
    		case 3:
    			{
    			   Node temp=max(root);
    			   System.out.printf("The maximum key is:%d",temp.getData());
    			   break;
    			}
    		case 4:
    			{
    			  Node temp=min(root);
    			  System.out.printf("The minimum key is:%d",temp.getData());
    			  break;
    			}
    		case 5:
    			{
    				System.out.println("Enter the key whose successor is to be found::");
    			    int key=Integer.parseInt(sc.nextLine());
    				Node temp=successor(key);
    				if(temp!=null)
    				    System.out.printf("the successor of %d is %d",key,temp.getData());
    				else
    					System.out.println("Sorry,it's successor does not exist!!!");
    				break;
    			}
    		case 6:
			{
				System.out.println("Enter the key whose predecessor is to be found::");
			    int key=Integer.parseInt(sc.nextLine());
				Node temp=predecessor(key);
				if(temp!=null)
				        System.out.printf("the predecessor of %d is %d",key,temp.getData());
				else
					    System.out.println("Sorry,it's predecessor does not exist!!!");
				break;
			}
			default:
				    System.exit(0);
    		}
    	}
    }
    public static void inorder(Node temp)
    {
    	if(temp!=null)
    	{
    		inorder(temp.getLeft());
    		System.out.printf("%d ",temp.getData());
    		inorder(temp.getRight());
    	}
    }
 //Insertion Method
    public static void insertion(int key)
    {
    	if(root.getData() == null)
    	{
    		root.setData(key);
    	}
    	else
    	{
    		Node temp=root;
    		Node x=null;
    		while(temp != null)
    		{
    			x=temp;
    			if(key < temp.getData())
    				temp=temp.getLeft();
    			else
    				temp=temp.getRight();
    		}
    		//x is the parent of the newNode
    		Node newNode =new Node();
    		newNode.setData(key);
    		newNode.setParent(x);
    		if(key < x.getData())
    			x.setLeft(newNode);
    		else
    			x.setRight(newNode);
    	}
    }
    public static void deletion(int key)
    {
    	Node temp=root;
    	while(temp.getData() != key)
    	{
    		if(temp.getData() < key)
    			temp=temp.getRight();
    		else
    			temp=temp.getLeft();
    	}
    	//now temp is the node to be deleted
    	if(temp.getLeft()==null && temp.getRight()==null)
    	{
    		nochild(temp);
    	}
    	else if(temp.getLeft()==null || temp.getRight()==null)
    	{
    	  onechild(temp);	
    	}
    	else if(temp.getLeft()!=null && temp.getRight()!=null)
    	{
    		Node suc=successor(temp.getData());
    		temp.setData(suc.getData());
    		if(suc.getLeft()==null && suc.getRight()==null)
    			nochild(suc);
    		else
    			onechild(suc);
    	}
    }
    public static void nochild(Node temp)
    {
    	Node par=temp.getParent();
    	if(root == temp)  // in this case only par can be null
    		{
    		root.setData(null);
    		}
    	else if(temp == par.getLeft())
			par.setLeft(null);
		else if(temp == par.getRight())
			par.setRight(null);
    }
    public static void onechild(Node temp)
    {
    	Node x;
		if(temp.getLeft()==null)
			x=temp.getRight();
		else
			x=temp.getLeft();
		//x is the node which will replace temp Node
		if(temp == root)
		{
			x.setParent(null);
			root=x;
		}
		else
		{
		x.setParent(temp.getParent());
		if((temp.getParent()).getLeft() == temp)
			(temp.getParent()).setLeft(x);
		else
			(temp.getParent()).setRight(x);
		}

    }
    public static Node successor(Integer key)
    { 
    	Node temp=root;
    	while(temp.getData() != key)
    	{
    		if(temp.getData() < key)
    			temp=temp.getRight();
    		else
    			temp=temp.getLeft();
    	}
    	if(temp.getRight() != null)
    	{
    		Node suc=min(temp.getRight());
    		return suc;
    	}
    	else
    	{
    		Node child=temp;
    		Node par=temp.getParent();
    		if(par!=null){
    		while(child!=par.getLeft())
    		{
    			child=par;
    			par=par.getParent();
    			if(par==null)
    				break;
    		}}
    		return par;
    	}
    }
    public static Node predecessor(Integer key)
    {
    	Node temp=root;
    	while(temp.getData() != key)
    	{
    		if(temp.getData() < key)
    			temp=temp.getRight();
    		else
    			temp=temp.getLeft();
    	}
    	if(temp.getLeft() != null)
    	{
    		Node pre=max(temp.getLeft());
    		return pre;
    	}
    	else
    	{
    		Node child=temp;
    		Node par=temp.getParent();
    		if(par!=null){
    		while(child!=par.getRight())
    		{
    			child=par;
    			par=par.getParent();
    			if(par==null)
    				break;
    		}}
    		return par;
    	}
    }
    public static Node max(Node temp)
    {
    	while(temp.getRight()!=null)
    	{
    		temp=temp.getRight();
    	}
    	return temp;
    }
    public static Node min(Node temp)
    {
    	while(temp.getLeft()!=null)
    	{
    		temp=temp.getLeft();
    	}
    	return temp;
    }
}
