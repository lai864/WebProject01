package com.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pojo.Person;
import com.pojo.PersonLIstType;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonTest {
    @Test
    public void test1(){
        Person person = new Person(1,"巨魔叔叔");
        //创建Gson对象实例
        Gson gson = new Gson();
        //toJson方法可以把java对象转换为Json字符串
        String personJsonString = gson.toJson(person);
        System.out.println(personJsonString);
        //第一个参数Json字符串
        //第二个参数是转换回去的java对象类型
        Person person1 = gson.fromJson(personJsonString, Person.class);
        System.out.println(person1);
    }

    //list和Json互转
    @Test
    public void test2(){
        List<Person> personList = new ArrayList<Person>();
        Person person1 = new Person(1,"混世魔王");
        Person person2 = new Person(2,"巨魔叔叔");

        personList.add(person1);
        personList.add(person2);

        Gson gson = new Gson();

        //把list转换为json字符串
        String personListJsonString = gson.toJson(personList);
        System.out.println(personListJsonString);

        //json字符串转为list,先创建PersonLIstType继承Gson的jar包里TypeToken类,可以使用匿名内部类
        List<Person> list = gson.fromJson(personListJsonString, new PersonLIstType().getType());
        System.out.println(list);
        Person person = list.get(0);
        System.out.println(person);


    }


    //map和Json互转
    @Test
    public void test3(){
        Map<Integer,Person> personMap = new HashMap<>();
        personMap.put(1,new Person(1,"巨魔叔叔"));
        personMap.put(2,new Person(2,"混世魔王"));

        Gson gson = new Gson();
        //map转换为json字符串
        String personMapJsonString = gson.toJson(personMap);
        System.out.println(personMapJsonString);
        //使用匿名内部类,继承Gson的jar包里TypeToken类
        Map<Integer, Person> personMap2 = gson.fromJson(personMapJsonString, new TypeToken<HashMap<Integer, Person>>() {
        }.getType());

        System.out.println(personMap2);
        Person person = personMap2.get(1);
        System.out.println(person);

    }
}
