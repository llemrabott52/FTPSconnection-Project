package com.monetique.services.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.springframework.stereotype.Service;

import com.jcraft.jsch.ChannelSftp.LsEntry;
import com.monetique.SFTPBean;
import com.monetique.services.SftpService;

@Service
public class SftpServiceImpl implements SftpService {

	SFTPBean sftpBean =null;

	@Override
	public boolean closeConnection() {
		if(sftpBean!=null) {
			sftpBean.close();
		}
		return true;
	}
	@Override
	public boolean setConnection(String ip, int port, String username, String password) {
		// TODO Auto-generated method stub
		if(sftpBean==null) {
			sftpBean = new SFTPBean();
		}
		return sftpBean.connect(ip, port, username, password);
		
	}

	@Override
	public boolean recupererFichierDistant(String urlFichierDistant, String urlFichierLocal) {
		// TODO Auto-generated method stub
		return sftpBean.downloadFile(urlFichierDistant, urlFichierLocal);
	}

	@Override
	public boolean transfererFichierLocal(String urlFichierLocal, String urlFichierDistant) {
		// TODO Auto-generated method stub
		return sftpBean.uploadFile(urlFichierLocal, urlFichierDistant);
	}

	@Override
	public List<String> listeNomFichierDistant(String urlDossierDistant) {
		// TODO Auto-generated method stub
		List<String> res=new ArrayList<>();
		
		Vector<LsEntry> vtFiles = sftpBean.listFile(urlDossierDistant);

		if (vtFiles != null) {
			for (LsEntry lsEntry : vtFiles) {
				res.add(lsEntry.getFilename());
			}
		}
		
		return res;
	}
	
	@Override
	public boolean transfererFichierInterLocal(String urlFichierLocalIn, String urlFichierLocalOut) {
		
		boolean res=false;
		try{

	           File afile =new File(urlFichierLocalIn);

	           if(afile.renameTo(new File(urlFichierLocalOut))){
	            res = true;
	           }
	        }catch(Exception e){
	            e.printStackTrace();
	        }
		
		return res;
		
		
		
	}



}
