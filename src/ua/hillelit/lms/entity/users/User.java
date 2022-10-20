package ua.hillelit.lms.entity.users;

import ua.hillelit.lms.api.Observer;
import ua.hillelit.lms.entity.Update;

public abstract class User implements Observer {

  private final String name;

  public User(String name) {
    this.name = name;
  }

  @Override
  public <T> void update(String name, T update) {
    String massage = ">>> " + this.name + " has received " + name + "tweet :: " +  update;
    System.out.println(massage);
  }


}
