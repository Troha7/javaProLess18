package ua.hillelit.lms.entity.media;

public abstract class Media {

  private final String name;
  private final long size;

  public Media(String name, long size) {
    this.name = name;
    this.size = size;
  }

  public String getName() {
    return name;
  }

  public long getSize() {
    return size;
  }

  @Override
  public String toString() {
    return getClass().getSimpleName() + "{" + getName() + "}";
  }
}
