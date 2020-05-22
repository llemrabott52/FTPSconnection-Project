package com.test;
import Format_Date_des_Logs.Datelog;

public class RegularExp {
	public static void main(String[] args) throws Exception{

		
		//DateExtractionLog(Log_Name, RegExpLogName, RegExpDte)
		
		System.out.println(Datelog.DateExtractionLog("log.22/05/2020.log","(log.)(.+)(.log.*)","dd/MM/yyyy"));
		
		 
	}

	
	
	
}
