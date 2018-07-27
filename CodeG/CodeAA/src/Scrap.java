import java.io.BufferedInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Scrap {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the URL ");
		String urlStr =s.next();
		URL url = new URL(urlStr);
		URLConnection connectObj = url.openConnection();
		connectObj.connect();
		StringBuilder sb = new StringBuilder();
		InputStream is = connectObj.getInputStream();
		BufferedInputStream bs = new BufferedInputStream(is);
		//FileOutputStream fs = new FileOutputStream("/Users/amit/Documents/files/google.jpg");
		//BufferedOutputStream bo = new BufferedOutputStream(fs);
		int singleByte = bs.read();
		while(singleByte!=-1){
			sb.append((char)singleByte);
			//bo.write(singleByte);
			singleByte = bs.read();
		}
		FileWriter fw = new FileWriter("/Users/amit/Documents/files/espn.html");
		fw.write(sb.toString());
		fw.close();
		
		System.out.println("Scrap");
		System.out.println("HTML IS ");
		//System.out.println(sb);
		bs.close();
		
		is.close();
		s.close();

	}

}
