package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;

public class JsoupDemo3 {
    public static void main(String[] args) throws IOException {
        //parse​(URL url, int timeoutMillis) 通过网络路径获取指定的html或xml的文档对象
        URL url=new URL("https://www.csdn.net");
        Document document = Jsoup.parse(url, 5000);
        System.out.println(document);
    }
}
