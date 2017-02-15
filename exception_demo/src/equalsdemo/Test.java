package equalsdemo; /**
 * ChangCai.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author dingqingli
 * @version equalsdemo.Test.java, v 0.1 2017/2/14 17:41 dingqingli Exp $
 */
public class Test {
    public static void main(String[] args) {
        CaseInsensitiveString cis = new CaseInsensitiveString("Value");
        String s = "Value";
        List list = new ArrayList();
        list.add(cis);
        System.out.println(cis.equals(s));
        System.out.println(s.equals(cis));
        System.out.println(list.contains(s));
    }
}
