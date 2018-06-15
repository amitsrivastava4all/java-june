import java.lang.*;
class StringBufferDemo{
public static void main(String args[]){
StringBuilder sb = new StringBuilder("Hello");
//StringBuffer sb = new StringBuffer("Hello");  // 5 + 16 = 21 Capacity
System.out.println(sb.capacity());
System.out.println(sb.length());
sb.append("aaaaqqqqeeffhjfdsnkljgdfjglfdkjglkdjgjlglkdfgjdfjlgjgdlhfksdkh");
System.out.println(sb.capacity());
System.out.println(sb.length());
sb.append("TTTTT");
System.out.println(sb.capacity());
System.out.println(sb.length());


}
}