package com.yamari.idddd.domain.models.users;

import java.util.Objects;

public class User {
  public final UserId id;
  public UserName name;
  public MailAddress mailAddress;

  public User(UserId id, UserName name, MailAddress mailAddress) {
    if (id == null) {
      throw new IllegalArgumentException("id�͕K�����͂��Ă��������B");
    }

    this.id = id;
    this.changeName(name);
    this.changeMailAddress(mailAddress);
  }

  public void changeName(UserName name) {
    if (name == null) {
      throw new IllegalArgumentException("name�͕K�����͂��Ă��������B");
    }
    this.name = name;
  }

  public void changeMailAddress(MailAddress mailAddress) {
    if (mailAddress == null) {
      throw new IllegalArgumentException("mailAddress�͕K�����͂��Ă��������B");
    }
    this.mailAddress = mailAddress;
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
    if (!(obj instanceof User)) {
      return false;
    }

    User other = (User) obj;
    return Objects.equals(id.getValue(), other.id.getValue());
  }
}
