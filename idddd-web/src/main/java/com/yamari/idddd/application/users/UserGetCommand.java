package com.yamari.idddd.application.users;

public class UserGetCommand {

  // �擾�Ώۂ̃��[�UID�̓R���X�g���N�^�ł̂ݎw��\�B
  public UserGetCommand(String id) {
    this.id = id;
  }

  private String id;

  public String getId() {
    return this.id;
  }
}
