import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class CLient {
    public static void main(String args[])throws Exception
    {
        System.out.println("enter ip address:");
        Scanner sc=new Scanner(System.in);
        String ip=sc.nextLine();
        Socket soc=new Socket(ip,5000);

        OutputStream os=new FileOutputStream("C:\\Users\\NIT-STUDENT\\Desktop\\411623\\TCP\\sampleClient.txt");
        InputStream sin=soc.getInputStream();

        int fileLength=9510;
        byte b[]=new byte[fileLength];
        int off=0;
        int len=1500;
        int i=1500;
        while(i+1500<fileLength)
        {
            System.out.println(off+" "+len);
            sin.read(b,off,len);
            off=off+1500;
            i=i+1500;
            System.out.println(b);
            for(int j=0;j<1500;j++)
            {
                os.write((char)b[j]);
            }
            Thread.sleep(3000);
        }



    }
}
