import java.net.*;
import java.util.*;
import java.io.*;
import java.util.Random; 
class Client_PARITY1
{
public static void main(String args[])
{
try{
Socket soc=new Socket("127.0.0.1",5000);
System.out.println("connected");String input="",Str="";
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
BufferedReader in=new BufferedReader(new InputStreamReader(soc.getInputStream()));
PrintWriter out=new PrintWriter(soc.getOutputStream(),true);
while(!input.equals("Over")){
System.out.print("Client:");
input=br.readLine();
//even parity
int i,cnt=0;
for(i=0;i<input.length();i++)
{
if((input.charAt(i))=='1'){cnt++;}
}
if(cnt%2==1)
{input=input+'1';}
if(cnt%2==0)
{input=input+'0';}
//adding error
Random rand=new Random();
int index=rand.nextInt(input.length());

StringBuilder input1 = new StringBuilder(input);
input1.setCharAt(index, '1');
input=input1.toString();
//
out.println(input);
Str=in.readLine();
System.out.println("Server:"+Str);
}
}
catch(Exception e)
{System.out.println(e);}
}}