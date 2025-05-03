public class SortList {
    class Node{
        int Data;
        Node next;
        public Node(int data){
            this.Data=data;
            this.next=null;
        }
    }
    public Node head=null;
    public Node tail=null;
    public void addNode(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            tail=newNode;
        }else{
            tail.next=newNode;
            tail=newNode;
        }
    }
    public void sortList(){
        Node current=head,index=null;
        int temp;
        if(head==null){
            return;
        }else{
            while(current!=null){
                index=current;
                while(index!=null){
                    if(current.Data>index.Data){
                        temp=current.Data;
                        current.Data=index.Data;
                        index.Data=temp;
                    }
                    index=index.next;
                }
                current=current.next;
            }
        }
    }
    public void display(){
        Node current=head;
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        while(current!=null){
            System.out.print(current.Data+" ");
            current=current.next;
        }
        System.out.println();
    }
    public static void main(String[] args){
        SortList sList=new SortList();
        sList.addNode(8);
        sList.addNode(9);
        sList.addNode(3);
        sList.addNode(12);
        System.out.println("Original list:");
        sList.display();
        sList.sortList();
        System.out.println("Sorted list:");
        sList.display();
    }
}
