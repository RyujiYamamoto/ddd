package com.yamari.idddd.domain.services;

import com.yamari.idddd.domain.models.users.IUserRepository;
import com.yamari.idddd.domain.models.users.User;

public class UserService {

  private IUserRepository userRepository;

  public UserService(IUserRepository userRepository) {
    this.userRepository = userRepository;
  }

  /**
   * ���[�U�̏d���m�F���s���B
   *
   * @param user
   * @return �d�����Ă����true, �d�����Ă��Ȃ����false
   */
  public boolean exists(User user) {
    User found = userRepository.find(user.name);

    return found != null;
  }
}
