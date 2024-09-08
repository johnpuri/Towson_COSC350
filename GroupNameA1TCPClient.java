import java.io.*;
import java.net.*;
public class GroupNameA1TCPClient {
    public static void main(String argv[]) throws Exception
    {
        try
        {
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
            String inputLine;
            int nb = 0;
            int y = 0;

            System.out.println("Enter full webpage url");
            String uinput = reader.readLine();
            URL obj = new URL(uinput); //Creates URL object for entered url

            InetAddress address = InetAddress.getByName(obj.getHost()); // Gets ip address
            String ip = address.getHostAddress();
            HttpURLConnection con = (HttpURLConnection) obj.openConnection(); //Creates http connection of the url object obj
            con.setRequestMethod("GET"); 
           con.setRequestProperty("User-Agent","Mozilla/5.0");  

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream())); 
                        while ((inputLine = in.readLine()) != null)
                            System.out.println(inputLine); 
            in.close();

            HttpURLConnection contwo = (HttpURLConnection) obj.openConnection();
            contwo.setRequestMethod("GET");
            contwo.setRequestProperty("User-Agent","Mozilla/5.0"); //More schizo code

            BufferedReader byteCounter = new BufferedReader(new InputStreamReader(contwo.getInputStream())); //Counts bytes of webpage
                while((y = byteCounter.read()) != -1) //Input stream reader converts bytes into characters. 
                    nb++;
            byteCounter.close();

            System.out.println("The number of BYTES is " + nb);
            System.out.println(ip);

            Socket clientSocket = new Socket("localhost", 12222); //Opens socket to localhost on port 12222
            DataOutputStream clientOut = new DataOutputStream(clientSocket.getOutputStream()); //Creates an output stream to be sent to localhost
            clientOut.writeBytes("WEB SERVER " + uinput + " " + ip + " " + nb);
            clientSocket.close();
        }
        catch (Exception e)
        {
            System.out.println("Something broke. Check entered page url to see if valid. Make sure you include full url. Make sure server was launched");
        }
    }
}

