package com.monetique.services;

import java.util.List;

public interface SftpService {
	
	
     public boolean setConnection(String ip,int port,String username,String password);
     
     public boolean closeConnection();
       
     public boolean recupererFichierDistant(String urlFichierDistant,String urlFichierLocal);
     
     public boolean transfererFichierLocal(String urlFichierLocal,String urlFichierDistant);
     
     public boolean transfererFichierInterLocal(String urlFichierLocalIn,String urlFichierLocalOut);

     public List<String> listeNomFichierDistant(String urlDossierDistant);

     
}
