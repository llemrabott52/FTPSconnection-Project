package com.monetique.helper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DatelogHelper {

	   public static Date DateExtractionLog(String logName, String ExRegLog, String ExRegDate) throws Exception {
		   
		   if(logName.equals(".") || logName.equals("..")) {
			   return null;
		   }
		   
		   String dateFormat = null;
		   Pattern pp=Pattern.compile(ExRegLog); Matcher mm=pp.matcher(logName);
		   while(mm.find()) { 
		       dateFormat=mm.group(2);
		   }
			 
		   if(dateFormat==null) {
				  throw new Exception("la chaine date est vide");
		   }
		 
		 DateFormat df= new SimpleDateFormat(ExRegDate);
		 
		 Date date= null;
		 
		 try {
			date= df.parse(dateFormat);
			

		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("format date invalide");
		}
		 
		 return date;
		 
		 
	 }
		   
	   
	   
	   public static boolean compareDateLogDateIndex(Date dateLog,Date dateIndex) throws Exception {	   
		   
		   boolean res=false;
		   
		   if(dateLog.getTime()>dateIndex.getTime())
			   res=true;
		   

		 return res;
		 
		 
	 }
		   
	   

	   
}

