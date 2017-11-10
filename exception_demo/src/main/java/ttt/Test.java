package ttt;

import java.io.UnsupportedEncodingException;

/**
 * Created by jack on 2017/11/6.
 */
public class Test {
    public static void main(String[] args) throws UnsupportedEncodingException {
//        String encodedWithUTF8 = "汇金测试";
//        String decodedToISO88591 = new String(encodedWithUTF8.getBytes("ISO-8859-1"), "UTF-8");
//        System.out.println(decodedToISO88591);

//        String encodedWithISO88591 = "汇金测试";
//        String decodedToUTF8 = new String(encodedWithISO88591.getBytes("ISO-8859-1"), "UTF-8");
//        System.out.println(decodedToUTF8);

//        String encodedWithISO88591 = "汇金测试";
//        String decodedToUTF8 = new String(encodedWithISO88591.getBytes("ISO-8859-1"), "UTF-8");
//        System.out.println(decodedToUTF8);
//      æ±éæµè¯
//      Ã¦Â±ÂÃ©ÂÂÃ¦ÂµÂÃ¨Â¯
        String input = "汇金测试";
        String output;
        output = new String(input.getBytes("UTF-8"), "ISO-8859-1");
        System.out.println(output);
        output = new String(output.getBytes("ISO-8859-1"), "UTF-8");
        System.out.println(output);
    }

}
