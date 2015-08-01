package doubly_linked_list;

public class Node {
     private Node prev;
     private Node next;
     private Integer data;
     public Node()
     {
    	 this.prev=null;
    	 this.next=null;
    	 data=null;
     }
     public void setData(int data)
     {
    	 this.data=data;
     }
     public  Integer getData()
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
     public void setPrev(Node temp)
     {
    	 this.prev=temp;
     }
     public Node getPrev()
     {
    	 return this.prev;
     }
}
