/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dhfr.retry;

/**
 *
 * @author d.husnifahririzal
 */

import com.dhfr.retry.impl.RetryService;
import com.dhfr.retry.impl.RetryServiceJitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {

    @Autowired
    private RetryService retryService;
    @Autowired
    private RetryServiceJitter retryServiceJitter;

  // @Override    
  // public void run(String... args) throws Exception {
     //   retryService.performOperation();
        
   // }
    
     @Override
  public void run(String... args) throws Exception {
        retryServiceJitter.performOperation(0.7);
        
   }
}


    

