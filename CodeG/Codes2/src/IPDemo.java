import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class IPDemo {

	public static void main(String[] args) throws UnknownHostException {
		InetAddress inet = InetAddress.getLocalHost();
		System.out.println(inet);
		System.out.println("Enter the Host Name");
		String hostName = new Scanner(System.in).next();
		InetAddress inetArr[] = InetAddress.getAllByName(hostName);
		for(InetAddress i : inetArr){
			System.out.println(i);
		}
		// TODO Auto-generated method stub

	}

}
