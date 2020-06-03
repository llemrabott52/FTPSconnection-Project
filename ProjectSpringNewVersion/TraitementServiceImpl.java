package com.monetique.services.impl;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monetique.entities.Composant;
import com.monetique.repositories.ComposantRepository;
import com.monetique.services.TraitementService;
@Service
public class TraitementServiceImpl implements TraitementService{
@Autowired
ComposantRepository composantRepository;

@Autowired
TransferServiceImpl transferServiceImpl;

	@Override
	public void traitementBatch() throws Exception {
		// TODO Auto-generated method stub
		Iterator<Composant> iter = composantRepository.findAll().iterator();
		while (iter.hasNext()) {
			Composant item = iter.next();
			transferServiceImpl.traitementTransferLogComposant(item);
		}
	}

}
