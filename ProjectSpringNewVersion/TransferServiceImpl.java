package com.monetique.services.impl;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monetique.entities.Composant;
import com.monetique.entities.Parameter;
import com.monetique.helper.DatelogHelper;
import com.monetique.repositories.ComposantRepository;
import com.monetique.repositories.ParameterRepository;
import com.monetique.services.SftpService;
import com.monetique.services.TransferService;

@Service
public class TransferServiceImpl implements TransferService {
   
	@Autowired
	SftpService sftpService;
	
	@Autowired
	ParameterRepository parameterRepository;
	
	@Autowired
	ComposantRepository composantRepository;
    
	@Override
	public void traitementTransferLogComposant(Composant c) throws Exception {
	Optional<Parameter> opt= parameterRepository.findById(1L);
	if(!opt.isPresent()) {
		throw new Exception("Parametre innexistant !");
	}
		
		// recuperation du parameter
		Parameter parameter = opt.get();
		
		// initialisation de la connection avec le serveur SFTP
		sftpService.closeConnection();
		sftpService.setConnection(c.getIp(),c.getPort(), c.getUsername(),c.getPassword());
		
		
		
		List<String> listLog= sftpService.listeNomFichierDistant(c.getUrlLogs());
		
		Date dateProvisoire=c.getIndexDate();
		
		for(String logName : listLog) {
			
			// recuperation de la date du log
			 Date dateLog = DatelogHelper.DateExtractionLog(logName, c.getRegExpLogs(), c.getExpDate()) ;

			 if(dateLog==null) {
				 continue;
			 }
			 
			 
			 // verification du traitement du fichier Log
			 boolean verifier=DatelogHelper.compareDateLogDateIndex(dateLog, c.getIndexDate());
			 
			 if(verifier) {
				 // traitement de transfer
				 
				 // recuperation du fichier
				 
				 // transfer vers dossier intermediaire
				 boolean recuperation= sftpService.recupererFichierDistant(c.getUrlLogs()+c.getSepUrlLogs()+logName, parameter.getUrlIntermediaire()+File.separator+logName);
				 
				 if(!recuperation) {
					throw new Exception("Erreur produit pandant le telechargement du ficher distant"); 
				 }
				 
				 // transfer vers Partage
				// boolean transfer= sftpService.transfererFichierLocal(parameter.getUrlIntermediaire()+"\\"+logName,c.getUrlPartage()+"\\"+logName);

				 boolean transfer= sftpService.transfererFichierInterLocal(parameter.getUrlIntermediaire()+File.separator+logName,c.getUrlPartage()+c.getSepUrlPartage()+logName);

				 if(!transfer) {
						throw new Exception("Erreur produit pandant le transfer du ficher vers partage"); 
					 }
				 
				 // fin traitement
				 
				 // mise a jour de date Provisoire 
				 if(dateLog.getTime()>dateProvisoire.getTime()) {
					 dateProvisoire=dateLog;
				 }
				 
			 }
			 
		}
		
		// fermer la connection au serveur SFTP
		sftpService.closeConnection();

		
		 // mise a jour de l'index 		
		c.setIndexDate(dateProvisoire);
		
		// save c
		composantRepository.save(c);
		
	}

	
}
