package ua.hillelit.lms.api;

public interface Publisher {

  boolean register(Observer observer);

  boolean unregister(Observer observer);

  <T> void notifyAllObservers(T messege);

  <T> void notifyPrivate(T messege, Observer follower);

}
