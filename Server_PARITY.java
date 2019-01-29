import java.net.*;
import java.io.*;
class Server_PARITY
{
public static void main(String args[])
{
try{
ServerSocket ss=new ServerSocket(5000);
System.out.println("waiting for connection");
Socket soc=ss.accept();
System.out.println("connection established");String str="",str1="";
BufferedReader in=new BufferedReader(new InputStreamReader(soc.getInputStream()));

int n= Integer.parseInt(in.readLine());
int i,j;
int inp[][]=new int[n+1][9];

for(i=0;i<=n;i++)
{
	for(j=0;j<=8;j++)
	{
	inp[i][j]=Integer.parseInt(in.readLine());

	}
}



int cnt,err=0;
for(i=0;i<=n;i++)
{
cnt=0;
for(j=0;j<=8;j++)
{
if(inp[i][j]==1){cnt++;}
}
if(cnt%2==1){err=1;break;}
}

for(i=0;i<=8;i++)
{cnt=0;
for(j=0;j<=n;j++)
{
if(inp[j][i]==1){cnt++;}
}
if(cnt%2==1){err=1;break;}
}

if(err==1){System.out.println("ERROR !!! \n received data is");

for(i=0;i<=n;i++)
{
for(j=0;j<=8;j++)
{
System.out.print(inp[i][j]);
}
System.out.println();
}
}
if(err==0){
for(i=0;i<n;i++)
{
for(j=0;j<8;j++)
{
System.out.print(inp[i][j]);
}
System.out.println();
}
}

}
catch(Exception e){System.out.println(e);}

}
}