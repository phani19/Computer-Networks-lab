import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception
    {
        ServerSocket ss=new ServerSocket(5000);
        Socket soc=ss.accept();
        //printing ip and port of client
        System.out.println("IP of client is "+soc.getInetAddress().getHostAddress());
        System.out.println("port number of client is "+soc.getPort());

        InputStream is=new FileInputStream("C:\\Users\\NIT-STUDENT\\Desktop\\411623\\TCP\\sample.txt");
        int fileLength=is.available();
        System.out.println("total file length in bytes is "+fileLength);
        byte b[]=new byte[fileLength];

        OutputStream sout=soc.getOutputStream();
        //sout.write(fileLength);
        int off=0;
        int len=1500;
        int i=1500;
        while(i+1500<fileLength)
        {
            System.out.println(off+" "+len);
            sout.write(b,off,len);
            off=off+1500;
            i=i+1500;
            Thread.sleep(3000);
        }



    }
}
