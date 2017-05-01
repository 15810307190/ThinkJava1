package String;

/**
 * Created by MiMi on 2017/5/1.
 */
public class StringEqual {
    public static void main(String args[]){
        String s1="hello";
        String s2="hello";
        String s3=new String("hi");
        String s4=new String("hi");
        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));
        System.out.println(s3==s4);
        System.out.println(s3.equals(s4));
    }
}
