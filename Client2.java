import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {
    public static void main(String args[])throws Exception
    {
        Scanner sc=new Scanner(System.in);
        String ip=sc.nextLine();
        Socket soc=new Socket(ip,5555);
        BufferedReader sin=new BufferedReader(new InputStreamReader(soc.getInputStream()));
        PrintWriter sout=new PrintWriter(soc.getOutputStream(),true);
        String msg;
        while (true) {
            msg=sc.nextLine();
            sout.println(msg);
        }
    }
}
