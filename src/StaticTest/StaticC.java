package StaticTest;

import FileTest.FDirectory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MiMi on 2017/4/29.
 */

public  class StaticC {
    static class StaticClass{
        public StaticClass(){
            System.out.println("StaticClass");
        }
    }
    class NolmalClass{
        public NolmalClass(){
            System.out.println("NormalClass");
        }
    }
    public static void main(String args[]){
        File file=new File(".");
        System.out.println(listFile(file));
    }
    static class TreeInfo{
        //设置两个list，一个用来存目录，一个用来存文件
        List<File> directorys=new ArrayList<>();
        List<File> files=new ArrayList<>();
        //添加所有的目录列表和文件列表
        public void addAll(TreeInfo treeInfo){
            directorys.addAll(treeInfo.directorys);
            files.addAll(treeInfo.files);
        }
        //重新tostring方法
        public String toString(){
            return directorys.toString()+"\n"+files.toString();
        }
    }
    public static TreeInfo listFile(File file){
        TreeInfo ti=new TreeInfo();
        //文件下所有的文件
        for(File files:file.listFiles()){
            //如果是目录的话，添加到目录列表，递归添加目录下的文件
            if(files.isDirectory()){
                ti.directorys.add(files);
                ti.addAll(listFile(files));
            }
            //如果是文件的话，添加到文件列表
            if(files.isFile()){
                ti.files.add(files);
            }
        }
        return ti;
    }
}
