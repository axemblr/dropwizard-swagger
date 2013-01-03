package com.axemblr.dropwizard.swagger;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.config.Configuration;

public class DemoConfig extends Configuration {

  @JsonProperty
  private String name;

  public String getName() {
    return name;
  }
}
