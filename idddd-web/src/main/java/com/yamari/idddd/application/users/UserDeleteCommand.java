package com.yamari.idddd.application.users;

public class UserDeleteCommand {

  // �폜�Ώۂ̃��[�UID�̓R���X�g���N�^�ł̂ݎw��\�B
  public UserDeleteCommand(String id) {
    this.id = id;
  }

  private String id;

  public String getId() {
    return this.id;
  }
}
