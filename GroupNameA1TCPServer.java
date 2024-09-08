import java.io.*;
import java.net.*;

public class GroupNameA1TCPServer {
    public static void main(String argv[]) throws Exception
    {
      boolean check = true;
      String receive = "";

      ServerSocket welcomeSocket = new ServerSocket(12222,0, InetAddress.getByName(null));
 
      while(check) {

           Socket connectionSocket = welcomeSocket.accept();

           BufferedReader inFromClient =
             new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            receive = inFromClient.readLine();
            System.out.println(receive);
            if(!receive.equals(""))
            {
                check = false;
            }
        }
        welcomeSocket.close();
    }
}
