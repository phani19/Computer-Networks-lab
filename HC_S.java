//client sends data
import java.util.Scanner;
import java.util.Random;
import java.net.*;
import java.io.*;

class HC_S
{
static int n;//for columns
static int i,j;//for loops
static int input[][];
//-------------------------------------
public void readInput()
{
Scanner sc=new Scanner(System.in);
input=new int[n][7];
for(i=0;i<n;i++)
{
	for(j=0;j<7;j++)
	{
	if(j==0||j==1||j==3){continue;}
	input[i][j]=sc.nextInt();
	}
}
}
//--------------------------------------
public void addParity()
{
for(i=0;i<n;i++)
{
input[i][0]=(input[i][2]+input[i][4]+input[i][6])%2;
input[i][1]=(input[i][2]+input[i][5]+input[i][6])%2;
input[i][3]=(input[i][5]+input[i][4]+input[i][6])%2;
}
}
//----------------------------------------
public void addErr()
{
Random r=new Random();
for(i=0;i<n;i++)
{
int e=r.nextInt(7);
input[i][e]=(input[i][e]+1)%2;
}
}
//-------------------------------------------
public static void main(String args[])throws Exception
{
Socket soc =new Socket("127.0.0.1",5111);
System.out.println("connected");

HC_S o=new HC_S();
Scanner sc=new Scanner(System.in);
System.out.println("enter number of lines:");
n=sc.nextInt();
o.readInput();
o.addParity();

System.out.println("after adding redundant bits:");
for(i=0;i<n;i++)
{
for(j=0;j<7;j++)
{
System.out.print(" "+input[i][j]);
}
System.out.println();
}

o.addErr();
System.out.println("after adding error:");
for(i=0;i<n;i++)
{
for(j=0;j<7;j++)
{
System.out.print(" "+input[i][j]);
}
System.out.println();
}

//---------socket
PrintWriter out=new PrintWriter(soc.getOutputStream(),true);
out.println(n);
for(i=0;i<n;i++)
{
for(j=0;j<7;j++)
{
out.println(input[i][j]);
}
}

}//end of main

}