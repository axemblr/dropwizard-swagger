package com.axemblr.dropwizard.swagger.core;

import org.codehaus.jackson.annotate.JsonProperty;

public class Pet {

  private final String name;
  private final int legs;

  public Pet(@JsonProperty("name") String name, @JsonProperty("legs") int legs) {
    this.name = name;
    this.legs = legs;
  }

  public String getName() {
    return name;
  }

  public int getLegs() {
    return legs;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Pet pet = (Pet) o;

    if (legs != pet.legs) return false;
    if (name != null ? !name.equals(pet.name) : pet.name != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + legs;
    return result;
  }

  @Override
  public String toString() {
    return "Pet{" +
        "name='" + name + '\'' +
        ", legs=" + legs +
        '}';
  }
}
