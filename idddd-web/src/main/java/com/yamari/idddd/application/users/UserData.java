package com.yamari.idddd.application.users;

import com.yamari.idddd.domain.models.users.User;

public class UserData {
  private String id;
  private String name;

  public UserData(String id, String name) {
    this.id = id;
    this.name = name;
  }

  // User�̃v���p�e�B�������Ă��A
  // ���p���ŕύX�̕K�v�������Ȃ��悤�ɂ��邽�߂̃R���X�g���N�^
  public UserData(User source) {
    this.id = source.id.getValue();
    this.name = source.name.getValue();
  }

  protected String getId() {
    return id;
  }

  protected String getName() {
    return name;
  }
}
