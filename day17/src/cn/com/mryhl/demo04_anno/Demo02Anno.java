package cn.com.mryhl.demo04_anno;
/*
自定义注解

    格式：
        public @interface 注解名 {

        }
 */

public class Demo02Anno {
    public static void main(String[] args) {

    }
    @Student(name = "上官嘏",hobbies = {"抽烟","喝酒","烫头"})
    public void method(){

    }
}
