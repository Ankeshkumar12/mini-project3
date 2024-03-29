import java.io.*;
import java.net.*;

public class server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(3333);
            System.out.println("Server is running and waiting for a client...");

            Socket s = ss.accept();
            System.out.println("Client connected");

            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String str = "", str2 = "";
            while (!str.equals("stop")) {
                str = din.readUTF();
                System.out.println("Client says: " + str);
                str2 = br.readLine();
                dout.writeUTF(str2);
                dout.flush();
            }

            din.close();
            s.close();
            ss.close();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
}
