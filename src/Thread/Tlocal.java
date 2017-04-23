package Thread;

import com.sun.org.apache.xml.internal.security.signature.reference.ReferenceNodeSetData;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * Created by MiMi on 2017/4/22.
 */
public class Tlocal {
    private static ThreadLocal<String> nameLocal=new ThreadLocal<String>();
    public String getNextString(){
        nameLocal.set(nameLocal.get()+"s");
        return nameLocal.get();
    }
    public static void main(String args[]){
        ExecutorService es= Executors.newCachedThreadPool();
        Tlocal tl=new Tlocal();
        for (int i=0;i<3;i++){
            es.execute(new testClient(tl));
        }
    }
    private static class testClient implements Runnable{
        private Tlocal tl;
        public testClient(Tlocal TL){
            this.tl=TL;
        }

        @Override
        public void run() {
            for (int i =0;i<3;i++){
                System.out.println(Thread.currentThread()+":"+tl.getNextString());
            }
        }
    }
}