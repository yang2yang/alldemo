package equalsdemo;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by ding on 2017/4/26.
 */
public class MybatisIf {
    public static void main(String[] args) {
        Object v1 = 2;
        Object v2 = "2";
        System.out.println(equal(v1,v2));

    }

    public static boolean equal(Object v1, Object v2) {
        return v1 == null?v2 == null:(v1 != v2 && !isEqual(v1, v2)?(v1 instanceof Number && v2 instanceof Number?((Number)v1).doubleValue() == ((Number)v2).doubleValue():false):true);
    }


    public static boolean isEqual(Object object1, Object object2) {
        boolean result = false;
        if(object1 == object2) {
            result = true;
        } else if(object1 != null && object2 != null) {
            if(object1.getClass().isArray() && object2.getClass().isArray() && object2.getClass() == object1.getClass()) {
                result = Array.getLength(object1) == Array.getLength(object2);
                if(result) {
                    int i = 0;

                    for(int icount = Array.getLength(object1); result && i < icount; ++i) {
                        result = isEqual(Array.get(object1, i), Array.get(object2, i));
                    }
                }
            } else if(object1 != null && object2 != null) {
                result = compareWithConversion(object1, object2, true) == 0 || object1.equals(object2);
            }
        }

        return result;
    }



    public static int compareWithConversion(Object v1, Object v2, boolean equals) {
        int result;
        if(v1 == v2) {
            result = 0;
        } else {
            int t1 = getNumericType(v1);
            int t2 = getNumericType(v2);
            int type = getNumericType(t1, t2, true);
            switch(type) {
                case 6:
                    result = bigIntValue(v1).compareTo(bigIntValue(v2));
                    break;
                case 9:
                    result = bigDecValue(v1).compareTo(bigDecValue(v2));
                    break;
                case 10:
                    if(t1 == 10 && t2 == 10) {
                        if(v1 != null && v2 != null) {
                            if(v1.getClass().isAssignableFrom(v2.getClass()) || v2.getClass().isAssignableFrom(v1.getClass())) {
                                if(v1 instanceof Comparable) {
                                    result = ((Comparable)v1).compareTo(v2);
                                    break;
                                }

                                if(equals) {
                                    result = v1.equals(v2)?0:1;
                                    break;
                                }
                            }

                            if(!equals) {
                                throw new IllegalArgumentException("invalid comparison: " + v1.getClass().getName() + " and " + v2.getClass().getName());
                            }

                            result = 1;
                            break;
                        } else {
                            boolean var10000 = v1 != v2;
                        }
                    }
                case 7:
                case 8:
                    double dv1 = doubleValue(v1);
                    double dv2 = doubleValue(v2);
                    return dv1 == dv2?0:(dv1 < dv2?-1:1);
                default:
                    long lv1 = longValue(v1);
                    long lv2 = longValue(v2);
                    return lv1 == lv2?0:(lv1 < lv2?-1:1);
            }
        }

        return result;
    }

    public static long longValue(Object value) throws NumberFormatException {
        if(value == null) {
            return 0L;
        } else {
            Class c = value.getClass();
            return c.getSuperclass() == Number.class?((Number)value).longValue():(c == Boolean.class?(long)(((Boolean)value).booleanValue()?1:0):(c == Character.class?(long)((Character)value).charValue():Long.parseLong(stringValue(value, true))));
        }
    }



    public static double doubleValue(Object value) throws NumberFormatException {
        if(value == null) {
            return 0.0D;
        } else {
            Class c = value.getClass();
            if(c.getSuperclass() == Number.class) {
                return ((Number)value).doubleValue();
            } else if(c == Boolean.class) {
                return (double)(((Boolean)value).booleanValue()?1:0);
            } else if(c == Character.class) {
                return (double)((Character)value).charValue();
            } else {
                String s = stringValue(value, true);
                return s.length() == 0?0.0D:Double.parseDouble(s);
            }
        }
    }

    public static String stringValue(Object value, boolean trim) {
        String result;
        if(value == null) {
            result = "" + null;
        } else {
            result = value.toString();
            if(trim) {
                result = result.trim();
            }
        }

        return result;
    }


    public static int getNumericType(Object value) {
//        int result = true;
        if(value != null) {
            Class c = value.getClass();
            if(c == Integer.class) {
                return 4;
            }

            if(c == Double.class) {
                return 8;
            }

            if(c == Boolean.class) {
                return 0;
            }

            if(c == Byte.class) {
                return 1;
            }

            if(c == Character.class) {
                return 2;
            }

            if(c == Short.class) {
                return 3;
            }

            if(c == Long.class) {
                return 5;
            }

            if(c == Float.class) {
                return 7;
            }

            if(c == BigInteger.class) {
                return 6;
            }

            if(c == BigDecimal.class) {
                return 9;
            }
        }

        return 10;
    }

    public static BigInteger bigIntValue(Object value) throws NumberFormatException {
        if(value == null) {
            return BigInteger.valueOf(0L);
        } else {
            Class c = value.getClass();
            return c == BigInteger.class?(BigInteger)value:(c == BigDecimal.class?((BigDecimal)value).toBigInteger():(c.getSuperclass() == Number.class?BigInteger.valueOf(((Number)value).longValue()):(c == Boolean.class?BigInteger.valueOf((long)(((Boolean)value).booleanValue()?1:0)):(c == Character.class?BigInteger.valueOf((long)((Character)value).charValue()):new BigInteger(stringValue(value, true))))));
        }
    }

    public static int getNumericType(int t1, int t2, boolean canBeNonNumeric) {
        if(t1 == t2) {
            return t1;
        } else if(canBeNonNumeric && (t1 == 10 || t2 == 10 || t1 == 2 || t2 == 2)) {
            return 10;
        } else {
            if(t1 == 10) {
                t1 = 8;
            }

            if(t2 == 10) {
                t2 = 8;
            }

            return t1 >= 7?(t2 >= 7?Math.max(t1, t2):(t2 < 4?t1:(t2 == 6?9:Math.max(8, t1)))):(t2 >= 7?(t1 < 4?t2:(t1 == 6?9:Math.max(8, t2))):Math.max(t1, t2));
        }
    }


    public static BigDecimal bigDecValue(Object value) throws NumberFormatException {
        if(value == null) {
            return BigDecimal.valueOf(0L);
        } else {
            Class c = value.getClass();
            return c == BigDecimal.class?(BigDecimal)value:(c == BigInteger.class?new BigDecimal((BigInteger)value):(c.getSuperclass() == Number.class?new BigDecimal(((Number)value).doubleValue()):(c == Boolean.class?BigDecimal.valueOf((long)(((Boolean)value).booleanValue()?1:0)):(c == Character.class?BigDecimal.valueOf((long)((Character)value).charValue()):new BigDecimal(stringValue(value, true))))));
        }
    }
}
