package cn.com.mryhl;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class AppTest {
    public static void main(String[] args) {
        while (true) {
            System.out.println("欢迎访问管理系统");
            System.out.println("1.学生管理;2.教师管理;3.退出系统");
            Scanner scanner = new Scanner(System.in);
            int c = scanner.nextInt();
            switch (c) {
                case 1:
                    System.out.println("学生管理系统");
                    studentMess();
                    break;
                case 2:
                    System.out.println("教师管理系统");
                    teacherMess();
                    break;
                case 3:
                    System.out.println("退出系统");
                    System.exit(0);
                default:
                    System.out.println("输入错误");
            }
        }
        /*while (true) {
            printMembers();
            int i = scanner.nextInt();
            chooseMem(i);
        }*/
    }

    /*
     * 学生管理系统
     * */
    public static void studentMess() {
        ArrayList<Student> stulist = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printMembers();
            int n = scanner.nextInt();
            System.out.print("系统加载中");
            for (int i = 0; i < 6; i++) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print(".");
            }
            System.out.println();
            switch (n) {
                case 1:
                    System.out.println("添加学生");
                    addStu(stulist);
                    break;
                case 2:
                    System.out.println("修改学生");
                    updateList(stulist);
                    break;
                case 3:
                    System.out.println("删除学生");
                    delList(stulist);
                    break;
                case 4:
                    System.out.println("查看学生");
                    printStuList(stulist);
                    break;
                case 5:
                    System.out.print("正在退出系统");
                    for (int i = 0; i < 6; i++) {
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.print(".");
                    }
                    System.out.println("");
                    System.out.println("再见");
                    return;
                default:
                    System.out.println("选择出错");
            }
        }
    }
    public static void teacherMess() {
        ArrayList<Teacher> tealist = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printMembers1();
            int n = scanner.nextInt();
            System.out.print("系统加载中");
            for (int i = 0; i < 6; i++) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print(".");
            }
            System.out.println();
            switch (n) {
                case 1:
                    System.out.println("添加教师");
                    addTea(tealist);
                    break;
                case 2:
                    System.out.println("修改教师");
                    updateList1(tealist);
                    break;
                case 3:
                    System.out.println("删除教师");
                    delList1(tealist);
                    break;
                case 4:
                    System.out.println("查看教师");
                    printStuList1(tealist);
                    break;
                case 5:
                    System.out.print("正在退出系统");
                    for (int i = 0; i < 6; i++) {
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.print(".");
                    }
                    System.out.println("");
                    System.out.println("再见");
                    return;
                default:
                    System.out.println("选择出错");
            }
        }
    }

    /*
     * 打印菜单
     * 参数:无
     * 返回值:void
     * */
    public static void printMembers() {
        System.out.println("*************    欢迎使用学生管理系统V1.0.1   *************");
        System.out.println("*************        请选择需要的功能        *************");
        System.out.println("**1.添加学生  2.修改学生  3.删除学生  4.查看学生  5.退出系统**");
        System.out.println("*******************************************************");
    }
    public static void printMembers1() {
        System.out.println("*************    欢迎使用教师管理系统V1.0.1   *************");
        System.out.println("*************        请选择需要的功能        *************");
        System.out.println("**1.添加教师  2.修改教师  3.删除教师  4.查看教师  5.退出系统**");
        System.out.println("*******************************************************");
    }



    /*
     * 1.添加功能
     * 参数:ArrayList<Student> stulist
     * 返回值:void
     * */
    public static void addStu(ArrayList<Student> stulist) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入学生姓名");
        String name = scanner.nextLine();
        System.out.println("请输入学生性别");
        String ssex = scanner.nextLine();
        System.out.println("输入入出生年月日,'yyyy-MM-dd'格式");
        String birthday = scanner.nextLine();
        stulist.add(new Student(name, ssex, birthday));
        System.out.println("添加成功");
    }
    public static void addTea(ArrayList<Teacher> tealist) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入教师姓名");
        String name = scanner.nextLine();
        System.out.println("请输入教师性别");
        String ssex = scanner.nextLine();
        System.out.println("输入入出生年月日,'yyyy-MM-dd'格式");
        String birthday = scanner.nextLine();
        tealist.add(new Teacher(name, ssex, birthday));
        System.out.println("添加成功");
    }
    /*
     * 按学号查找
     * 参数:ArrayList<Student> stulist,int id
     * 返回值:int 下标
     * */
    public static int findId(ArrayList<Student> stulist, int id) {
        if (stulist.size() == 0)
            return -1;
        for (int i = 0; i < stulist.size(); i++) {
            if (stulist.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
    public static int findId1(ArrayList<Teacher> tealist, int id) {
        if (tealist.size() == 0)
            return -1;
        for (int i = 0; i < tealist.size(); i++) {
            if (tealist.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
    /*
     * 2.修改内容
     * 参数:ArrayList<Student> stulist
     * 返回值:void
     * */
    public static void updateList(ArrayList<Student> stulist) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要修改的学号");
        int id = Integer.parseInt(scanner.nextLine());
        int id1 = findId(stulist, id);
        if (id1 == -1)
            System.out.println("该学号不存在");
        else {
            System.out.println("请输入要修改的姓名,0表示不变");
            String name = scanner.nextLine();
            System.out.println("请输入要修改的性别,0表示不变");
            String ssex = scanner.nextLine();
            System.out.println("请输入要修改的出生年月,0表示不变");
            String birthday = scanner.nextLine();
            if (!name.equals("0"))
                stulist.get(id1).setName(name);
            if (!ssex.equals("0"))
                stulist.get(id1).setSsex(ssex);
            if (!birthday.equals("0"))
                stulist.get(id1).setBirthday(birthday);
            System.out.println("修改完成");
            printStuList(stulist);
        }
    }
    public static void updateList1(ArrayList<Teacher> tealist) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要修改的工号");
        int id = Integer.parseInt(scanner.nextLine());
        int id1 = findId1(tealist, id);
        if (id1 == -1)
            System.out.println("该工号不存在");
        else {
            System.out.println("请输入要修改的姓名,0表示不变");
            String name = scanner.nextLine();
            System.out.println("请输入要修改的性别,0表示不变");
            String ssex = scanner.nextLine();
            System.out.println("请输入要修改的出生年月,0表示不变");
            String birthday = scanner.nextLine();
            if (!name.equals("0"))
                tealist.get(id1).setName(name);
            if (!ssex.equals("0"))
                tealist.get(id1).setSsex(ssex);
            if (!birthday.equals("0"))
                tealist.get(id1).setBirthday(birthday);
            System.out.println("修改完成");
            printStuList1(tealist);
        }
    }
    /*
     * 3.删除功能
     * 参数:ArrayList<Student> stulist
     * 返回值:void
     * */
    public static void delList(ArrayList<Student> stulist) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要删除的学号");
        int id = Integer.parseInt(scanner.nextLine());
        int id1 = findId(stulist, id);
        if (id1 == -1)
            System.out.println("该学号不存在");
        else {
            System.out.println(stulist.get(id1).toString());
            System.out.println("确认删除,键入y");
            String s = scanner.nextLine();
            if (s.equalsIgnoreCase("y")) {
                stulist.remove(id1);
                System.out.println("删除成功");
                printStuList(stulist);
            } else {
                System.out.println("取消了删除操作");
                return;
            }
        }
    }
    public static void delList1(ArrayList<Teacher> tealist) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要删除的工号");
        int id = Integer.parseInt(scanner.nextLine());
        int id1 = findId1(tealist, id);
        if (id1 == -1)
            System.out.println("该工号不存在");
        else {
            System.out.println(tealist.get(id1).toString());
            System.out.println("确认删除,键入y");
            String s = scanner.nextLine();
            if (s.equalsIgnoreCase("y")) {
                tealist.remove(id1);
                System.out.println("删除成功");
                printStuList1(tealist);
            } else {
                System.out.println("取消了删除操作");
                return;
            }
        }
    }
    /*
     * 4.查看学生
     * 参数:ArrayList<Student> stulist
     * 返回值:void
     * */
    public static void printStuList(ArrayList<Student> stulist) {
        if (stulist.size() == 0) {
            System.out.println("还没有学生.请先添加学生,是否进入添加功能?输入y进入,其他返回");
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            if (s.equalsIgnoreCase("y"))
                addStu(stulist);
            else
                return;
        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("编号\t\t\t姓名\t\t\t性别\t\t\t年龄\t\t\t出生年月\t\t\t工作");
        for (int i = 0; i < stulist.size(); i++) {
            System.out.println(stulist.get(i).toString());
            System.out.println("-------------------------------------------------------------------");

        }
    }
    public static void printStuList1(ArrayList<Teacher> tealist) {
        if (tealist.size() == 0) {
            System.out.println("还没有教师.请先添加教师,是否进入添加功能?输入y进入,其他返回");
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            if (s.equalsIgnoreCase("y"))
                addTea(tealist);
            else
                return;
        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("编号\t\t\t姓名\t\t\t性别\t\t\t年龄\t\t\t出生年月\t\t\t工作");
        for (int i = 0; i < tealist.size(); i++) {
            System.out.println(tealist.get(i).toString());
            System.out.println("-------------------------------------------------------------------");

        }
    }

}
