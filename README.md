Dropwizard integration with Wordnik Swagger
-------------------------------------------

To use it you need to:

* use SwaggerResource as base class for your resources
* add annotations to describe your resources as documented here:
  http://swagger.wordnik.com/spec
* put `addBundle(new SwaggerBundle())` in your service constructor 

The JS client should be available at http://localhost:8080/swagger-ui/index.html

Licensed under the Apache License version 2.0
