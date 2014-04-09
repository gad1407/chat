package server;

import java.io.*;
import java.net.*;

public class Client extends Thread
{ public static void main(String[] args)throws Exception
 {
     try{
    Socket s = new Socket("localhost", 3128);
    args[0] = args[0] + "\n" + s.getInetAddress().getHostAddress() + ": " + s.getLocalPort();
    s.getOutputStream().write(args[0].getBytes());
    byte buf[] = new byte[64*1024];
    int r = s.getInputStream().read(buf);
         String data = new String(buf, 0, r);
         System.out.println(data);

}
catch (Exception e)
{
System.out.println("Ошибка : " + e);
}
}

}
