//package asmdemo.securityExample;
//
//import java.io.File;
//import java.io.FileOutputStream;
//
//import com.sun.xml.internal.ws.org.objectweb.asm.ClassAdapter;
//import com.sun.xml.internal.ws.org.objectweb.asm.ClassReader;
//import com.sun.xml.internal.ws.org.objectweb.asm.ClassWriter;
//
//public class Generator{
//    public static void main(String[] args) throws Exception {
//        ClassReader cr = new ClassReader("asmdemo.securityExample.Account");
//        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
//        ClassAdapter classAdapter = new AddSecurityCheckClassAdapter(cw);
//        cr.accept(classAdapter, ClassReader.SKIP_DEBUG);
//        byte[] data = cw.toByteArray();
//        File file = new File("asmdemo.securityExample.Account.class");
//        FileOutputStream fout = new FileOutputStream(file);
//        fout.write(data);
//        fout.close();
//    }
//}
