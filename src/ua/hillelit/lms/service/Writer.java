package ua.hillelit.lms.service;

import java.util.ArrayList;
import java.util.List;
import ua.hillelit.lms.api.Observer;
import ua.hillelit.lms.api.Publisher;
import ua.hillelit.lms.entity.Update;
import ua.hillelit.lms.entity.Load;
import ua.hillelit.lms.entity.media.Media;

public class Writer implements Publisher, Observer {

  private final String name;
  private final List<Observer> followers = new ArrayList<>();

  private final Load<Media> medias = new Load<>();

  public Writer(String name) {
    this.name = name;
  }

  public <T> void tweet(T tweet) {
    printTweet(tweet);
    notifyAllObservers(tweet);
  }

  public <T> void tweet(T tweet, Observer follower) {
    printTweet(tweet);
    notifyPrivate(tweet, follower);
  }

  private <T> void printTweet(T tweet) {
    String massage = "\n<<< " + name + " has tweeted :: " + tweet + "\n";
    System.out.println(massage);
  }

  public void load(Media media) {
    medias.add(media);
    loadMassage(media);
  }

  private void loadMassage(Media media) {
    String massage = "*** " + name + " has loaded :: " + media;
    System.out.println(massage);
  }

  @Override
  public boolean register(Observer observer) {
    return followers.add(observer);
  }

  @Override
  public boolean unregister(Observer observer) {
    return followers.remove(observer);
  }

  @Override
  public <T> void notifyAllObservers(T tweet) {
    for (Observer follower : followers) {
      follower.update(name, new Update<>(tweet));
    }
  }

  @Override
  public <T> void notifyPrivate(T tweet, Observer follower) {
    follower.update(name, new Update<>(tweet));
  }

  @Override
  public <T> void update(String name, T update) {
    String massage = ">>> " + this.name + " has received " + name + "tweet :: " + update;
    System.out.println(massage);
  }

  public String getName() {
    return name;
  }

  public List<Observer> getFollowers() {
    return followers;
  }

}
