package com.example.pocnew.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pocnew.entity.CronAttributes;
import com.example.pocnew.jpa.CronAttributesRepository;

@RestController
@RequestMapping("/cron")
public class BankAccountController
{
	@Autowired
    private CronAttributesRepository cronAttributesRepository;

  

    @GetMapping("/details")
    public Iterable<CronAttributes> all(){
        return cronAttributesRepository.findAll();
    }
}
