package com.monetique;

import java.util.Vector;
import com.jcraft.jsch.ChannelSftp.LsEntry;

public class SFTPMainDemo {

	// main class let exec demo
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//now we start up run
		SFTPBean sftpBean = new SFTPBean();

		boolean blResult = sftpBean.connect("30.30.1.140", 22, "root", "rootroot");

		if (blResult) {
			
			
			System.out.println("Connect successed");
			
			
			
			//now we will try to download file
		/*	blResult = sftpBean.downloadFile("/home/fichier1.txt", "C:\\Users\\stadigital\\Documents\\fichier1.txt");
			
			if(blResult) {
				System.out.println("dowload successed");
			}
			else {
				System.out.println("u failed");
			}*/
			
			//now we will try to upload file
			/*blResult = sftpBean.uploadFile( "C:\\Users\\stadigital\\Documents\\fichier2.txt","/home/fichier2.txt");
			if(blResult) {
				System.out.println("upload successed");
			}
			else {
				System.out.println("u failed");
			}
    		*/
			//in here i demo list file first.
			//checking again file that u have just uploaded file
			Vector<LsEntry> vtFiles = sftpBean.listFile("/home");

			if (vtFiles != null) {
				for (LsEntry lsEntry : vtFiles) {
					System.out.println(lsEntry.getFilename()  + "\r\n");
				}
			}
			
			
			sftpBean.close();
		} else {
			System.out.println("Connect failed.");
		}
	}

}
