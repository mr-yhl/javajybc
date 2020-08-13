package cn.com.mryhl.demo03_enum;

/*
    枚举本质就是类，枚举是多例的一种体现。
    在枚举中我们可以给出一些属性，枚举中的每个属性都是自身的对象。
    格式
        public enum 枚举名 {
            属性,属性,属性
        }

    枚举中的属性在命名时建议全部大写，多个单词之间使用下划线隔开。
    枚举中的属性默认使用了static final进行修饰，因为使用static修饰了，所以我们可以通过枚举名直接使用里面的属性。
 */
public enum Gender {
    //男
    BOY,
    //女
    GIRL
}