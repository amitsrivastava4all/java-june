import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Downloader {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the URL ");
		String urlStr =s.next();
		URL url = new URL(urlStr);
		URLConnection connectObj = url.openConnection();
		connectObj.connect();
		InputStream is = connectObj.getInputStream();
		BufferedInputStream bs = new BufferedInputStream(is);
		FileOutputStream fs = new FileOutputStream("/Users/amit/Documents/files/google.jpg");
		BufferedOutputStream bo = new BufferedOutputStream(fs);
		int singleByte = bs.read();
		while(singleByte!=-1){
			bo.write(singleByte);
			singleByte = bs.read();
		}
		System.out.println("File Downloaded...");
		bs.close();
		bo.close();
		fs.close();
		is.close();
		s.close();

	}

}











