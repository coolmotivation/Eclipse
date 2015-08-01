package get_middle_of_the_stack;

public class Node {
		private Node prev;
		private Node next;
		private Integer data;
		public Node()
		{
			this.prev=null;
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
		public void setPrev(Node temp)
		{
			this.prev=temp;
		}
		public Node getPrev()
		{
			return this.prev;
		}
}
