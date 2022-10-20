package ua.hillelit.lms.entity;

import java.util.ArrayList;
import java.util.List;
import ua.hillelit.lms.entity.media.Media;

public class Load<T extends Media> {

  private final List<T> medias = new ArrayList<>();

  public void add(T media) {
    medias.add(media);
  }

}
