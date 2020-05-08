package com.example.pocnew.jpa;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.pocnew.entity.CronAttributes;



//@Repository
public class CronAttributesJdbcRepository 
{

   @Autowired
    JdbcTemplate jdbcTemplate;

    class CronDetailsRowMapper implements RowMapper <CronAttributes> 
    {

        @Override
        public CronAttributes mapRow(ResultSet rs, int rowNum) throws SQLException {
        	
        	
        	CronAttributes CronDetailsList = new CronAttributes();
        	CronDetailsList.setCronID(rs.getInt("CRONID"));
        	CronDetailsList.setSeconds(rs.getString("SECONDS"));
        	CronDetailsList.setMinutes(rs.getString("MINUTES"));
        	CronDetailsList.setHours(rs.getString("HOURS"));
        	CronDetailsList.setDayOfMonth(rs.getString("DAY_OF_MONTH"));
        	CronDetailsList.setMonth(rs.getString("MONTH"));
        	CronDetailsList.setDayOfTheWeek(rs.getString("DAY_OF_THE_WEEK"));
        	        	
        	return CronDetailsList;
        }

/*String cronTime="0 0/1 * * * MON-FRI";
 * 
 * select * from cron_attributes;
 

insert into  cron_attributes values (1, '*', '*' ,'0/1', 'MON-FRI' , '*',  '0');
/*select * from cron_attributes;

insert into  cron_attributes values (1, '*', '*' ,'0/1', 'MON-FRI' , '*',  '0');

CRONID
DAY_OF_MONTH
HOURS
MINUTES
DAY_OF_THE_WEEK
MONTH
SECONDS

1	*	*	0/1	MON-FRI	*	0 */

    }

   
   /* public List <CronAttributes> findAll() {

        return jdbcTemplate.query("select * from cron_attributes", new CronDetailsRowMapper());

    }*/






}