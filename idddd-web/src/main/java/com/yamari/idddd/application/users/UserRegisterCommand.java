package com.yamari.idddd.application.users;

public class UserRegisterCommand {

  // �쐬���郆�[�U�̖��O�E���[���A�h���X�̓R���X�g���N�^�ł̂ݎw��\
  public UserRegisterCommand(String name, String mailAddress) {
    this.name = name;
    this.mailAddress = mailAddress;
  }

  private String name;
  private String mailAddress;

  String getName() {
    return this.name;
  }

  String getMailAddress() {
    return this.mailAddress;
  }
}
