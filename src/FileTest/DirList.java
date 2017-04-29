package FileTest;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.regex.Pattern;

/**
 * Created by MiMi on 2017/4/28.
 */
public class DirList {
    public static void main(String args[]){
        File path = new File(".");
        String[] list;
        list=path.list(new DirFilter("data"));
        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        for (String str:list) {
            System.out.println(str);
        }
    }
}
class DirFilter implements FilenameFilter{
    private Pattern pattern;
    public DirFilter(String regex){
        pattern = Pattern.compile(regex);
    }
    public boolean accept(File dir,String name){
        System.out.println("File:"+dir+"Name:"+name);
        return pattern.matcher(name).matches();
    }
}
