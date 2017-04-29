package FileTest;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by MiMi on 2017/4/28.
 */
public class DirList2 {
    public static void main(String[] args){
        File path = new File(".");
        String[] list;
        list=path.list(new FilenameFilter() {
            private Pattern pattern = Pattern.compile(".*");
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        });
        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        for(String str:list){
            System.out.println(str);
        }
    }
}
