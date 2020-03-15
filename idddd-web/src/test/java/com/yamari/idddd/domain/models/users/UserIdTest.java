package com.yamari.idddd.domain.models.users;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.Test;

public class UserIdTest {

  @Test
  public void testNewSuccess() {
    String input = "newId";
    UserId targetId = new UserId(input);

    assertThat(targetId.getValue()).as("����ɃI�u�W�F�N�g����������邱�Ƃ��m�F").isEqualTo(input);
  }

  @Test
  public void testNewFailureNull() {
    String input = null;
    assertThatThrownBy(() -> {
      new UserId(input);
    }).as("null�͋��e���Ȃ�").isInstanceOf(IllegalArgumentException.class)
        .hasMessage("���[�UID�͕K�����͂��Ă��������B");
  }

  @Test
  public void testNewFailureEmpty() {
    String input = "";
    assertThatThrownBy(() -> {
      new UserId(input);
    }).as("�󕶎���͋��e���Ȃ�").isInstanceOf(IllegalArgumentException.class)
        .hasMessage("���[�UID�͕K�����͂��Ă��������B");
  }
}
