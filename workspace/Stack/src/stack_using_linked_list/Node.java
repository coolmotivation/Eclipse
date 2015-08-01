package stack_using_linked_list;

public class Node {
		private Node next;
		private Integer data;
		public Node()
		{
			this.next=null;
			this.data=null;
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
}
