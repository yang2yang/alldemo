/**
 * ChangCai.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package equalsdemo;

/**
 * @author dingqingli
 * @version CaseInsensitiveString.java, v 0.1 2017/2/14 17:44 dingqingli Exp $
 */
public class CaseInsensitiveString {
    private String s;

    public CaseInsensitiveString(String value) {
        s = value;
    }

    public boolean equals(Object obj){
        if(obj instanceof CaseInsensitiveString)
            return s.equalsIgnoreCase(((CaseInsensitiveString)obj).s);
        if(obj instanceof String)
            return s.equalsIgnoreCase((String)obj);
        return false;
    }
}
