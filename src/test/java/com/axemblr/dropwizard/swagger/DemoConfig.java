package com.axemblr.dropwizard.swagger;

import com.yammer.dropwizard.config.Configuration;
import org.codehaus.jackson.annotate.JsonProperty;

public class DemoConfig extends Configuration {

  @JsonProperty
  private String name;

  public String getName() {
    return name;
  }
}
