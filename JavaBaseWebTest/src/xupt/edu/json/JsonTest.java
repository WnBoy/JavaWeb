package xupt.edu.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;
import xupt.edu.pojo.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Wnlife
 * @create 2020-04-01 21:59
 */
public class JsonTest {

    /**
     * json <==>javaBean 之间的相互转换
     */
    @Test
    public void test1(){
        Person person = new Person(1, "爽");
        Gson gson=new Gson();

        //将 对象->json字符串
        String json = gson.toJson(person);
        System.out.println(json);

        //将 json字符串->对象
        Person person1 = gson.fromJson(json, Person.class);
        System.out.println(person);
    }

    /**
     * json <==>list 之间的相互转换
     */
    @Test
    public void test2(){
        Person person1 = new Person(1, "爽");
        Person person2 = new Person(2, "强");
        List<Person>list=new ArrayList<>();
        list.add(person1);
        list.add(person2);
        Gson gson=new Gson();

        //将 list -> json字符串
        String json = gson.toJson(list);
        System.out.println(json);

        //将 json字符串 -> list
        List<Person>list2=gson.fromJson(json,new TypeToken<List<Person>>(){}.getType());
        System.out.println(list);
    }

    /**
     * json <==> map 之间的相互转换
     */
    @Test
    public void test3(){
        Map<Integer,Person>map=new HashMap<>();
        map.put(1,new Person(1, "爽"));
        map.put(2,new Person(2, "强"));
        Gson gson=new Gson();
        //将 map -> json字符串
        String json = gson.toJson(map);
        System.out.println(json);
        //将 json字符串 -> map
        Map<Integer,Person>map2=gson.fromJson(json,new TypeToken<Map<Integer,Person>>(){}.getType());
        System.out.println(map2.get(1));
    }
}
