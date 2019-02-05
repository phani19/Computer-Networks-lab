import java.io.*;
import java.net.*;
import java.util.*;
import java.util.Scanner;
import java.util.Random;
import java.lang.Math;

class HCR
{

 static int n,r;
 static int i,j,k;
 static int inp[];

//------------------------------------------------------------
public static void dectCorr()
{
int er[]=new int[r+1];
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

er[j]=sum%2;
}//if
}//for 1
Double e=0.0;
for(i=1;i<=r;i++)
{
e=e+(Math.pow(2,i-1)*er[i]);
}
int ee=e.intValue();
inp[ee]=(inp[ee]+1)%2;
System.out.println("\nerror at"+ee+" detected and corrected");
}

//--------------------------------------------------------------
public static void main(String args[]) throws Exception
{
ServerSocket ss=new ServerSocket(4000);
System.out.println("waiting....!");
Socket soc=ss.accept();
System.out.println("connected");
BufferedReader br=new BufferedReader(new InputStreamReader(soc.getInputStream()));
n=Integer.parseInt(br.readLine());
r=Integer.parseInt(br.readLine());
inp=new int[n+r+1];
HCR o=new HCR();

for(i=1;i<=n+r;i++)
{
inp[i]=Integer.parseInt(br.readLine());
}

o.dectCorr();
System.out.println("\nafter correction");
for(i=1,j=0;i<=n+r;i++)
{
if(i==Double.valueOf(Math.pow(2,j))){j++;continue;}
System.out.print(inp[i]);
}


}//end of main
}