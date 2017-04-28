package String;

/**
 * Created by MiMi on 2017/4/24.
 */
public class ThreeString {
    public static void main(String args[]){
        Long time1 = System.currentTimeMillis();
        String result=null;
        for(int i=0;i<100000;i++) {
            result = result + "aa";
        }
        Long time2 = System.currentTimeMillis();
        StringBuilder ss=new StringBuilder();
        for(int i =0;i<100000;i++) {
            ss.append("aa");
        }
        Long time3 = System.currentTimeMillis();
        System.out.println(time2-time1);
        System.out.println(time3-time2);
        System.out.println(time1+":"+time2+":"+time3);
    }
}
