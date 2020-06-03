/*
 * package com.monetique;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.scheduling.annotation.EnableScheduling; import
 * org.springframework.scheduling.annotation.Scheduled;
 * 
 * import com.monetique.services.impl.TraitementServiceImpl;
 * 
 * @Configuration
 * 
 * @EnableScheduling public class TachePlannifier {
 * 
 * @Autowired TraitementServiceImpl traitementServiceImpl;
 * 
 * @Scheduled(cron = "0/10 * * * * *") public void
 * tachePlannifierTraitementLog() throws Exception {
 * 
 * traitementServiceImpl.traitementBatch();
 * 
 * }
 * 
 * 
 * }
 */