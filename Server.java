import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {
    public static ServerSocket ss;
   // public static BufferedReader sin;
   // public static PrintWriter sout;
    public static Socket soc;
    public static int i;
    public Server(Socket soc,int i)
    {
        //this.sin=sin;
       // this.sout=sout;
        this.i=i;
        this.soc=soc;
    }
    public void run()
    {
        try {
            BufferedReader sin = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            PrintWriter sout = new PrintWriter(soc.getOutputStream());
            while (true) {
                System.out.println("Client" + (i + 1) + " " + sin.readLine());
            }

        }
        catch (Exception e)
        {

        }
    }


    public static void main(String[] args) throws Exception
    {
        ss=new ServerSocket(5555);
        System.out.println("server started waiting for client:");
        int i=0;

        while(i<10)
        {
            Socket soc=ss.accept();
            System.out.println("client connected with IP:" + soc.getInetAddress().getHostAddress() + "\nport number of client is:" + soc.getPort());

            new Server(soc,i).start();
            i++;
        }
    }
}
