import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BookSortSQL {
    static String Path1="BookInfo.txt";
    static String Path2="Borrow_n_Return_Book.txt";

    static private File BookInfo=new File(Path1);//书籍信息
    static private File BRInfo=new File(Path2);//借阅次数信息

    static String math="";

    static String ReadStr="";
    static String result="";


    public static  void  BookSort(){
        String[] name=new String[1000010];

        Sort obj=new Sort();
        FileReader fr;
        BufferedReader br;

        int i=0;//书本的数量

        try{
            fr=new FileReader(BookInfo);
            br=new BufferedReader(fr);


            try{
                //读取所有的书名信息
                while((ReadStr=br.readLine())!=null){
                    System.out.println(ReadStr);
                    //使用正则进行匹配
                    String regex = "\\[(.*?)]";
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(ReadStr);
                    String[] temp=new String[4];
                    int j=0;
                    while(matcher.find()){
                        temp[j]=matcher.group(0);
                        j++;
                    }


                    name[i]=temp[0];
                    System.out.println(name[i]+"t");
                    i++;



                }
                fr.close();
                br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }catch(FileNotFoundException e){
            e.printStackTrace();
        }



        try{
            fr=new FileReader(BRInfo);
            br=new BufferedReader(fr);
            try{
                while((ReadStr=br.readLine())!=null){
                    String[] temp=ReadStr.split("/");
                    math+=temp[1];
                }
                fr.close();
                br.close();
            }catch(IOException e){
                throw new RuntimeException(e);
            }

        }catch(FileNotFoundException e){
            e.printStackTrace();
        }


        //修改书名格式，去除书名左右的[]
        for(int j=0;j<i;j++){
            String temp="";
            for(int k=1;k<name[j].length()-1;k++){
                temp+=name[j].charAt(k);
            }
            name[j]=temp;
        }
        System.out.println(math);

        for(int j=0;j<i;j++){
            int count=0;
            String temp=math;
            while(temp.indexOf(name[j])!=-1){
                temp=temp.substring(temp.indexOf(name[j])+1,temp.length());
                count++;
            }
            obj.addNode(name[j],count);
        }

        obj.sortList();
        obj.display();

        result=obj.returnSting1();
        System.out.println(result);
        math="";
        System.out.println(math+"!");
    }

    public static String returnString(){
        return result;
    }

    public static void main(String[] args){
        BookSortSQL t=new BookSortSQL();
        t.BookSort();
    }

}
