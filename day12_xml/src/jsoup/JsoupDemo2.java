package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class JsoupDemo2 {
    public static void main(String[] args) throws IOException {
        String str="<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                "<students>\n" +
                "    <student id='001'>\n" +
                "        <name>zhangsan</name>\n" +
                "        <age>22</age>\n" +
                "        <gender>male</gender>\n" +
                "    </student>\n" +
                "    <student id='002'>\n" +
                "        <name>lisi</name>\n" +
                "        <age>23</age>\n" +
                "        <gender>female</gender>\n" +
                "    </student>\n" +
                "</students>";

        //parse​(String html)：解析xml或html字符串
        Document document = Jsoup.parse(str);
        System.out.println(document);
    }
}
