import java.net.*;
import java.util.*;
import java.io.*;
import java.util.Random; 
class Client_PARITY
{
public static void main(String args[])
{
try{
Socket soc=new Socket("127.0.0.1",5000);
System.out.println("connected");String input="",Str="";
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
BufferedReader in=new BufferedReader(new InputStreamReader(soc.getInputStream()));
PrintWriter out=new PrintWriter(soc.getOutputStream(),true);

System.out.println("enter no. of lines\n each line should contain 8 bits \n in case less bits than 8 add 0's in left");
int n=Integer.parseInt(br.readLine());
out.println(n);
int inp[][]=new int[n+1][9];
int i1,j1;
for(i1=0;i1<n;i1++)
{
input=br.readLine();
for(j1=0;j1<8;j1++)
{
inp[i1][j1]=Character.getNumericValue(input.charAt(j1));
}
}


//even parity
int i,j,cnt;
for(j=0;j<n;j++)
{
	cnt=0;
	for(i=0;i<8;i++)
	{
	if((inp[j][i]==1)){cnt++;}
	}
	inp[j][8]=cnt%2;
}

for(j=0;j<8;j++)
{
	cnt=0;
	for(i=0;i<n;i++)
	{
	if((inp[i][j]==1)){cnt++;}
	}
	inp[i][j]=cnt%2;
}
cnt=0;
for(i=0;i<8;i++)
{
if(inp[n][i]==1){cnt++;}
}
inp[n][8]=cnt%2;

//adding error
System.out.println("-----------------------------\n data with 2d parity added");
for(i=0;i<=n;i++)
{
for(j=0;j<=8;j++)
{
System.out.print(inp[i][j]);
}
System.out.println();
}

Random rand=new Random();
int index=rand.nextInt(input.length());
for(i=0;i<2;i++)
{inp[rand.nextInt(n+1)][rand.nextInt(9)]=1;}

System.out.println("-----------------------------\n data with error added");
for(i=0;i<=n;i++)
{
for(j=0;j<=8;j++)
{
System.out.print(inp[i][j]);
}
System.out.println();
}



//
for(i=0;i<=n;i++)
{
	for(j=0;j<=8;j++)
	{
	out.println(inp[i][j]);
	}
}

}
catch(Exception e)
{System.out.println(e);}
}}