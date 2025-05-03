public class borrowInfo {
    String username;
    String bookname;
    String time;
    public borrowInfo(String username,String bookname,String time){
        this.username=username;
        this.bookname=bookname;
        this.time=time;
    }
    public borrowInfo(String username,String bookname){
        this.username=username;
        this.bookname=bookname;
    }
    public String returnInfo(){
        return username+"/"+bookname;
    }
    public String toString(){
        return username+"/"+bookname+"/"+time;
    }

}
