class CommandLineDemo{
public static void main(String arr[]){
int sum = 0;
for(String i:arr){
sum+=Integer.parseInt(i);
}
/*for(int i = 0; i<arr.length; i++){
sum+=Integer.parseInt(arr[i]);
}*/
System.out.println("Sum is "+sum);
/*if(arr.length==2){
int firstValue  = Integer.parseInt(arr[0]);  // 100 ref value string convert int
int secondValue  = Integer.parseInt(arr[1]); // 200 ref
int result = firstValue + secondValue;
System.out.println("Sum is "+result);
}
else{
System.out.println("Invalid Input ");
}
*/
}
}