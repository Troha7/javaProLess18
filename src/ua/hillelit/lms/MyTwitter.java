package ua.hillelit.lms;

import ua.hillelit.lms.entity.media.Audio;
import ua.hillelit.lms.entity.media.Picture;
import ua.hillelit.lms.entity.media.Video;
import ua.hillelit.lms.entity.users.Follower;
import ua.hillelit.lms.service.Writer;

public class MyTwitter {

  public static void main(String[] args) {

    Writer elonMusk = new Writer("@ElonMusk");
    Writer zelensky = new Writer("@Zelensky");

    elonMusk.register(new Follower("@Ivan"));
    elonMusk.register(new Follower("@Vasil"));
    elonMusk.register(new Follower("@Taras"));

    elonMusk.tweet("Deployment of 54 Starlink satellites confirmed");

    Video video = new Video("Falcon 9 flying", 1024);
    Audio audio = new Audio("Music", 546);
    Picture picture = new Picture("New Tesla", 267);

    elonMusk.load(video);
    elonMusk.load(audio);
    elonMusk.load(picture);

    elonMusk.tweet(video);
    elonMusk.tweet(picture);

    zelensky.register(elonMusk);
    zelensky.register(new Follower("@Podolyak"));

    zelensky.tweet("Hi", elonMusk);

  }

}
