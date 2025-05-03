import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SQLTxt {
    public static BufferedReader bufread;
    // 存储的文件路径和名称
    private static String path = "BookInfo.txt";
    private static String path1="Borrower.txt";
    private static File filename1=new File(path1);
    private static File filename = new File(path);
    private static String readStr = "";

    /**
     * 1.添加内容.
     *
     * @param addStr 添加内容
     */
    public static void writeSQL(String addStr) throws IOException

    {
        FileWriter out;
        out = new FileWriter(path, true);
        out.write(addStr);
        // 换行
        out.write("\r\n");
        // 继续追加
        // 刷新IO内存流
        out.flush();
        // 关闭
        out.close();
    }

    /**
     * 2.删除内容.
     *
     * @param deleteStr 删除内容
     *
     */
    public static void deleteTxtByStr(String deleteStr) {
        String temp = "";
        try {
            File file = new File(path);
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuffer buf = new StringBuffer();
            //System.out.println(deleteStr);
            // 保存该行前面的内容
            System.out.println(deleteStr);
            for (int j = 1; (temp = br.readLine()) != null && temp.indexOf(deleteStr)==-1; j++) {
                buf = buf.append(temp);
                System.out.println(temp);
                buf = buf.append(System.getProperty("line.separator"));

            }
            // 保存该行后面的内容
            while ((temp = br.readLine()) != null) {

                buf = buf.append(temp);
                buf = buf.append(System.getProperty("line.separator"));
            }
            br.close();

            //关闭然后重新写入

            FileOutputStream fos = new FileOutputStream(file);
            PrintWriter pw = new PrintWriter(fos);
            pw.write(buf.toString().toCharArray());
            pw.flush();//刷新
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 3.将文件中指定内容的一行替换为其它内容.
     *
     * @param oldStr     查找内容
     * @param replaceStr 替换内容
     */
    public static void replaceTxtByStr(String oldStr, String replaceStr) {
        String temp2="";
        String temp = "";
        try {
            File file = new File(path);
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuffer buf = new StringBuffer();
            // 保存该行前面的内容
            for (int j = 1; (temp = br.readLine()) != null && temp.indexOf(oldStr)==-1; j++) {
                buf = buf.append(temp);
                buf = buf.append(System.getProperty("line.separator"));
            }

            // 将内容插入
            buf = buf.append(replaceStr);

            // 保存该行后面的内容
            while ((temp = br.readLine()) != null) {
                buf = buf.append(System.getProperty("line.separator"));
                buf = buf.append(temp);
            }
            buf=buf.append("\n");
            br.close();
            FileOutputStream fos = new FileOutputStream(file);
            PrintWriter pw = new PrintWriter(fos);
            pw.write(buf.toString().toCharArray());
            pw.flush();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*******

    书籍借阅

     */

    //借阅书籍
    public static void borBook(String name, int num/*,int id*/) throws UnsupportedEncodingException{
        /*String borrer="";
        try{
            File file1=new File(path1);
            FileInputStream f=new FileInputStream(file1);
            InputStreamReader isr1=new InputStreamReader(f);
            BufferedReader br=new BufferedReader(isr1);
            StringBuffer buf1=new StringBuffer();
            UserInfo userinfo=new UserInfo(id,name,num);


        }catch(IOException e){
            e.printStackTrace();

        }*/
        String regex="\\[(.*?)]";
        Pattern p=Pattern.compile(regex);
        String temp = "";
        try {
            File file = new File(path);
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuffer buf = new StringBuffer();
            // 保存该行前面的内容
            Book borname=new Book(name);
            System.out.println(borname.getName());
            for (int j = 1; (temp = br.readLine()) != null && temp.indexOf(borname.getName())==-1; j++) {
                buf = buf.append(temp);
                buf = buf.append(System.getProperty("line.separator"));
            }
            System.out.println(temp);//确认是寻找是否正确
            //分割
            Matcher m=p.matcher(temp);
            ArrayList<String> al=new ArrayList<>();
            while(m.find()){
                al.add(m.group(0));
            }
            String[] StringArray=al.toArray(new String[al.size()]);
            System.out.println(StringArray.length);
            for(int i=0;i<4;i++){
                String t="";
                int len=StringArray[i].length();
                for(int j=1;j<len-1;j++){
                    t+=StringArray[i].charAt(j);
                }
                StringArray[i]=t;
            }
            //确认分割内容
            for(int i=0;i<3;i++){
                System.out.println(StringArray[i]);
            }
            System.out.println("booknum"+StringArray[2]);
            Book re=new Book(StringArray[0],StringArray[1],Integer.parseInt(StringArray[2])-num,Integer.parseInt(StringArray[3])+num);
            // 将内容插入

            System.out.println(re.toString());
            buf = buf.append(re.toString());

            // 保存该行后面的内容
            while ((temp = br.readLine()) != null) {
                buf = buf.append(System.getProperty("line.separator"));
                buf = buf.append(temp);
            }
            buf=buf.append("\n");
            br.close();
            FileOutputStream fos = new FileOutputStream(file);
            PrintWriter pw = new PrintWriter(fos);
            pw.write(buf.toString().toCharArray());
            pw.flush();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 4.查找文本文件.
     *
     * @throws UnsupportedEncodingException
     *
     */
    public static void searchTxtFile(String searchStr) throws UnsupportedEncodingException {
        String read;
        FileReader fileread;
        readStr = "";
        String math;
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
                    math = "";
                    String regex = "\\[(.*?)]";
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(read);
                    String[] temp=new String[4];
                    int i=0;
                    while (matcher.find()) {
                        // System.out.println(matcher.group());
                        temp[i]=matcher.group(0);
                        math = math + temp[i];
                        i++;

                    }
                    int result1 = math.indexOf(searchStr);
                    // System.out.println(math+"-"+searchStr);
                    if (result1 != -1) {
                        Pattern pattern1 = Pattern.compile("(?<=\\()[^\\)]+");
                        Matcher matcher1 = pattern1.matcher(read);
                        while (matcher1.find()) {
                            // System.out.println(matcher1.group());
                            rmath = matcher1.group();
                        }
                        readStr = readStr + rmath + "\n";
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

    /**
     * 5.获取文本文件.
     *
     * @throws UnsupportedEncodingException
     * @param //file 打开的文件
     */
    public static void readTxtFile(String filepath) throws UnsupportedEncodingException {
        String read;
        FileReader fileread;
        readStr = "";
        File file = new File(filepath);
        try {
            fileread = new FileReader(file);
            bufread = new BufferedReader(fileread);
            try {
                while ((read = bufread.readLine()) != null) {
                    System.out.println(read);
                    readStr = readStr + read + "\n";
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

    /**
     * 6.添加到文件.
     *
     * @param addStr 添加内容
     */
    public static void writeTxtFile(String addStr) throws IOException

    {
        FileWriter out;
        out = new FileWriter(path, true);
        // out.write('\n');
        out.write(addStr);
        out.flush();
        // 关闭
        out.close();
    }

    /**
     * 7.获取全部文件
     *
     * @throws UnsupportedEncodingException
     * @param //file 打开的文件
     */
    public static void searchAllTxtFile() throws UnsupportedEncodingException {
        String read;
        FileReader fileread;
        readStr = "";
        String rmath = "";
        try {
            fileread = new FileReader(filename);
            bufread = new BufferedReader(fileread);
            try {
                while ((read = bufread.readLine()) != null) {

                    // System.out.println(read);
                    Pattern pattern1 = Pattern.compile("(?<=\\()[^\\)]+");
                    Matcher matcher1 = pattern1.matcher(read);
                    while (matcher1.find()) {
                        // System.out.println(matcher1.group());
                        rmath = matcher1.group();
                    }
                    readStr = readStr + rmath + "\n";
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
    /**
     * 8.删除全部文本.
     *
     * @throws UnsupportedEncodingException
     */
    public static void deleteAllTxtFile() throws UnsupportedEncodingException {
        String temp = "";
        try {
            File file = new File(path);
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuffer buf = new StringBuffer();
            buf = buf.append("");
            br.close();
            FileOutputStream fos = new FileOutputStream(file);
            PrintWriter pw = new PrintWriter(fos);
            pw.write(buf.toString().toCharArray());
            pw.flush();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getreadStr() {
        return readStr;

    }
}


