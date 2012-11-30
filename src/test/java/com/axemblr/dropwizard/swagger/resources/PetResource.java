package com.axemblr.dropwizard.swagger.resources;

import com.axemblr.dropwizard.swagger.core.Pet;
import com.google.common.collect.ImmutableSet;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import java.util.Set;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/pet.json")
@Api("/pet")
@Produces(MediaType.APPLICATION_JSON)
public class PetResource {

  @GET
  @ApiOperation("Retrieve a list of pets")
  public Set<Pet> list() {
    return ImmutableSet.of(
        new Pet("Dog", 4),
        new Pet("Cat", 4),
        new Pet("Chicken", 2)
    );
  }
}
