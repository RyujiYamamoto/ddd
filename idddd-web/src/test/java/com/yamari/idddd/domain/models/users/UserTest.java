package com.yamari.idddd.domain.models.users;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

public class UserTest {

  public User testTarget =
      new User(new UserId("000000"), new UserName("test"), new MailAddress("test@example.com"));

  @Test
  public void successWithIdAndNameAndMailAddress() {
    UserId id = new UserId("testId");
    UserName name = new UserName("testName");
    MailAddress address = new MailAddress("test@example.com");
    User target = new User(id, name, address);

    assertThat(target.id).isEqualTo(id);
    assertThat(target.name).isEqualTo(name);
    assertThat(target.mailAddress).isEqualTo(address);
  }

  @Test
  public void failureWithNullId() {
    UserId id = null;
    UserName name = new UserName("testName");
    MailAddress address = new MailAddress("test@example.com");
    assertThatThrownBy(() -> new User(id, name, address))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("id�͕K�����͂��Ă��������B");
  }

  @Test
  public void successChangeName() {
    UserName changedName = new UserName("test_changed");
    testTarget.changeName(changedName);

    assertThat(testTarget.name).isEqualTo(changedName);
  }

  @Test
  public void failureChangeName() {
    UserName changedName = null;
    assertThatThrownBy(() -> testTarget.changeName(changedName))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("name�͕K�����͂��Ă��������B");
  }

  @Test
  public void successChangeMailAddress() {
    MailAddress changedAddress = new MailAddress("testchanged@example.com");
    testTarget.changeMailAddress(changedAddress);

    assertThat(testTarget.mailAddress).isEqualTo(changedAddress);
  }

  @Test
  public void failureChangeMailAddress() {
    MailAddress changedAddress = null;
    assertThatThrownBy(() -> testTarget.changeMailAddress(changedAddress))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("mailAddress�͕K�����͂��Ă��������B");
  }

  @Test
  public void testEquals() {
    SoftAssertions softly = new SoftAssertions();

    UserName name = new UserName("test");
    MailAddress address = new MailAddress("test@example.com");
    User target = new User(new UserId("000000"), name, address);

    softly.assertThat(target.equals(target)).as("���g�Ɣ�r�����true").isTrue();
    softly.assertThat(target.equals(null)).as("null�Ɣ�r�����false").isFalse();
    softly.assertThat(target.equals(address)).as("���N���X�Ɣ�r�����false").isFalse();

    User sameIdUser =
        new User(
            new UserId(target.id.getValue()),
            new UserName("sameId"),
            new MailAddress("sameid@example.com"));

    softly.assertThat(target.equals(sameIdUser)).as("����UserId�̏ꍇ��true").isTrue();

    User differentIdUser =
        new User(
            new UserId(target.id.getValue() + "diff"),
            new UserName("diff"),
            new MailAddress("diff@example.com"));
    softly.assertThat(target.equals(differentIdUser)).as("�قȂ�UserId�̏ꍇ��false").isFalse();

    softly.assertAll();
  }
}
