package com.example.scheduler.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.dao.ClanDAO;
import com.example.service.MyUtil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;


@Component
public class ScheduledTasks {
	
	@Autowired
	ClanDAO clandao;

    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

  /*  @Scheduled(fixedRate = 12000)
    public void scheduleTaskWithFixedRate() {
        logger.info("Fixed Rate Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()) );
       long t = clandao.countByIme(clandao.findById((long) 1).get().getIme());
        logger.info("ima ih "+t);
    }
*/
    @Scheduled(fixedDelay = 25000)
    public void scheduleTaskWithFixedDelay() {
        logger.info("Fixed Delay Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
        try {
            TimeUnit.SECONDS.sleep(15);
        } catch (InterruptedException ex) {
            logger.error("Ran into an error {}", ex);
            throw new IllegalStateException(ex);
        }
    }

   /* 
    
    @Scheduled(fixedRate = 52000, initialDelay = 55000)
    public void scheduleTaskWithInitialDelay() {
        logger.info("Fixed Rate Task with Initial Delay :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
    }
*/
    
    //  salje mail na sve adrese svakog prvog u 00.00h ..
    @Scheduled(cron = "0 32 15 5 * ?")
    public void scheduleTaskWithCronExpression() {
    	
    	   MyUtil.saljiMailClanovimaSaDugovanjima(new Date());
        
    	logger.info("Cron Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
    }

	

}
