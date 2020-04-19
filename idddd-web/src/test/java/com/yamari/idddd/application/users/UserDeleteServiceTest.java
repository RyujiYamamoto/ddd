package com.yamari.idddd.application.users;

import com.yamari.idddd.domain.models.users.MailAddress;
import com.yamari.idddd.domain.models.users.User;
import com.yamari.idddd.domain.models.users.UserId;
import com.yamari.idddd.domain.models.users.UserName;
import com.yamari.idddd.repository.inMemory.InMemoryUserRepository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class UserDeleteServiceTest {

  private InMemoryUserRepository userRepository = new InMemoryUserRepository();

  public UserDeleteService targetService = new UserDeleteService(userRepository);

  @Before
  public void initializeRepository() {
    userRepository.store.clear();
    // DB�ɑ��݂��郆�[�U��ݒ�
    UserId existsId = new UserId("000000");
    UserName existsName = new UserName("exists");
    User existsUser = new User(existsId, existsName, new MailAddress("exists@example.com"));
    userRepository.store.put(existsId, existsUser);
  }

  @Test
  public void testDeleteWithExistingUser() {
    String targetUserId = "000000";
    UserDeleteCommand command = new UserDeleteCommand(targetUserId);

    targetService.handle(command);

    // �폜���������Ă��邱�Ƃ��m�F�B
    Assertions.assertThat(userRepository.store.get(new UserId(targetUserId))).isNull();
  }

  @Test
  public void testDeleteWithAbsentUser() {
    String targetUserId = "999999";
    UserDeleteCommand command = new UserDeleteCommand(targetUserId);

    targetService.handle(command);

    // �폜������Ă��Ȃ����Ƃ��m�F
    Assertions.assertThat(userRepository.store.get(new UserId(targetUserId))).isNull();
    User existsUser = userRepository.store.get(new UserId("000000"));
    Assertions.assertThat(existsUser).isNotNull();
  }
}
