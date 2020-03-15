package com.yamari.idddd.application.users;

import com.yamari.idddd.domain.models.users.IUserRepository;
import com.yamari.idddd.domain.models.users.User;
import com.yamari.idddd.domain.models.users.UserId;

public class UserGetInfoService {

  IUserRepository userRepository;

  public UserGetInfoService(IUserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public UserData get(String userId) {
    UserId targetId = new UserId(userId);
    User user = userRepository.find(targetId);

    // �O���Ƀh���C���I�u�W�F�N�g�����J���Ȃ��悤�A
    // DTO�ɋl�ߑւ���return����B
    // user�̃v���p�e�B���������Ă��Ή��\�B
    // TODO:�w�肵�����[�U�����݂��Ȃ��ꍇ�AUserNotFoundException��throw����B
    return (user == null) ? null : new UserData(user);
  }
}
