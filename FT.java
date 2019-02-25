import java.io.*;
import java.util.*;
import java.util.BitSet;
import java.lang.Math;
import java.lang.*;
class FT
{

static int ip[];
static Double d1=0.0;
//----------------------------------------------------------
public static void subnet(char cls,int e)
{
System.out.println("\n\n");
if(cls=='A'&& e-8>=0)
{
System.out.println( "total subnets are "+ Math.pow(2,(e-8)));
subnetmask(cls,e);
}
else if(cls=='B'&& e-16>=0)
{
System.out.println( "total subnets are "+ Math.pow(2,(e-16)));
subnetmask(cls,e);
}
else if(cls=='C'&& e-24>=0)
{
System.out.println( "total subnets are "+ Math.pow(2,(e-24)));
subnetmask(cls,e);
}
else
{System.out.println("in valid e part");
System.exit(1);}
}
//-----------------------------------------------------
public static void subnetmask(char cls,int e)
{
int snm[]=new int[32];
int p;
for(p=0;p<e;p++) snm[p]=1;
int a=255,b=0,c=0,d=0;
int i,j=0;
if(e-8>0)
{
i=7;j=8;
while(i>=0)
{
Double b1=Math.pow(2,i--);
int k=b1.intValue();
b=b+k*snm[j++];
}
}

if(e-16>0)
{
i=7;
while(i>=0)
{
Double b1=Math.pow(2,i--);
int k=b1.intValue();
c=c+k*snm[j++];
}
}

if(e-23>0)
{
i=7;
while(i>=0)
{
Double b1=Math.pow(2,i--);
int k=b1.intValue();
d=d+k*snm[j++];
}
}

System.out.println("subnet mask is "+a+"."+b+"."+c+"."+d);

}


//----------------------------------------------------
public static void broadcastAddr(int e)
{
int bca[]=new int[32];
int i,j;

for(i=0;i<32;i++)
{
	if(i<e){bca[i]=ip[i];}
	else
	{bca[i]=1;}
}
int A[]=new int[4];
Double d=0.0;int k,po;
for(i=0;i<4;i++)
{
A[i]=0;
for(j=0,po=7;j<8;j++)
{
d=Math.pow(2,po--);
k=d.intValue();
A[i]+=k*bca[(i*8)+j];
}
}
System.out.println("broadcast address is: "+A[0]+"."+A[1]+"."+A[2]+"."+A[3]);
if(d1>2.0)
{
A[3]-=1;
System.out.println("last host address is: "+A[0]+"."+A[1]+"."+A[2]+"."+A[3]);
}

}
//------------------------------------------------------
public static void subnetID(int e)
{
int bca[]=new int[32];
int i,j;

for(i=0;i<32;i++)
{
	if(i<e){bca[i]=ip[i];}
	else
	{bca[i]=0;}
}
int A[]=new int[4];
Double d=0.0;int k,po;
for(i=0;i<4;i++)
{
A[i]=0;
for(j=0,po=7;j<8;j++)
{
d=Math.pow(2,po--);
k=d.intValue();
A[i]+=k*bca[(i*8)+j];
}
}
System.out.println("subnet ID is: "+A[0]+"."+A[1]+"."+A[2]+"."+A[3]);
if(d1>2.0)
{
A[3]+=1;
System.out.println("first host address is: "+A[0]+"."+A[1]+"."+A[2]+"."+A[3]);
}

}

//-------------------------------------------------------
public static void main(String args[]) throws Exception
{
System.out.print("enter IP address like a.b.c.d,e in decimal       ");
Scanner in=new Scanner(System.in).useDelimiter("(\\p{javaWhitespace}|\\.|,)+");

int a,b,c,d,e;
a=in.nextInt();
b=in.nextInt();
c=in.nextInt();
d=in.nextInt();
e=in.nextInt();
if(a>255||b>255||c>255||d>255||e>31)
{
System.out.println("enter valid ip address");return;
}
//------------------------IP(decimal) to IP(binary)
ip=new int[32];
int i,j;

String temp=Integer.toBinaryString(a);
for(j=7,i=temp.length()-1;i>=0;j--,i--)
{
if(temp.charAt(i)=='1')
{ip[j]=1;}
}
temp=Integer.toBinaryString(b);
for(j=15,i=temp.length()-1;i>=0;j--,i--)
{
if(temp.charAt(i)=='1')
{ip[j]=1;}
}
temp=Integer.toBinaryString(c);
for(j=23,i=temp.length()-1;i>=0;j--,i--)
{
if(temp.charAt(i)=='1')
{ip[j]=1;}
}
temp=Integer.toBinaryString(d);
for(j=31,i=temp.length()-1;i>=0;j--,i--)
{
if(temp.charAt(i)=='1')
{ip[j]=1;}
}
//-------------------------
char cls;
if(ip[0]==0) cls='A';
else if(ip[1]==0) cls='B';
else if(ip[2]==0) cls='C';
else 
{
System.out.println("ip does not belong to class A,B,C");return;
}
//----------------number of subnets
subnet(cls,e);
//subnets    subnet_mask


//-----------------num_of_hosts
int h;
h=32-e;
d1=Math.pow(2,h);
System.out.println("number of hosts per subnet are:"+(d1-2));

if(d1<=2.0)
{
System.out.println("there are no hosts!!!!!");
System.exit(1);
}
broadcastAddr(e);
subnetID(e);


}
}