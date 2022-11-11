/*
Names:Bikorimana Saveur, 221005770
      Muyizere Elia ,221018202
      Bananayo Sostene,221002523
      Mbabazi Karara Ange,221003454
*/
package linkedlist;

public class LinkedList {
    class Node
    {
        int data;
        Node next;
        public Node(int a)
        {
            data=a;
            next=null;
        }
    }
    Node head;
    Node tail;
    int size;
    public void insertAtFront(int a)
    {
        Node newNode=new Node(a);
        if(head==null)
        {
            head=newNode;
            tail=newNode;
        }
        else{
            newNode.next=head;
            head=newNode;
        }
        size++;
    }
    public void insertBack(int a)
    {
        Node newNode=new Node(a);
        if(head==null)
        {
            head=newNode;
            tail=newNode;
        }
        else{
            tail.next=newNode;
            tail=newNode;
        }
        size++;
    }
    public void display()
    {
        Node n=head;
        while(n.next!=null)
        {
            System.out.println(n.data);
            n=n.next;
        }
        System.out.println(n.data);
    }
    public LinkedList concatinate(LinkedList list) 
    {
        tail.next=list.head;
        tail=list.tail;
        return this;
    }
    public  boolean isSorted(LinkedList list)
    {
        if(list.head==null || list.size==1) return true;
        Node node=list.head;
        while(node.next!=null)
        {
           if(node.data>node.next.data)
               return false;
           node=node.next;
        }
        return true;
    }
    public Node compareTwONode(Node List1Head,Node list2Head)
    {
        Node dummyNode=new Node(0);
        Node temp=dummyNode;
        while(true)
        {
           if(List1Head==null)
           {
               temp.next=list2Head;
               break;
           }
           else if(list2Head==null)
           {
               temp.next=List1Head;
               break;
           }
           if(List1Head.data<=list2Head.data)
           {
             temp.next=List1Head;
             List1Head=List1Head.next;           
           }
           else{
              temp.next=list2Head;
              list2Head=list2Head.next;
           }
           temp=temp.next;
        }
        return dummyNode.next;
    }
    public LinkedList merge(LinkedList list) 
    {
       if(!isSorted(this) || !isSorted(list))
       {
           return null;
       }
       else
       {
           this.head=compareTwONode(this.head,list.head);
       }
       return this;
    }
    public static void main(String[] args)
    {
        LinkedList list1=new LinkedList();
        LinkedList list2=new LinkedList();
        list1.insertBack(12);
        list1.insertBack(90);
        list1.insertBack(34);
        list1.insertAtFront(25);
        list1.insertAtFront(76);
        
        list2.insertBack(3);
        list2.insertBack(10);
        list2.insertBack(13);
        list2.insertBack(20);
        //list2.insertBack(9);
        list1.concatinate(list2);
        System.out.println("Concatinated List");        
        list1.display();
        System.out.println("Merged list:");
        LinkedList list3=new LinkedList();
        list3.insertBack(1);
        list3.insertBack(4);
        list3.insertBack(5);
        list3.insertBack(9);
        list3.insertBack(12);
        list2.merge(list3);
        list2.display();
    }
}
