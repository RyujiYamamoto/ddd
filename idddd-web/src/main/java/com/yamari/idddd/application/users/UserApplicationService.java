package com.yamari.idddd.application.users;

import com.yamari.idddd.domain.models.users.IUserRepository;
import com.yamari.idddd.domain.models.users.User;
import com.yamari.idddd.domain.models.users.UserId;
import com.yamari.idddd.domain.models.users.UserName;
import com.yamari.idddd.domain.services.UserService;

public class UserApplicationService {

  private IUserRepository userRepository;
  private UserService userService;

  public UserApplicationService(IUserRepository userRepository, UserService userService) {
    this.userRepository = userRepository;
    this.userService = userService;
  }

  public void register(String userName) throws Exception {
    User user = new User(new UserName(userName));

    if (userService.exists(user)) {
      throw new Exception(userName + "�͊��ɑ��݂��Ă��܂��B");
    }

    userRepository.save(user);
  }

  public UserData get(String userId) {
    UserId targetId = new UserId(userId);
    User user = userRepository.find(targetId);

    // �O���Ƀh���C���I�u�W�F�N�g�����J���Ȃ��悤�A
    // DTO�ɋl�ߑւ���return����B
    // user�̃v���p�e�B���������Ă��Ή��\�B
    return (user == null) ? null : new UserData(user);
  }
}
