package com.brainmentors.testengine.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.brainmentors.testengine.user.dto.UserDTO;
import com.brainmentors.testengine.util.constants.PathConstants;

public interface OffLine {
	public static UserDTO readObject() throws ClassNotFoundException, IOException{
		File file = new File(PathConstants.OFFLINE_REGISTERPATH);
		if(file.exists()){
			file.mkdirs();
			//file.mkdir();
			//file.delete();
		FileInputStream fi = new FileInputStream(file);
		ObjectInputStream os =new ObjectInputStream(fi);
		UserDTO userDTO = (UserDTO)os.readObject();
		
		return userDTO;
		}
		else{
			return null;
		}
	}
	public static boolean writeObject(UserDTO userDTO) throws IOException{
		FileOutputStream fs = new FileOutputStream(PathConstants.OFFLINE_REGISTERPATH);
		ObjectOutputStream os = new ObjectOutputStream(fs);
		os.writeObject(userDTO);  // Convert Object into Bytes
		os.close();
		fs.close();
		return true;
	}

}












