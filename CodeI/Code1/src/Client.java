import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost",9999);
		System.out.println("Client Connected...");
		System.out.println("Enter the Message Send to the Server");
		String msg = new Scanner(System.in).nextLine();
		OutputStream out  = socket.getOutputStream();
		DataOutputStream ds = new DataOutputStream(out);
		ds.writeUTF(msg);
		//out.write(msg.getBytes());
		out.close();
		socket.close();
		System.out.println("Good Bye Server....");

	}

}
