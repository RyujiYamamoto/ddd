package com.yamari.idddd.domain.models.users;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.Test;

public class MailAddressTest {

  @Test
  public void successWithAddress() {
    String input = "test@example.com";
    MailAddress target = new MailAddress(input);

    assertThat(target.getValue()).isEqualTo(input);
  }

  @Test
  public void failureWithNull() {
    String input = null;

    assertThatThrownBy(() -> new MailAddress(input))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("���[���A�h���X�͕K�����͂��Ă��������B");
  }

  @Test
  public void failureWithEmptyLocalPart() {
    String input = "@example.com";

    assertThatThrownBy(() -> new MailAddress(input))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("�s���ȃ��[���A�h���X�ł��B");
  }

  @Test
  public void failureWithIllegalDomain_1() {
    String input = "aaa@.domain";

    assertThatThrownBy(() -> new MailAddress(input))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("�s���ȃ��[���A�h���X�ł��B");
  }

  @Test
  public void failureWithIllegalDomain_2() {
    String input = "aaa@domain.";

    assertThatThrownBy(() -> new MailAddress(input))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("�s���ȃ��[���A�h���X�ł��B");
  }
}
