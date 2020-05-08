package com.example.pocnew.scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import com.example.pocnew.entity.CronAttributes;
import com.example.pocnew.jpa.CronAttributesRepository;
import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Component
@ConditionalOnProperty(name = "app.db-init", havingValue = "true")
public class DbInitializer implements CommandLineRunner 
{
	
	private static final org.apache.logging.log4j.Logger logger= LogManager.getLogger(DbInitializer.class);

	@Autowired
    private CronAttributesRepository cronAttributesRepository;

    @Override
    public void run(String... strings) throws Exception
    {
        cronAttributesRepository.deleteAll();

        CronAttributes att=new CronAttributes();
    	att.setCronID(1);
    	att.setSeconds("0");
    	att.setMinutes("0/1");
    	att.setHours("*");
    	att.setDayOfMonth("*");
    	att.setMonth("*");
    	att.setDayOfTheWeek("MON-FRI");
    	cronAttributesRepository.save(att);


    	
		 logger.info(" -- Database has been initialized");
    }
}
