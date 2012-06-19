package com.axemblr.dropwizard.swagger;

import com.axemblr.dropwizard.swagger.resources.PetResource;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Environment;
import com.yammer.metrics.core.HealthCheck;

public class DemoService extends Service<DemoConfig> {

  public static void main(String[] args) throws Exception {
    new DemoService().run(args);
  }

  public DemoService() {
    super("demo-service");
    addBundle(new SwaggerBundle());
  }

  @Override
  protected void initialize(DemoConfig config,
                            Environment environment) throws Exception {
    environment.addResource(new PetResource());
  }
}
