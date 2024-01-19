import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 3333);
            System.out.println("Connected to the server.");

            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String str = "", str2 = "";
            while (!str.equals("stop")) {
                System.out.print("Client: ");
                str = br.readLine();
                dout.writeUTF(str);
                dout.flush();
                str2 = din.readUTF();
                System.out.println("Server: " + str2);
            }

            dout.close();
            din.close();
            s.close();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
}
