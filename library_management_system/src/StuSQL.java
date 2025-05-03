import java.io.*;

public class StuSQL {

    static String Path="Borrow_n_Return_Book.txt";
    static String Path1="testData.txt";
    static String Path2="UserData.txt";
    static String math="";

    static private File filename=new File(Path);
    static private File filename1=new File(Path1);
    static private File filename2=new File(Path2);


    //文件读出
    static private String ReadStr="";



    public static void stuReadout(){
        //用于储存结构体的temp
        String[] name=new String[1000010];
        String name1="";


        Sort obj=new Sort();

        FileReader fr;
        BufferedReader br;
        try {
            fr= new FileReader(filename1);
            br = new BufferedReader(fr);
            int i=0;//name数量
            int j=0;//条列树
            //读取path1 中的用户名
            try{

                while((ReadStr=br.readLine())!=null){
                    String[] temp=ReadStr.split("=");
                    name[i]=temp[0];
                    i++;
                }
                br.close();
            }catch(IOException e){
                e.printStackTrace();
            }

            //读取path2中的用户名
            try{
                fr=new FileReader(filename2);
                br=new BufferedReader(fr);
                while((ReadStr=br.readLine())!=null){
                    String[] temp=ReadStr.split("=");
                    name[i]=temp[0];
                    i++;
                }
                br.close();
            }catch(IOException e){
                e.printStackTrace();
            }

            try{

                fr=new FileReader(filename);
                br=new BufferedReader(fr);
                while((ReadStr=br.readLine())!=null){
                    String[] temp=ReadStr.split("/");
                    name1+=temp[0];
                    j++;
                }
            }catch(IOException e){
                e.printStackTrace();
            }
            for(int k=0;k<i;k++){
                System.out.println(name[k]);
            }
            //替代
            System.out.println(name1);
            for(int k=0;k<i;k++){
                int count=0;
                String temp=name1;
                while(temp.indexOf(name[k])!=-1){
                    temp=temp.substring(temp.indexOf(name[k])+1,temp.length());
                    count++;
                }
                obj.addNode(name[k],count);
            }
            //替代

            obj.sortList();
            obj.display();
            math=obj.returnSting();


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public int countString(String str,String s) {//question
        int count = 0,len = str.length();
        while(str.indexOf(s) != -1) {
            str = str.substring(str.indexOf(s) + 1,str.length());
            count++;
        }
        System.out.println("此字符串有" + count + "个" + s);
        return count;
    }

    public static String returnString(){
        return math;
    }

    public static void main(String[] args){
        StuSQL t=new StuSQL();
        t.stuReadout();
    }
}
