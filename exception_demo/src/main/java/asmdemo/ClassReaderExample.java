package asmdemo;

import com.sun.xml.internal.ws.org.objectweb.asm.*;

import java.io.IOException;

/**
 * Created by ding on 2017/4/17.
 */
public class ClassReaderExample {

    private static class MyClassVisitor implements ClassVisitor {

        @Override
        public void visit(int version, int access, String name,
                          String signature, String superName, String[] interfaces) {
            System.out.println("class name:" + name);
            System.out.println("super class name:" + superName);
            System.out.println("class version:" + version);
            System.out.println("class access:" + access);
            System.out.println("class signature:" + signature);
            if (interfaces != null && interfaces.length > 0) {
                for (String str : interfaces) {
                    System.out.println("implemented interface name:" + str);
                }
            }

        }

        @Override
        public void visitSource(String source, String debug) {
        }

        @Override
        public void visitOuterClass(String owner, String name, String desc) {
        }

        @Override
        public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
            return null;
        }


        @Override
        public void visitAttribute(Attribute attr) {

        }

        @Override
        public void visitInnerClass(String name, String outerName,
                                    String innerName, int access) {
        }

        @Override
        public FieldVisitor visitField(int access, String name, String desc,
                                       String signature, Object value) {
            return null;
        }

        @Override
        public MethodVisitor visitMethod(int access, String name, String desc,
                                         String signature, String[] exceptions) {
            return null;
        }

        @Override
        public void visitEnd() {

        }
    }

    public static void main(String args[]) throws IOException {
        ClassReader classReader = new ClassReader("java.lang.String");
        classReader.accept(new MyClassVisitor(), 0);
    }
}