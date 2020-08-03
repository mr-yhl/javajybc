package cn.com.mryhl.demo07_studentmanage;

import java.util.ArrayList;
import java.util.Scanner;

public class DemoTest {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        while (true) {
            printMenu();
            Scanner scanner = new Scanner(System.in);
            System.out.println("请进行功能选择:");
            int i = scanner.nextInt();
            choose(i, list);
        }

    }

    // 打印菜单
    public static void printMenu() {
        System.out.println("=============欢迎使用学生管理系统v1.0.1=============");
        System.out.println("1.添加学生");
        System.out.println("2.删除学生");
        System.out.println("3.修改学生");
        System.out.println("4.查看索引学生");
        System.out.println("5.退出系统");
        System.out.println("=============学生管理系统v1.0.1菜单结束=============");
    }

    // 功能选择
    public static void choose(int n, ArrayList<Student> list) {
        switch (n) {
            case 1:
                //System.out.println("添加学生");
                addStudent(list);
                break;
            case 2:
                //System.out.println("删除学生");
                delStudent(list);
                break;
            case 3:
                //System.out.println("修改学生");
                updateStudent(list);
                break;
            case 4:
                //System.out.println("查看所有学生");
                findAllStudent(list);
                break;
            case 5:
                System.out.println("退出系统,欢迎下次光临");
                System.exit(0);// 终止jvm,0表示正常结束,非0表示异常终止
                break;
            default:
                System.out.println("输入错误");
        }
    }

    /*
    查看所有学生,遍历保存学生的集合
        参数:ArrayList<Student>
        返回值:void
     */
    public static void findAllStudent(ArrayList<Student> list) {
        /*
        步骤:
            1.判断集合中是否有学生,没有结束本方法
            2.输出表头
            3.输出数据,输出集合中每个学生的属性
         */
        if (list.size() == 0) {
            System.out.println("还没有学生信息,需要添加学生,是否进入添加功能?(输入'y'进入,其他内容退出系统)");
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            if (s.equalsIgnoreCase("y"))
                addStudent(list);
            else
                System.exit(0);
            return;
        }
        System.out.println("学号\t\t姓名\t\t年龄\t\t地址");
        for (int i = 0; i < list.size(); i++) {
            Student student = list.get(i);
            System.out.println(student.getId() + "\t\t" + student.getName() + "\t\t" + student.getAge() + "\t\t" + student.getAddress());
        }

    }

    /*
    添加学生
        参数:ArrayList<Student>
        返回值:void
     */
    public static void addStudent(ArrayList<Student> list) {
        /*
        创建一个学生对象，并添加到参数ist集合中
        步骤：
            1.键盘录入学生信息
            2.根据键盘录入的学生信息创建学生对象。
            3.将学生对象添加到集合中。
            解决添加时学号重复的问题。要求，如果键盘录入的学号是重复的，那么就再次录入学生。
            如果用户键盘录入的学号一直是重复的，那么就要让用户一直录入。
            步骤：
            1.定义死循环
            2.在循环中键盘录入学生的学号。
            3.判断学号是否已经存在。
            如果学号已经存在了，那么就表示学号重复，那么就再进行下次循环记录录入学号。
            如果学号不存在，表示学号没有重复，那么就使用break跳出这个死循环
         */

        Scanner scanner = new Scanner(System.in);
        /*
        System.out.println("请输入学生学号:");
        String id = scanner.nextLine();
        for (int i = 0; i < list.size(); i++) {
            if (id.equals(list.get(i).getId())){
                System.out.println("学号已经存在,请重新输入");
                addStudent(list);
            }
        }*/
        String id="";
        while (true) {
            System.out.println("请输入学生学号:");
            id = scanner.nextLine();
            if (isUsed(list,id))
                System.out.println("学号存在了,请重新输入");
            else
                break;

        }
        System.out.println("请输入学生姓名:");
        String name = scanner.nextLine();
        System.out.println("请输入学生年龄:");
        String age = scanner.nextLine();
        System.out.println("请输入学生地址:");
        String addr = scanner.nextLine();
        Student student = new Student(id, name, age, addr);
        list.add(student);
        System.out.println("添加成功");
        return;
    }

    /*
    定义方法,判断学号存在[被使用]
    参数：ArrayList<Student>list,String id
返回值：boolean。学号被使用了，返回true,学号没有被使用就返回false
     */
    public static boolean isUsed(ArrayList<Student> list, String id) {

       /* 判断id这个学号在参数ist集合中是否存在。存在返回true,不存在就返回false
        步骤：
        1.遍历List集合，拿到里面的每一个学生对象
        2.判断通历到的学生的学号和要查找的学号是否相同。
        3.如果相同，表示学号存在，就直接返回true。
        4.如果遍历完集合也没有找到相同的学号，就表示学号不存在，就返回false*/
        for (int i = 0; i < list.size(); i++) {
            if (id.equals(list.get(i).getId())) {
                return true;
            }
        }
        return false;
    }

    /*
    删除功能
    参数：ArrayList<Student>list
    返回值:void

    如果要删除某个学生，我们一般都是根据一个唯一（不重复）的标识去删除，在学生管理系统中，学号是不重复的，所以我们可以根据学号删除学生。
    我们需要先找到要删除的学生在集合中的索引，然后调用集合的remove方法根据索引删除元素（一般都是根据索引删除）
    步骤：
        1.键盘录入要删除学生的学号。
        2.定义一个变量index,表示要删除的学生在集合中的索引。初始值-1表示要删除的学生不存在
        3.遍历集合，拿到集合中的每一个学生对象。
        4.使用遍历到的学生对象的学号和要删除的学号进行比较。
        5.如果两者学号相同，就表示找到了要删除的学生。将该学生的索引赋值给index。然后使用break结束循环（找到之后就没有必要再遍历查找了
        6.根据index进行判断
        如果index的值是-1,就表示没有找到要删除的学生，就给出提示。
        如果index的值不是-1,就表示找到了要删除的学生，就根据索引删除学生即可。给出提示
     */
    public static void delStudent(ArrayList<Student> list) {
        if (list.size() == 0) {
            System.out.println("集合为空");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入学生学号:");
        String id = scanner.nextLine();
        for (int i = 0; i < list.size(); i++) {
            if (id.equals(list.get(i).getId())) {
                list.remove(i);
                System.out.println("删除成功");
                return;
            }
        }
        System.out.println("学号不存在");

    }
    /*
    修改
    参数：ArrayList<Student>list
    返回值:void
    一般修改某个东西，也是根据唯一的标识去修改。在学生管理系统中，学号是唯一的，所以我们可以根据学号进行修改。
    键盘录入要修改的学生的学号，然后根据学号去修改其他内容。
    如果要修改集合中的数据，可以使用集合的set方法去完成。set方法可以使用指定元素替换掉集合中指定索引位置的东西。
    步骤：
    1.键盘录入要修改的学生学号
    2.定义一个变量index,表示要修改的学生在集合中的索引，初始值-1表示要修改的学生不存在。
    3.遍历集合，拿到集合中的每一个学生对象。
    4.使用遍历到的学生的学号和要修改的学号进行比较。
    5.如果两者相同，就表示找到了要修改的学生。就将该学生的索引赋值给index,然后使用break结束循环。
    6.根据index进行判断
        如果index值是-1,表示要修改的学生不存在，给出提示。
        如果index的值不是-1,就表示要修改的学生是存在的，进行修改。
        a.键盘录入修改后的新的属性【姓名，年龄，居住地】
        b.根据录入的属性创建学生对象
        c.调用集合的set方法，使用新的学生对象替换掉指定索引位置（index)的元素
     */
    public static void updateStudent(ArrayList<Student> list){
        if (list.size() == 0) {
            System.out.println("集合为空");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入学生学号:");
        String id = scanner.nextLine();
        int i;
        for (i = 0; i < list.size(); i++) {
            if (id.equals(list.get(i).getId())) {
                break;
            }
        }
        System.out.println("请输入学生姓名:");
        String name = scanner.nextLine();
        System.out.println("请输入学生年龄:");
        String age = scanner.nextLine();
        System.out.println("请输入学生地址:");
        String addr = scanner.nextLine();
        Student student = new Student(id, name, age, addr);
        list.set(i,student);
        System.out.println("修改成功");
        return;

    }


}
