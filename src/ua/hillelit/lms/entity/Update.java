package ua.hillelit.lms.entity;

public class Update<T> {

  private final T data;

  public Update(T data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return data.toString();
  }

  public T getData() {
    return data;
  }

}
