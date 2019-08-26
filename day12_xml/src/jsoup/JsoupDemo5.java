package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
/*
Document：文档对象。代表内存中的dom树
    * 获取Element对象
    * getElementById​(String id)：根据id属性值获取唯一的element对象
    * getElementsByTag​(String tagName)：根据标签名称获取元素对象集合
    * getElementsByAttribute​(String key)：根据属性名称获取元素对象集合
    * getElementsByAttributeValue​(String key, String value)：根据对应的属性名和属性值获取元素对象集合
*/
public class JsoupDemo4 {
    public static void main(String[] args) throws IOException {
        //获取student.xml的path
        String path = JsoupDemo4.class.getClassLoader().getResource("student.xml").getPath();
        //获取Document对象
        Document document = Jsoup.parse(new File(path), "utf-8");
        //获取所有的student对象
        Elements elements = document.getElementsByTag("student");
        System.out.println(elements);
        System.out.println("--------------------");

        //获取属性名为big的对象们
        Elements elements1 = document.getElementsByAttribute("big");
        System.out.println(elements1);
        System.out.println("--------------------");

        //获取id值为001的对象
        Elements elements2 = document.getElementsByAttributeValue("number", "001");
        System.out.println(elements2);
        System.out.println("--------------------");

        //获取id属性值的元素对象
        Element age = document.getElementById("1");
        System.out.println(age);
    }
}
