//package asmdemo.securityExample;
//
//import com.sun.xml.internal.ws.org.objectweb.asm.MethodAdapter;
//import com.sun.xml.internal.ws.org.objectweb.asm.MethodVisitor;
//import com.sun.xml.internal.ws.org.objectweb.asm.Opcodes;
//
///**
// * Created by ding on 2017/4/18.
// */
//class AddSecurityCheckMethodAdapter extends MethodAdapter {
//    public AddSecurityCheckMethodAdapter(MethodVisitor mv) {
//        super(mv);
//    }
//
//    public void visitCode() {
//        visitMethodInsn(Opcodes.INVOKESTATIC, "SecurityChecker",
//                "checkSecurity", "()V");
//    }
//}