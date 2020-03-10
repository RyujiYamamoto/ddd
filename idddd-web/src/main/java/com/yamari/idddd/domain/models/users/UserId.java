package com.yamari.idddd.domain.models.users;

public class UserId {

  private String value;

  public UserId(String value) {
    if (value == null || value.length() == 0) {
      throw new IllegalArgumentException("���[�UID�͕K�����͂��Ă��������B");
    }
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
