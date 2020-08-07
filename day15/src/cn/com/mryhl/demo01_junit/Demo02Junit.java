package cn.com.mryhl.demo01_junit;

import org.junit.*;


/*
@Before:使用该注解修饰的方法，会在每次单元测试方法执行之前执行。
@After:使用该注解修饰的方法，会在每次单元测试方法执行之后执行。

@BeforeCLass:使用该注解修饰的方法，会在所有方法执行之前执行，只执行一次。
@AfterCLass:使用该注解修饰的方法，会在所有方法执行之后执行，只执行一次。

BeforeCLass MAfterCLass注解修饰的方法必须使用static静态修饰。
*/
public class Demo02Junit {
    @BeforeClass
    public static void beforeClassMethod(){
        System.out.println("前1");
    }
    @AfterClass
    public static void afterClassAfter(){
        System.out.println("后1");
    }
    @Before
    public void beforeMethod(){
        System.out.println("前");
    }
    @After
    public void afterAfter(){
        System.out.println("后");
    }
    @Test
    public void testMethod(){
        System.out.println("方法");
    }
    @Test
    public void testMethod2(){
        System.out.println("方法2");
    }
}
