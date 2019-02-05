import java.io.*;
import java.net.*;
import java.util.*;
import java.util.Scanner;
import java.util.Random;
import java.lang.Math;

class HCS
{
public static String input;
public static int n,r;
public static int i,j,k;
//------------------------------
public static int redu()
{
Double n1,r1=0.0,i1;
n1=Double.valueOf(n);
for(i=0;i<20;i++)
{
i1=Double.valueOf(i);
if(Math.pow(2,i)>=(n1+i1+1))
{r1=i1;break;}
i=i1.intValue();
}
return r1.intValue();
}
//-----------------------------------
public static int inp[];
public static void toArr()
{
inp=new int[n+r+1];

for(i=1,j=0,k=0;i<=n+r;i++)
{
if(i==Double.valueOf(Math.pow(2,j))){j++;continue;}
inp[i]=Character.getNumericValue(input.charAt(k));
k++;
}
}
//----------------------------------
public static void addParity()
{
for(i=1,j=0;i<=n+r;i++)
{
if(i==Double.valueOf(Math.pow(2,j)))
{
j++;
int p,q,sum=0;

for(p=i;p<=n+r;p=p+i)
{
	for(q=0;q<i;q++)
	{
	sum=sum+inp[p];
	if(p>=n+r){break;}
	p++;
	}
}

inp[i]=sum%2;
}//if
}//for 1
}//func
//-----------------------------------
public static void addErr()
{
Random ra=new Random();
int e=ra.nextInt(n+r);e=e+1;
inp[e]=(inp[e]+1)%2;
}

//--------------------------------------------------------------
public static void main(String args[])throws Exception
{
Socket soc=new Socket("127.0.0.1",4000);
System.out.println("connection established");
PrintWriter out=new PrintWriter(soc.getOutputStream(),true);//dont forget true
System.out.println("enter input:");
Scanner sc=new Scanner(System.in);
input=sc.nextLine();
n=input.length();
out.println(n);
HCS o=new HCS();
r=o.redu();
out.println(r);
//System.out.println(r); r is num of redundant bits
o.toArr();//to make input into inp[]
o.addParity();
System.out.println("after adding redundant bits");
for(i=1;i<=n+r;i++)
System.out.print(inp[i]);
o.addErr();
System.out.println("\nafter adding error");
for(i=1;i<=n+r;i++)
{System.out.print(inp[i]);
out.println(inp[i]);
}




}//end of main
}