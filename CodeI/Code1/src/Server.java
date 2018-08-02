import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {
		final int PORT = 9999;
		ServerSocket server = new ServerSocket(PORT);
		System.out.println("Wait For Client to Connect....");
		Socket socket = server.accept();
		System.out.println("Welcome Client...");
		InputStream is = socket.getInputStream();
		DataInputStream ds = new DataInputStream(is);
		System.out.println("Ear .....");
		System.out.println(ds.readUTF());
//		int singleByte = is.read();
//		while(singleByte!=-1){
//			System.out.print((char)singleByte);
//			singleByte = is.read();
//		}
		ds.close();
		is.close();
		socket.close();
	}

}
