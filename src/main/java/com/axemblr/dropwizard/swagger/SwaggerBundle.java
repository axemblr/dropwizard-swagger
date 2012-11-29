package com.axemblr.dropwizard.swagger;

import com.yammer.dropwizard.bundles.AssetsBundle;
import com.yammer.dropwizard.config.Environment;

import com.wordnik.swagger.jaxrs.listing.ApiListingResourceJSON;

public class SwaggerBundle extends AssetsBundle {

    public static final String DEFAULT_PATH = "/swagger-ui";

    public SwaggerBundle() {
        super(DEFAULT_PATH);
    }

    @Override
    public void initialize(Environment environment) {
        super.initialize(environment);
        environment.addResource(new ApiListingResourceJSON());
    }
}
