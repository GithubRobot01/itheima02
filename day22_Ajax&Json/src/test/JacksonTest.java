package test;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Person;
import org.junit.Test;

import java.io.FileWriter;
import java.util.*;

public class JacksonTest {

    //java对象转为Json
    @Test
    public void test1() throws Exception {
        Person p=new Person();
        p.setName("张三");
        p.setAge(23);
        p.setGender("男");

        //创建Jackson核心对象  ObjectMapper
        ObjectMapper mapper=new ObjectMapper();
        /*转换
            转换方法:
                writeValue(参数1,obj)
                    参数1:
                        File:将obj对象转换为JSON字符串,并保存到指定的文件中
                        Writer:将obj对象转换为JSON字符串,并将json数据填充到字符输出流中
                        OutputStream:将obj对象转换为JSON字符串,并将json数据填充到字节输出流中
                writeValueAsString(obj) 将对象转为Json字符串
         */
        String json = mapper.writeValueAsString(p);
        System.out.println(json);

        //mapper.writeValue(new File("D://File//json.txt"),p);
        mapper.writeValue(new FileWriter("D://File//json.txt"),p);
    }
    @Test
    public void test2() throws Exception {
        Person p = new Person();
        p.setName("张三");
        p.setAge(23);
        p.setGender("男");
        p.setBirthday(new Date());

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(p);
        System.out.println(json);
    }
    @Test
    public void test3() throws Exception {
        Person p1 = new Person();
        p1.setName("张三");
        p1.setAge(23);
        p1.setGender("男");
        p1.setBirthday(new Date());

        Person p2 = new Person();
        p2.setName("张三");
        p2.setAge(23);
        p2.setGender("男");
        p2.setBirthday(new Date());

        Person p3 = new Person();
        p3.setName("张三");
        p3.setAge(23);
        p3.setGender("男");
        p3.setBirthday(new Date());

        List<Person> list=new ArrayList<Person>();
        list.add(p1);
        list.add(p2);
        list.add(p3);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(list);
        System.out.println(json);
    }
    @Test
    public void test4() throws Exception {
        Map<String,Object> map=new HashMap<>();
        map.put("name","葵司");
        map.put("age",23);
        map.put("gender","男");

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(map);
        System.out.println(json);
    }
    @Test
    public void test5() throws Exception {
        //Json字符串转为java对象
        //初始化JSON字符串
        String json="{\"gender\":\"男\",\"name\":\"葵司\",\"age\":23}";
        //创建ObjectMapper对象
        ObjectMapper mapper = new ObjectMapper();
        Person person = mapper.readValue(json, Person.class);
        System.out.println(person);

    }
}
