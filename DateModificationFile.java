package com.test;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DatemodificationFile {
	
	    public static void main(String args[]) throws ParseException {
	        String hostname = "30.30.1.140";
	        String username = "root";
	        String password = "rootroot";
	        String remoteFile = "/home/fichier1.txt";
	        String copyTo = "C:\\Users\\stadigital\\Documents\\fichier1.txt";
	        JSch jsch = new JSch();
	        Session session = null;
	        System.out.println("Trying to connect.....");
	        try {
	            session = jsch.getSession(username, hostname, 22);
	            session.setConfig("StrictHostKeyChecking", "no");
	            session.setPassword(password);
	            session.connect();
	            Channel channel = session.openChannel("sftp");
	            channel.connect();
	            ChannelSftp sftpChannel = (ChannelSftp) channel;
	            //get date of file=========================================   
	            String lastModif = sftpChannel.lstat(remoteFile).getMtimeString();

	            //I want to get creation date =============================
	           // creation_date= ???????????;

	          //==============================================
	                sftpChannel.get(remoteFile, copyTo);
	                sftpChannel.exit();
	                session.disconnect();


	        } catch (JSchException e) {
	        } catch (SftpException e) {
	        }

	    }
	
}
