package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class Selector {
    public static void main(String[] args) throws IOException {
        //获取student.xml的path
        String path = JsoupDemo4.class.getClassLoader().getResource("student.xml").getPath();
        //获取Document对象
        Document document = Jsoup.parse(new File(path), "utf-8");
        //查询name标签
        Elements elements = document.select("name");
        System.out.println(elements);
        System.out.println("-----------");
        //查询id值为1的元素
        Elements elements1 = document.select("#1");
        System.out.println(elements1);
        System.out.println("-----------");
        //获取number属性值为001的student标签的age子标签
        Elements elements2 = document.select("student[number='001']");
        System.out.println(elements2);
        System.out.println("-----------");
        Elements elements3 = document.select("student[number='001'] > age");
        System.out.println(elements3);
        System.out.println("-----------");

    }
}
