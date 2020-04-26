package com.yamari.idddd.application.users;

import com.yamari.idddd.domain.models.users.IUserRepository;
import com.yamari.idddd.domain.models.users.User;
import com.yamari.idddd.domain.models.users.UserId;
import org.springframework.transaction.annotation.Transactional;

public class UserDeleteService {

  IUserRepository userRepository;

  public UserDeleteService(IUserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Transactional
  public void handle(UserDeleteCommand command) {
    UserId targetId = new UserId(command.getId());
    User user = userRepository.find(targetId);

    if (user == null) {
      // �폜�Ώۂ̃��[�U��������Ȃ��ꍇ�͑މ���Ƃ���
      return;
    }

    userRepository.delete(user);
  }
}
