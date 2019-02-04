import java.io.*;
import java.net.*;
import java.util.Random;

class Correction2d_S
{

public static void main(String args[])throws Exception
{
Socket soc=new Socket("127.0.0.1",5555);
System.out.println("connected");
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
PrintWriter out=new PrintWriter(soc.getOutputStream(),true);
System.out.println("\n enter no.of lines");
int n=Integer.parseInt(br.readLine());
out.println(n);
int i,j,inp[][]=new int[n+1][9];String str="";
System.out.println("enter data with 8 bits in each line");
for(i=0;i<n;i++)
{
str=br.readLine();
for(j=0;j<8;j++)
{
inp[i][j]=Character.getNumericValue(str.charAt(j));
}
}
int sum;
for(i=0;i<n;i++)
{sum=0;
for(j=0;j<8;j++)
{
sum+=inp[i][j];
}
inp[i][j]=sum%2;
}

for(i=0;i<8;i++)
{sum=0;
for(j=0;j<n;j++)
{
sum+=inp[j][i];
}
inp[j][i]=sum%2;
}
sum=0;
for(i=0;i<8;i++)
sum+=inp[n][i];
inp[n][i]=sum%2;
System.out.println("after adding parity");
for(i=0;i<=n;i++)
{
for(j=0;j<=8;j++)
System.out.print(" "+inp[i][j]);
System.out.println();
}

Random r=new Random();
int x=r.nextInt(n);int y=r.nextInt(8);
inp[x][y]=(inp[x][y]+1)%2;

System.out.println("after adding error");
for(i=0;i<=n;i++)
{
for(j=0;j<=8;j++)
{System.out.print(" "+inp[i][j]);out.println(inp[i][j]);}
System.out.println();
}

}//end of main
}