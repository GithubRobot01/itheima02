package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class JsoupDemo1 {
    public static void main(String[] args) throws IOException {
        //获取document对象,根据xml文档获取
        //获取student.xml的path路径
        String path = JsoupDemo1.class.getClassLoader().getResource("student.xml").getPath();
        //解析xml文档,加载文档进内存,获取dom树-->Document对象
        //parse​(File in, String charsetName)：解析xml或html文件的。
        Document doc = Jsoup.parse(new File(path), "utf-8");
        System.out.println(doc);
        //获取元素对象 Element
        Elements elements = doc.getElementsByTag("name");
        //获取第一个name的Element对象
        Element element = elements.get(0);
        //获取数据
        String name = element.text();
        System.out.println(name);
    }
}
