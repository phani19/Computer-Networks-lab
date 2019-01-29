import java.net.*;
import java.io.*;
class Server_PARITY1
{
public static void main(String args[])
{
try{
ServerSocket ss=new ServerSocket(5000);
System.out.println("waiting for connection");
Socket soc=ss.accept();
System.out.println("connection established");String str="",str1="";
BufferedReader in1=new BufferedReader(new InputStreamReader(System.in));
BufferedReader in=new BufferedReader(new InputStreamReader(soc.getInputStream()));
PrintWriter out1=new PrintWriter(soc.getOutputStream(),true);
while(!str.equals("Over")){
str=in.readLine();
int i,cnt=0;String str2="";
for(i=0;i<str.length();i++)
{
if(i!=str.length()-1)
{str2=str2+str.charAt(i);}
if(str.charAt(i)=='1'){cnt++;}
}
if(cnt%2==1){str="ERROR !!! -data received is "+str;}
else{str=str2;}
System.out.println("Client:"+str);
System.out.print("Server:");
str1=in1.readLine();
out1.println(str1);
}
}
catch(Exception e){System.out.println(e);}

}
}