package com.ontime;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.util.logging.Logger;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@SpringBootApplication
public class OnTimeApplication {
  public static void main(String args[]) {
    SpringApplication.run(OnTimeApplication.class, args);

    final Logger log =
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    log.info("Your OnTime Application has started!");

    }

  @Bean // Want a new obj every time
  @Scope("prototype")
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }
  }
