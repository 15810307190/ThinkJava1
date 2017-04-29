package Decorate;

/**
 * Created by MiMi on 2017/4/28.
 */
public class FinalTest {
    public static Integer getInt(){
        Integer i=new Integer(10);
        try{
            return ++i;
        }finally {
            System.out.println("will deal with i");

            System.out.println("dealed with");
        }
    }
    public static void main(String args[]){
        Integer i = getInt();
        System.out.println(i);
        try{
            return;
        }finally {
            System.out.println("wo le ge qu");
        }
    }
}
