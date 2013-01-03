Dropwizard integration with Wordnik Swagger
-------------------------------------------

To use it you need to:

* add annotations to describe your resources as documented here:
  https://github.com/wordnik/swagger-core/wiki
* put `bootstrap.addBundle(new AssetsBundle("/swagger-ui"));` in your service `initialize()` method
* put `environment.addResource(new ApiListingResourceJSON());` in your service `run()` method

The JS client should be available at http://localhost:8080/swagger-ui/index.html

Licensed under the Apache License version 2.0
