package com.yamari.idddd.repository.inMemory.users;

import com.yamari.idddd.domain.models.users.IUserFactory;
import com.yamari.idddd.domain.models.users.MailAddress;
import com.yamari.idddd.domain.models.users.User;
import com.yamari.idddd.domain.models.users.UserId;
import com.yamari.idddd.domain.models.users.UserName;

public class InMemoryUserFactory implements IUserFactory {

  private Integer currentId;

  public InMemoryUserFactory() {
    currentId = 0;
  }

  @Override
  public User create(UserName name, MailAddress address) throws Exception {
    // ���[�U����������邽�уC���N�������g
    currentId++;
    if (currentId > 99999999) {
      throw new Exception("id�̍ő�l�𒴉߂��܂����B");
    }

    return new User(new UserId(currentId.toString()), name, address);
  }
}
