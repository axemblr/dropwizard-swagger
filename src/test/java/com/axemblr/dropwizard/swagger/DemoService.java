package com.axemblr.dropwizard.swagger;

import com.axemblr.dropwizard.swagger.resources.PetResource;
import com.wordnik.swagger.jaxrs.listing.ApiListingResourceJSON;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.assets.AssetsBundle;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

public class DemoService extends Service<DemoConfig> {

  public static void main(String[] args) throws Exception {
    new DemoService().run(args);
  }

  @Override
  public void initialize(Bootstrap<DemoConfig> bootstrap) {
      bootstrap.setName("demo-service");
      bootstrap.addBundle(new AssetsBundle("/swagger-ui"));
  }

  @Override
  public void run(DemoConfig config,
                            Environment environment) {
    environment.addResource(new PetResource());
    environment.addResource(new ApiListingResourceJSON());
  }
}
