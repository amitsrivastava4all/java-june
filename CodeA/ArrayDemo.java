class ArrayDemo{
public static void main(String args[]){
//int x[] = {10,20,30,40,50};
//int [] x = {10,20,30,40,50};
//int []x = new int[5];
int x[]  = new int[]{10,20,30,40,50};
/*for(int y : x){
System.out.println(y);
}*/
// Labeled Loop
for(int i = 1; i<=3; i++){
for(int j = 1; j<=3; j++){
if(i==j){
break;
}
else{
System.out.println("I is "+i+" and J is "+j);
}

}
}
System.out.println("*********************************");


int z[][]  = new int[3][];
z[0] = new int[10];
z[1] = new int[20];
z[2] = new int[30];
for(int y[] : z){
for(int m : y){
System.out.print(m);
}
System.out.println();
}
//z[0][0]  = new int[20];
/*for(int i = 0 ; i<z.length; i++){
for(int j = 0; j<z[i].length; j++){
System.out.print(z[i][j]);
}
System.out.println();
}*/
//int z [] [] = new int[3][3];
//int [][]z = new int[3][3];
//int []z[] = new int[3][3];
//int [][]z = {{10,20,30},{40,50,60}};
}
}