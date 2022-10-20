package ua.hillelit.lms.api;

public interface Observer {

  <T> void update(String name, T update);

}
