package com.yamari.idddd.application.users;

import com.yamari.idddd.domain.models.users.User;

public class UserData {
  private String id;
  private String name;
  private String mailAddress;

  public UserData(String id, String name, String mailAddress) {
    this.id = id;
    this.name = name;
    this.mailAddress = mailAddress;
  }

  // User�̃v���p�e�B�������Ă��A
  // ���p���ŕύX�̕K�v�������Ȃ��悤�ɂ��邽�߂̃R���X�g���N�^
  public UserData(User source) {
    this.id = source.id.getValue();
    this.name = source.name.getValue();
    this.mailAddress = source.mailAddress.getValue();
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getMailAddress() {
    return mailAddress;
  }
}
