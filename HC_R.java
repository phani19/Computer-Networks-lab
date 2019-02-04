//should be executed first
import java.net.*;
import java.util.*;
import java.io.*;

class HC_R
{
static int i,j;
static int n;
static int input[][];
//----------------------------------
public void correct()
{
int error,a1,a2,a4;
for(i=0;i<n;i++)
{
a1=(input[i][0]+input[i][2]+input[i][4]+input[i][6])%2;
a2=(input[i][1]+input[i][2]+input[i][5]+input[i][6])%2;
a4=(input[i][3]+input[i][5]+input[i][4]+input[i][6])%2;
error=a1*1+a2*2+a4*4;
System.out.println("error at:"+error+" corrected");error=error-1;
input[i][error]=(input[i][error]+1)%2;
}

}
//----------------------------------
public static void main(String args[])throws Exception
{
ServerSocket ss=new ServerSocket(5111);
System.out.println("waiting for connection");
Socket soc=ss.accept();
System.out.println("connection established");
System.out.println();
BufferedReader in=new BufferedReader(new InputStreamReader(soc.getInputStream()));
n=Integer.parseInt(in.readLine());
input=new int[n][7];
for(i=0;i<n;i++)
{
for(j=0;j<7;j++)
input[i][j]=Integer.parseInt(in.readLine());
}
//data received into input[][]
HC_R o=new HC_R();
o.correct();
System.out.println();
System.out.println("final data after removing error");
for(i=0;i<n;i++)
{
for(j=0;j<7;j++)
{
if(j==0||j==1||j==3){continue;}
System.out.print(" "+input[i][j]);
}
System.out.println();
}

}
}