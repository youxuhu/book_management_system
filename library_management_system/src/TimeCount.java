import java.util.*;
import java.text.*;

public class TimeCount {
    public static int timecount(String starttime,String endtime){
        double days=0;
        DateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date star = dft.parse(starttime);//开始时间
            Date endDay=dft.parse(endtime);//结束时间
            Long starTime=star.getTime();
            Long endTime=endDay.getTime();
            Long num=endTime-starTime;//时间戳相差的毫秒数
            days=num/24/60/60/1000;
            return (int)days;

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return (int)days;
    }
    public static void main(String[] args) {
        int day=timecount("2020-01-02","2020-01-03");
        System.out.println(day);
    }

}
