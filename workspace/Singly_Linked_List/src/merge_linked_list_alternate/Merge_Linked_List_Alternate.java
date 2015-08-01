//Merge a linked list into another linked list at alternate positions

package merge_linked_list_alternate;
import java.util.Scanner;

public class Merge_Linked_List_Alternate {
	static Node fhead=new Node();
	static Node shead=new Node();
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of elements in the first linked list::");
		int y=Integer.parseInt(sc.nextLine());
		for(int i=0;i<y;i++)
		{
			insertion(fhead,sc.nextInt());
		}
		sc.nextLine();
		
		System.out.println("Enter the number of elements in the second linked list::");
		y=Integer.parseInt(sc.nextLine());
		for(int i=0;i<y;i++)
		{
			insertion(shead,sc.nextInt());
		}
		sc.nextLine();
		
		System.out.println("Merging the 2 linked list alternatively,we get::");
		merge_2_linked_list_alternatively();
		printLinkedList(fhead);
		System.out.println(" ");
		printLinkedList(shead);
	}
	public static void merge_2_linked_list_alternatively()
	{
		Node ftemp=fhead;
		Node stemp=shead;
		while(ftemp!=null && stemp!=null)
		{
			Node nftemp=ftemp.getNext();
			Node nstemp=stemp.getNext();
			ftemp.setNext(stemp);
			stemp.setNext(nftemp);
			ftemp=nftemp;
			shead=nstemp;
			stemp=nstemp;
		}
		
	
	}
	public static void printLinkedList(Node temp)
	{
		while(temp!=null)
		{
			System.out.printf("%d ",temp.getData());
			temp=temp.getNext();
		}
	}
	public static void insertion(Node temp,int key)
	{   
		if(temp.getData()==null)
			{
			temp.setData(key);
			//System.out.println(temp.getData());
			}
		else
		{
			while(temp.getNext()!=null)
			{
				temp=temp.getNext();
			}
			Node newNode=new Node();
			newNode.setData(key);
			temp.setNext(newNode);
			//System.out.println(newNode.getData());
		}
	}
}
