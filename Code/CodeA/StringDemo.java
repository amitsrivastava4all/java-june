class StringDemo{
public static void main(String args[]){
String x = "Hello".intern();  // String Literal 0 or 1
String y = "Hello".intern();
String z = new String("Hello").intern(); // new String  2 or 1
System.out.println(x==z?"Same Reference ":"Not Same Reference ");
x = "Ok";
System.out.println(x==z?"Same Reference ":"Not Same Reference ");
}
}