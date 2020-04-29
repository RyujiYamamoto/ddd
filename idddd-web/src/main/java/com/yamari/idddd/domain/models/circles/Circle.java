package com.yamari.idddd.domain.models.circles;

import com.yamari.idddd.domain.models.users.User;
import java.util.List;
import java.util.Objects;

public class Circle {

  public final CircleId id;
  public CircleName name;
  public User owner;
  public List<User> members;

  public Circle(
      CircleId id,
      CircleName name,
      User owner,
      List<User> members) {
    if (id == null) {
      throw new IllegalArgumentException("id�͕K�����͂��Ă��������B");
    }
    if (name == null) {
      throw new IllegalArgumentException("name�͕K�����͂��Ă��������B");
    }
    if (owner == null) {
      throw new IllegalArgumentException("owner�͕K�����͂��Ă��������B");
    }
    if (members == null) {
      throw new IllegalArgumentException("members�͕K�����͂��Ă��������B");
    }

    this.id = id;
    this.name = name;
    this.owner = owner;
    this.members = members;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof Circle)) {
      return false;
    }

    Circle other = (Circle) obj;
    return Objects.equals(id.getValue(), other.id.getValue());
  }
}
