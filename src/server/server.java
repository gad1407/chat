package server;

import java.net.ServerSocket;
import java.net.Socket;


public class server {
    public static void main(String[] args) throws Exception
    {
        ServerSocket servers;
        Socket client;
        servers = null;
        client = null;
        try
        {
            servers = new ServerSocket(4444);
        }
        catch(Exception e)
        {
            System.out.println("Невозможно подключиться");
            System.exit(-1);
        }
        try
        {
            System.out.println("Ожидание клиента");
            client = servers.accept();
            System.out.println("Клиент подключен");
        }
        catch(Exception e)
        {
            // System.out.println("");
            System.exit(-1);
        }
    }
}






