package server;

import java.net.*;
import java.io.*;


public class server extends Thread
{
    ServerSocket server;
    Socket s;
    int num;
    /*InputStream in;
    OutputStream out;*/

    public server(int num, Socket s)
    {
        this.num = num;
        this.s = s;

        setDaemon(true);
        setPriority(NORM_PRIORITY);
        run();
    }
    public void run()
    {
        try
        {
        InputStream in = s.getInputStream();
        OutputStream out = s.getOutputStream();

        byte buf[] = new byte[64*1024]; //буффер длячтения 64 кб

        int r = in.read(buf);
            String data = new String(buf, 0, r);

            data = "" + num + ":" + "\n" + data;
            out.write(data.getBytes());

            s.close(); /*закрываем соединение*/
        }catch (Exception e)
        {
            System.out.println("Ошибка : " + e);
        }
    }


    public static void main(String[] args) throws Exception
    {
        try
        {
            int i = 0;

            ServerSocket server = new ServerSocket(3128,0,InetAddress.getByName("localhost"));
            System.out.println("Сервер запущен");
            while(true)
            {
                new server(i,server.accept());
                i++;
            }
        } catch(Exception e){
            System.out.println("Ошибка : " + e);
        }

    }

}






