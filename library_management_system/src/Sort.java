import java.util.*;
public class Sort {

    public node head=null;
    public node tail=null;

    class node{
        String name;
        int count;
        node next;
        public node(String name,int count){
            this.name=name;
            this.count=count;
        }
    }

    public void addNode(String name,int count){
        node n=new node(name,count);
        if(head==null){
            head=n;
            tail=n;
        }else{
            tail.next=n;
            tail=n;
        }
    }

    public void sortList(){
        node current=head;
        node index=null;

        if(head==null){
            return;
        }else{
            while(current!=null){
                index=current;
                while(index!=null){
                    if(index.count>current.count){
                        String tempname=index.name;
                        int tempcount=index.count;
                        index.name=current.name;
                        index.count=current.count;
                        current.name=tempname;
                        current.count=tempcount;
                    }
                    index=index.next;
                }
                current=current.next;
            }
        }
    }

    public void display(){
        node current=head;
        while(current!=null){
            System.out.println(current.name+" "+current.count);
            current=current.next;
        }
    }
    public String returnSting(){
        String str="";
        node current=head;
        int i=1;
        while(current!=null){
            str+="排名=["+i+"], 姓名=["+current.name+"], 借阅次数=["+current.count+"]\n";
            //str+=String.format("排名 = %-5d, 姓名 = %-10s, 借阅次数 = %-5d",i,current.name,current.count);
            current=current.next;
            i++;

        }
        return str;
    }

    public String returnSting1(){
        String str="";
        node current=head;
        int i=1;
        while(current!=null){
            str+="排名=["+i+"], 书名=["+current.name+"], 借阅次数=["+current.count+"]\n";
            current=current.next;
            i++;
        }
        return str;
    }

    public static void main(String[] args){
        Sort obj=new Sort();
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int count;
            String name;
            name=sc.next();
            count=sc.nextInt();
            if(count==-1){
                break;
            }
            obj.addNode(name,count);
        }
        obj.sortList();
        obj.display();
    }

}
