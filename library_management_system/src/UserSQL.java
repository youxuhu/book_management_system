

import java.io.*;
import java.util.ArrayList;

public class UserSQL{
    static String Path1="UserData.txt";
    public static int logIn1(String username,String passWord)throws UnsupportedEncodingException{
        System.out.println(Path1+"logIn1");
        try{
            BufferedReader br=new BufferedReader(new FileReader(Path1));
            String line;
            ArrayList<String> readList=new ArrayList<String>();

            System.out.println(Path1);
            while((line=br.readLine())!=null){
                readList.add(line);
            }
            br.close();
            for(String a:readList){
                if(a.equals(username+"="+passWord)){
                    return 1;
                }
            }

        }catch(Exception e){

        }
        return 0;
    }

    public static int register1(String username,String passWord) throws UnsupportedEncodingException{
        System.out.println(Path1);
        try{
            BufferedReader br=new BufferedReader(new FileReader(Path1));
            String line;
            ArrayList<String[]> readLists=new ArrayList<String[]>();
            while((line=br.readLine())!=null){
                String[] s=line.split("=");
                readLists.add(s);
            }
            br.close();
            for(String[] b:readLists){
                for(String c:b){
                    if(c.equals(username)){
                        return 0;//用户名已经存在
                    }
                }
            }
            if(username.equals("")||passWord.equals("")){
                return 1;//用户名和密码不可为
            }else{
                String info=username+"="+passWord;
                BufferedWriter bw=new BufferedWriter(new FileWriter(Path1,true));
                bw.write(info);
                bw.newLine();
                bw.flush();
                bw.close();
            }

        }catch(Exception e){

        }
        return 2;//成功注册
    }
}
