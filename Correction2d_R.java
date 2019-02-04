import java.io.*;
import java.net.*;

class Correction2d_R
{
public static void main(String args[])throws Exception
{
ServerSocket ss= new ServerSocket(5555);
System.out.println("waiting for connection");
Socket soc=ss.accept();
System .out.println("connection established");
BufferedReader br =new BufferedReader(new InputStreamReader(soc.getInputStream()));
int n= Integer.parseInt(br.readLine());
int i,j,inp[][]=new int[n+1][9];

for(i=0;i<=n;i++)
{
for(j=0;j<=8;j++)
{
inp[i][j]=Integer.parseInt(br.readLine());
}
}
int sum,x=0,y=0;
for(i=0;i<n+1;i++)
{sum=0;
for(j=0;j<9;j++)
{sum+=inp[i][j];}
if(sum%2==1){x=i;break;}
}

for(i=0;i<9;i++)
{sum=0;
for(j=0;j<n+1;j++)
{sum+=inp[j][i];}
if(sum%2==1){y=i;break;}
}

inp[x][y]=(inp[x][y]+1)%2;
//-----------------------------
for(i=0;i<n;i++)
{
for(j=0;j<8;j++)
System.out.print(inp[i][j]);
System.out.println();
}//------------------------
System.out.println("error detected and corrected at row "+(x+1)+" column "+(y+1));
}//end of main
}