package com.yamari.idddd.application.users;

import com.yamari.idddd.domain.models.users.IUserRepository;
import com.yamari.idddd.domain.models.users.User;
import com.yamari.idddd.domain.models.users.UserId;

public class UserGetInfoService {

  IUserRepository userRepository;

  public UserGetInfoService(IUserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public UserData handle(UserGetCommand command) throws UserNotFoundException {
    UserId targetId = new UserId(command.getId());
    User user = userRepository.find(targetId);

    if (user == null) {
      throw new UserNotFoundException(targetId);
    }

    // �O���Ƀh���C���I�u�W�F�N�g�����J���Ȃ��悤�A
    // DTO�ɋl�ߑւ���return����B
    // user�̃v���p�e�B���������Ă��Ή��\�B
    return new UserData(user);
  }
}
