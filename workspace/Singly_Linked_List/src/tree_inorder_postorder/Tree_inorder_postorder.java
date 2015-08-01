package tree_inorder_postorder;
import java.util.Scanner;

public class Tree_inorder_postorder {
	 static int[] inorder;
	   static int[] postorder;
	   static int postIndex;
	public static void main(String args[])
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the number of elements::");
			int n=Integer.parseInt(sc.nextLine());
			inorder=new int[n];
			postorder=new int[n];
			postIndex=n-1;
			System.out.println("Enter the inorder sequence fast::");
			for(int i=0;i<n;i++)
			{
				inorder[i]=sc.nextInt();
			}
			System.out.println("Enter the preorder sequence fast::");
			for(int i=0;i<n;i++)
			{
				postorder[i]=sc.nextInt();
			}
			Node root=build_tree(0,n-1);     
			printInorder(root);
			System.out.println(" ");
			printPostorder(root);
		}
	public static void printInorder(Node temp)
	{
		if(temp!=null)
		{
			printInorder(temp.getLeft());
			System.out.printf("%d ",temp.getData());
			printInorder(temp.getRight());
		}
	}
	public static void printPostorder(Node temp)
	{
		if(temp!=null)
		{
			printPostorder(temp.getLeft());
			printPostorder(temp.getRight());
			System.out.printf("%d ",temp.getData());
		}
	}
	public static Node build_tree(int instart,int inend)
	{
		if(instart > inend)
			return null;
		
		Node tNode=new Node(postorder[postIndex]);
		postIndex--;
		
		if(instart == inend)
			return tNode;
		
		int inIndex=search(instart,inend,tNode.getData());
		
		tNode.setRight(build_tree(inIndex+1,inend));
		tNode.setLeft(build_tree(instart,inIndex-1));
		
		return tNode;
	}
	public static int search(int start,int end,int data)
	{
		int i;
		for(i=start;i<=end;i++)
		{
			if(inorder[i] == data)
				return i;
		}
		return 0;
	}
}
