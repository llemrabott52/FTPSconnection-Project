package com.monetique.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Composant {
 @Id
 String libelle;
 
 String regExpLogs, expDate; 
 String urlLogs, urlPartage; 
 String ip, username, password;
 Date indexDate;
 int port;
 String sepUrlPartage;
 public String getSepUrlPartage() {
	return sepUrlPartage;
}
public void setSepUrlPartage(String sepUrlPartage) {
	this.sepUrlPartage = sepUrlPartage;
}
public String getSepUrlLogs() {
	return sepUrlLogs;
}
public void setSepUrlLogs(String sepUrlLogs) {
	this.sepUrlLogs = sepUrlLogs;
}
String sepUrlLogs;
	
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getLibelle() {
		return libelle;
	}
	
	public void setIndexDate(Date indexDate) {
		this.indexDate = indexDate;
	}
	public Date getIndexDate() {
		return indexDate;
	}
	
	public void setRegExpLogs(String regExpLogs) {
		this.regExpLogs = regExpLogs;
	}
	public String getRegExpLogs() {
		return regExpLogs;
	}
	
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	public String getExpDate() {
		return expDate;
	}
	
	public void setUrlLogs(String urlLogs) {
		this.urlLogs = urlLogs;
	}
	public String getUrlLogs() {
		return urlLogs;
	}
	
	public void setUrlPartage(String urlPartage) {
		this.urlPartage = urlPartage;
	}
	public String getUrlPartage() {
		return urlPartage;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getIp() {
		return ip;
	}

	public void setPort(int port) {
		this.port = port;
	}
	public int getPort() {
		return port;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsername() {
		return username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	
}
