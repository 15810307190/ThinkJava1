package Txt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by MiMi on 2017/4/22.
 */
public class DateSplit {
    public static void main(String args[]){
        try {
            BufferedReader br=new BufferedReader(new FileReader(new File("data")));
            br.readLine();
            String str=br.readLine();
            Map<String,Integer> hashMap=new HashMap<String,Integer>();
            while(str!=null){
                String[] strs=str.split(",");
                if(hashMap.get(strs[1])!=null){
                    hashMap.put(strs[1],hashMap.get(strs[1])+1);
                }else{
                    hashMap.put(strs[1],1);
                }
                str=br.readLine();
            }
            List<Map.Entry<String,Integer>> list=new ArrayList<Map.Entry<String,Integer>>(hashMap.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return o2.getValue().compareTo(o1.getValue());
                }
            });
            System.out.println(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
