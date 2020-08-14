package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pojo.Teacher;

public class Test {
	public static void main(String[] args) {
//		三.scope 属性
//		1. <bean>的属性,
//		2. 作用:控制对象有效范围(单例,多例等)
//		3. <bean/>标签对应的对象默认是单例的.
//			3.1 无论获取多少次,都是同一个对象
//		4. scope 可取值
//			4.1 singleton 默认值,单例
//			4.2 prototype 多例,每次获取重新实例化
//			4.3 request 每次请求重新实例化
//			4.4 session 每个会话对象内,对象是单例的.
//			4.5 application 在application对象内是单例
//			4.6 global session spring 推出的一个对象, 依赖于spring-webmvc-portlet ,类似于session
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		Teacher teacher = ac.getBean("teacher1",Teacher.class);
		Teacher teacher1 = ac.getBean("teacher1",Teacher.class);
		Teacher teacher2 = ac.getBean("teacher2",Teacher.class);
		System.out.println(teacher==teacher1);//true 同一个对象取多次是相同的说明是单例
		System.out.println(teacher==teacher2);//false 取不同的对象说明是多例
		Teacher teacher3 = ac.getBean("teacher3",Teacher.class);
		Teacher teacher4 = ac.getBean("teacher3",Teacher.class);
		System.out.println(teacher3==teacher4);// false scope="prototype"代表多例，每次取都是不同的代码
		Teacher teacher5 = ac.getBean("teacher4",Teacher.class);
		Teacher teacher6 = ac.getBean("teacher4",Teacher.class);
		System.out.println(teacher5==teacher6);// true scope="singleton"代表单例，每次取都是相同的代码
	}

}
