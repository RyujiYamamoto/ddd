package com.yamari.idddd.application.users;

import com.yamari.idddd.domain.models.users.IUserRepository;
import com.yamari.idddd.domain.models.users.MailAddress;
import com.yamari.idddd.domain.models.users.User;
import com.yamari.idddd.domain.models.users.UserName;
import com.yamari.idddd.domain.services.UserService;

public class UserRegisterService {

  private IUserRepository userRepository;
  private UserService userService;

  public UserRegisterService(IUserRepository userRepository, UserService userService) {
    this.userRepository = userRepository;
    this.userService = userService;
  }

  public void register(String userName, String mailAddress) throws CannotResisterUserException {
    // TODO: User�̕ύX��ApplicationService�ɉe�����Ȃ��悤�ɂ������B��UserRegisterCommand���쐬����B
    User user = new User(new UserName(userName), new MailAddress(mailAddress));

    if (userService.exists(user)) {
      throw new CannotResisterUserException(user, "���[�U�͊��ɑ��݂��Ă��܂��B");
    }

    userRepository.save(user);
  }
}
