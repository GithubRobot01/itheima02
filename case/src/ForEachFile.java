import java.io.File;

public class ForEachFile {
    public static void main(String[] args) {
        File file=new File("D:\\File");
        foreach(file);
    }
    public static void foreach(File file){
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory()){
                System.out.println(f.getAbsolutePath());
                foreach(f);
            }else {
                System.out.println(f.getAbsolutePath());
            }
        }
    }
}
