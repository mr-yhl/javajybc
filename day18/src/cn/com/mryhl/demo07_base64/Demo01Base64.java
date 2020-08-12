package cn.com.mryhl.demo07_base64;
/*
Base64可以进行编码和解码

Base64.Encoder：用来编码
Base64.Decoder：用来解码

static Base64.Encoder getEncoder()：获取一个标准的Base64的编码器
static Base64.Decoder getDecoder()：获取一个标准的Base64的解码器
static Base64.Decoder getUrlEncoder()：获取一个标准的url的Base64的编码器
static Base64.Decoder getUrlDecoder()：获取一个标准的url的Base64的解码器
static Base64.Decoder getMimeEncoder()：获取一个标准的MIME的Base64的编码器
static Base64.Decoder getMimeDecoder()：获取一个标准的MIME的Base64的解码器

Base64.Encoder的方法:
    String encodeToString(byte[] src):将byte数组编码成字符串
Base64.Decoder的方法:
    String decode(String src):解码,将字符串变成byte数组


 */



import java.util.Base64;

public class Demo01Base64 {
    public static void main(String[] args) {
        // 定义字符串
        String str = "嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈嘿嘿哈哈";
        // 使用标准Base64进行编码
        String base64Code = Base64.getEncoder().encodeToString(str.getBytes());
        System.out.println(base64Code);
        // 使用标准Base64进行解密
        byte[] decode = Base64.getDecoder().decode(base64Code);
        System.out.println(new String(decode));
        // 使用url进行编码解码
        String urlCode = Base64.getUrlEncoder().encodeToString(str.getBytes());
        System.out.println(urlCode);
        byte[] decode1 = Base64.getUrlDecoder().decode(urlCode);
        System.out.println(new String(decode));
        // 使用MIME编码解码
        String mimeCode = Base64.getMimeEncoder().encodeToString(str.getBytes());
        System.out.println(mimeCode);
        byte[] decode2 = Base64.getMimeDecoder().decode(mimeCode);
        System.out.println(new String(decode2));

    }
}
