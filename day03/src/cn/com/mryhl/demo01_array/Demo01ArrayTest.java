package cn.com.mryhl.demo01_array;

/*
用数组保存Student对象
数组具有定长行,不能改变长度.
 */
public class Demo01ArrayTest {
    public static void main(String[] args) {
        //创建数组
        Student[] stuArr = new Student[3];
        //创建对象
        Student student0 = new Student("张1", 13);
        Student student1 = new Student("张2", 14);
        Student student2 = new Student("张3", 15);
        //添加到数组
        stuArr[0] = student0;
        stuArr[1] = student1;
        stuArr[2] = student2;
        //遍历数组
        /*
        for (int i = 0; i < stuArr.length; i++) {
            System.out.println(stuArr[i]);
        }
        结果:存的是对象的地址
        cn.com.mryhl.demo01_array.Student@1b6d3586
        cn.com.mryhl.demo01_array.Student@4554617c
        cn.com.mryhl.demo01_array.Student@74a14482
         */
        for (int i = 0; i < stuArr.length; i++) {
            System.out.println("学生姓名为:"+stuArr[i].getName()+",学生年龄为:"+stuArr[i].getAge());
        }


    }
}
