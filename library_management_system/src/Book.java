import java.io.Serializable;

public class Book implements Serializable{
    int count=0;
    int lendoutcount=0;
    String name;
    String introduce;

    public Book(String name){
        super();
        this.name=name;
    }
    public Book(String name, String introduce) {
        super();
        this.name = name;
        this.introduce = introduce;
    }
    public Book(String name,String introduce,int count){
        this.name=name;
        this.introduce=introduce;
        this.count=count;
    }
    public Book(String name,String introduce,int count,int lendoutcount){
        this.name=name;
        this.introduce=introduce;
        this.count=count;
        this.lendoutcount=lendoutcount;
    }

    public String getName(){
        return "书名=[" + name + "]";
    }
    public String Name(){
        return "书名=[" + name + "], 简介=[" + introduce + "]";
    }
    public String delString(){
        return "Book (书名=[" + name + "], 简介=[" + introduce + "]";
    }
    public String toString() {
        return "Book (书名=[" + name + "], 简介=[" + introduce + "]"+" 数量=["+count+"]"+"借出数量=["+lendoutcount+"])";
    }

}


