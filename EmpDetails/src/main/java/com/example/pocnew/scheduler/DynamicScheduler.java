package com.example.pocnew.scheduler;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import com.example.pocnew.entity.CronAttributes;
import com.example.pocnew.jpa.CronAttributesJdbcRepository;
import com.example.pocnew.jpa.CronAttributesRepository;


@EnableScheduling
@Service
public class DynamicScheduler implements SchedulingConfigurer 
{
	private static final org.apache.logging.log4j.Logger logger= LogManager.getLogger(DynamicScheduler.class);

    public String cronTime="0 0/1 * * * MON-FRI";


    @Autowired
    CronAttributesRepository cronAttributesRepository;
   
    
    @Bean
    public TaskScheduler poolScheduler()
    {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setThreadNamePrefix("ThreadPoolTaskScheduler");
        scheduler.setPoolSize(1);
        scheduler.initialize();
        return scheduler;
    }

    // We can have multiple tasks inside the same registrar as we can see below.
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar)
    {
    	
    	 List<CronAttributes> CronDetailsList=  (List<CronAttributes>) cronAttributesRepository.findAll();

    	 for(CronAttributes att : CronDetailsList)
	 	    {
	    	    		 
 		 logger.info("cronId :"+att.getCronID());
 	    	
 		   
 	    	logger.info("Seconds :"+att.getSeconds());
 	    	logger.info("Minutes :"+att.getMinutes());
 	    	logger.info("Hours :"+att.getHours());
 	    	logger.info("DayOfMonth :"+att.getDayOfMonth());
 	    	logger.info("Month :"+att.getMonth());
 	    	logger.info("DayOfTheWeek :"+att.getDayOfTheWeek());
 	    	StringBuilder sb=new StringBuilder();
 	    	sb.append(att.getSeconds()).append(" ").append(att.getMinutes()).append(" ").append(att.getHours()).append(" ").append(att.getDayOfMonth())
 	    	.append(" ").append(att.getMonth()).append(" ").append(att.getDayOfTheWeek());
	 	    	
 	   	logger.info("sb:"+sb.toString());
 	        taskRegistrar.setScheduler(poolScheduler());

 	        // or cron way, you can also get the expression from DB or somewhere else just like we did above.
 	        CronTrigger croneTrigger = new CronTrigger(sb.toString());
 	        taskRegistrar.addTriggerTask(() -> scheduleCron( sb.toString()), croneTrigger);
	 	    }
 	
	   
    }

   
    public void scheduleCron(String cron) 
    {
    	
    	logger.info("scheduleCron: Next execution time of this taken from cron expression -> {}", cron);
    }

   
}
