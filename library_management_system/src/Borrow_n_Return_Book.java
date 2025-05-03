import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Borrow_n_Return_Book {
    private static String Path="Borrow_n_Return_Book.txt";
    public static BufferedReader bufread;
    private static File filename = new File(Path);
    private static String readStr = "";
    Date date=new Date();
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    String nowDate=sdf.format(date);
    public static void BorrowBook(String username,String book,int count) throws IOException{
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String nowDate=sdf.format(date);
        FileWriter out;
        out=new FileWriter(Path,true);
        borrowInfo b=new borrowInfo(username,book,nowDate);
        for(int i=0;i<count;i++){
            out.write(b.toString()+"/1"+"\n");
            System.out.println(b.toString());
        }
        out.close();
    }
    public static void returnBook(String username,String book,int count)throws IOException{
        int counter=0;
        FileReader fileread;
        String read;
        String math="";
        borrowInfo b=new borrowInfo(username,book);
        try{
            fileread = new FileReader(filename);
            BufferedReader bufread = new BufferedReader(fileread);
            try{
                for(int j=1;(read=bufread.readLine())!=null;j++){
                    String temp=read;
                    if(read.indexOf(b.returnInfo())!=-1&&counter<count){
                        String[] strs=read.split("/");
                        strs[3]="0";
                        temp=strs[0]+"/"+strs[1]+"/"+strs[2]+"/"+strs[3];
                        System.out.println(strs[0]+"/"+strs[1]+"/"+strs[2]+"/"+strs[3]+"action");
                        counter+=1;
                    }
                    math+=temp+"\n";
                }
                bufread.close();

                FileWriter out;
                out=new FileWriter(Path,false);
                out.write(math);
                out.flush();
                out.close();
            }catch(IOException e){
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }catch(IOException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static void searchAllTxtFile() throws UnsupportedEncodingException {
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String nowDate=sdf.format(date);
        String read;
        FileReader fileread;
        readStr = "";
        try {
            fileread = new FileReader(filename);
            bufread = new BufferedReader(fileread);
            try {
                while ((read = bufread.readLine()) != null) {

                    String temp="";
                    temp=read;

                    String[] strs=temp.split("/");
                    System.out.println(strs.length);
                    if(strs[3].equals("1")){
                        temp="用户名=["+strs[0]+"] 书名=["+strs[1]+"] 借出日期=["+strs[2]+"] 剩余时间=["+(14-TimeCount.timecount(strs[2],nowDate))+"]";
                        int leastTime=TimeCount.timecount(strs[strs.length-2],nowDate);


                        readStr = readStr +temp+ "\n";
                    }
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    public static void searchTxtFile(String searchStr) throws UnsupportedEncodingException {
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String nowDate=sdf.format(date);
        String read;
        FileReader fileread;
        readStr = "";
        String math = "";
        String rmath = "";
        // String m="";
        try {
            fileread = new FileReader(filename);
            // InputStreamReader isr = new InputStreamReader(new FileInputStream(filename),
            // "UTF-8");
            bufread = new BufferedReader(fileread);
            try {
                while ((read = bufread.readLine()) != null) {
                    System.out.println(read);
                    math =read;
                    String[] strs=read.split("/");
                    //int result1 = math.indexOf(searchStr);
                    // System.out.println(math+"-"+searchStr);
                    if (strs[0].equals(searchStr)||strs[1].equals(searchStr)) {

                        readStr = readStr + "用户名="+strs[0]+"书名="+strs[1]+"借出日期："+strs[2]+"剩余时间："+(14-TimeCount.timecount(strs[2],nowDate))+"\n";
                    }
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    public static String getreadStr() {
        return readStr;

    }
    public static void main(String[] args){
        Borrow_n_Return_Book b=new Borrow_n_Return_Book();
    }
}
