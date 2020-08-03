package cn.com.mryhl.demo03_exception;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
继承关系中方法重写的异常处理
    1.如果父类方法没有向外抛出异常，那么子类重写该方法后，也不能向外抛。如果子类方法有异常，只能try...catch。
    2.如果父类方法向外抛异常，那么子类重写该方法，可以抛，也可以不抛。
      如果于类方法向外抛，抛出的异常要么和父类方法异相同，要么是他的子类异常。

 注意:上面的异常处理方式,只针对编译时异常,运行时异常不受限制.

 */
public class Zi extends Fu {
    @Override
    public void function() throws FileNotFoundException {

    }

    @Override
    public void method() {
        //throw new Exception();
        String str = "2020-07-06";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = simpleDateFormat.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
