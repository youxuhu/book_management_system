import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class PunishSysSQL {
    static String Path1="Borrow_n_Return_Book.txt";
    static String math="";
    static String math2="";
    private static File BorInfo=new File(Path1);


    public  static void Punishcount(){
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String nowDate=sdf.format(date);
        FileReader fr;
        BufferedReader br;
        try{
            fr=new FileReader(Path1);
            br=new BufferedReader(fr);
            String temp;
            try{
                while((temp=br.readLine())!=null){
                    String[] s=temp.split("/");
                    int flag=14-TimeCount.timecount(s[2],nowDate);
                    if(flag<0){
                        math+="姓名=["+s[0]+"], 借阅书籍=["+s[1]+"], 是否到期=[是], 逾期罚金=["+flag*(-1)*0.5+"]\n";
                    }else{
                        math+="姓名=["+s[0]+"], 借阅书籍=["+s[1]+"], 是否到期=[否], 逾期罚金=[0]\n";
                    }
                }
            }catch(IOException e){
                e.printStackTrace();
            }

        }catch(FileNotFoundException e){
            e.printStackTrace();
        }

    }

    public static void PunishInfoSearch(String searchStr){
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String nowDate=sdf.format(date);
        System.out.println("mark1");
        System.out.println(searchStr);
        FileReader fr;
        BufferedReader br;
        try{
            fr=new FileReader(Path1);
            br=new BufferedReader(fr);

            String temp;
            while((temp=br.readLine())!=null){
                String[] s=temp.split("/");
                if(s[0].equals(searchStr)||s[1].equals(searchStr)){
                    System.out.println("mark2");
                    int flag=14-TimeCount.timecount(s[2],nowDate);
                    if(flag<0){
                        math2+="姓名=["+s[0]+"], 借阅书籍=["+s[1]+"], 是否到期=[是], 逾期罚金=["+flag*(-1)*0.5+"]\n";
                    }else{
                        math2+="姓名=["+s[0]+"], 借阅书籍=["+s[1]+"], 是否到期=[否], 逾期罚金=[0]\n";
                    }
                }
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }


    public static String returnString(){
        return math;
    }

    public static String returnString1(){
        return math2;
    }

    public static void main(String[] args){

    }
}
