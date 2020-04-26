package com.yamari.idddd.domain.models.users;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.Test;

public class UserNameTest {
  @Test
  public void successWithThreeCharacters() {
    String input = "123";
    UserName targetName = new UserName(input);

    assertThat(targetName.getValue()).as("3�����̃��[�U���͋��e").isEqualTo(input);
  }

  @Test
  public void successWith20Characters() {
    String input = "12345678901234567890";
    UserName targetName = new UserName(input);

    assertThat(targetName.getValue()).as("20�����̃��[�U���͋��e").isEqualTo(input);
  }

  @Test
  public void failureWithNull() {
    String input = null;
    assertThatThrownBy(() -> new UserName(input))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage(("���[�U���͕K�����͂��Ă��������B"));
  }

  @Test
  public void failureWithTwoCharacters() {
    String input = "12";
    assertThatThrownBy(() -> new UserName(input))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("���[�U����3�����ȏ�ł��B");
  }

  @Test
  public void failureWith21Characters() {
    String input = "123456789012345678901";
    assertThatThrownBy(() -> new UserName(input))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("���[�U����20�����ȉ��ł��B");
  }
}
