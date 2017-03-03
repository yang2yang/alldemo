package nullpointerdemo;
/**
**  author:jack 2017年03月2017/3/2日
*/
public class NULL {
    public static void print(){
        System.out.println("MTDP");
    }
    public static void main(String[] args) {
        try{
            ((NULL)null).print();
        }catch(NullPointerException e){
            System.out.println("NullPointerException");
        }
    }
}
