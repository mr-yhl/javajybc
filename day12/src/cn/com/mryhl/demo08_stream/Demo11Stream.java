package cn.com.mryhl.demo08_stream;
/*
Stream中的注意事项：
        1.Stream流的非终结方法返回值类型都是本身stream类型，但是返回的并不是本身的对象
        2.Stream流只能一次性使用,不能多次使用
 */


import java.util.stream.Stream;

public class Demo11Stream {
    public static void main(String[] args) {
        // 获取流
        Stream<String> stream = Stream.of("aa", "bb", "cc", "dd");
        // 调用非总结方法
        Stream<String> limit = stream.limit(2);

        //stream.skip(1);
        /*Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed
	at java.util.stream.AbstractPipeline.<init>(AbstractPipeline.java:203)
	at java.util.stream.ReferencePipeline.<init>(ReferencePipeline.java:94)
	at java.util.stream.ReferencePipeline$StatefulOp.<init>(ReferencePipeline.java:647)
	at java.util.stream.SliceOps$1.<init>(SliceOps.java:120)
	at java.util.stream.SliceOps.makeRef(SliceOps.java:120)
	at java.util.stream.ReferencePipeline.skip(ReferencePipeline.java:411)
	at cn.com.mryhl.demo08_stream.Demo11Stream.main(Demo11Stream.java:18)

Process finished with exit code 1
*/
        System.out.println(stream == limit);//false
    }
}
