package Format_Date_des_Logs;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Datelog {

	   public static Date DateExtractionLog(String logName, String ExRegLog, String ExRegDate) throws Exception {
		   
		   
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
		   
	   

	   
}

