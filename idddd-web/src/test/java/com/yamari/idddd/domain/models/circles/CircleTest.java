package com.yamari.idddd.domain.models.circles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.yamari.idddd.domain.models.users.MailAddress;
import com.yamari.idddd.domain.models.users.User;
import com.yamari.idddd.domain.models.users.UserId;
import com.yamari.idddd.domain.models.users.UserName;
import java.util.ArrayList;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

public class CircleTest {

  private CircleId id = new CircleId("target");
  private CircleName name = new CircleName("targetName");
  private MailAddress address = new MailAddress("target@example.com");

  private User owner =
      new User(
          new UserId("owner"), new UserName("ownerName"), new MailAddress("owner@example.com"));
  private User member =
      new User(
          new UserId("member"), new UserName("memberName"), new MailAddress("member@example.com"));

  @Test
  public void successWithNonNullArguments() {
    ArrayList<User> members = new ArrayList<>();
    members.add(member);
    Circle target = new Circle(id, name, owner, members);

    assertThat(target.id).isEqualTo(id);
    assertThat(target.name).isEqualTo(name);
    assertThat(target.owner).isEqualTo(owner);
    assertThat(target.members).isInstanceOf(ArrayList.class);
    assertThat(target.members.get(0)).isEqualTo(member);
  }

  @Test
  public void failureWithNullId() {
    assertThatThrownBy(() -> new Circle(null, name, owner, new ArrayList<>()))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("id�͕K�����͂��Ă��������B");
  }

  @Test
  public void failureWithNullName() {
    assertThatThrownBy(() -> new Circle(id, null, owner, new ArrayList<>()))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("name�͕K�����͂��Ă��������B");
  }

  @Test
  public void failureWithNullOwner() {
    assertThatThrownBy(() -> new Circle(id, name, null, new ArrayList<>()))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("owner�͕K�����͂��Ă��������B");
  }

  @Test
  public void failureWithNullMembers() {
    assertThatThrownBy(() -> new Circle(id, name, owner, null))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("members�͕K�����͂��Ă��������B");
  }

  @Test
  public void testEquals() {
    SoftAssertions softly = new SoftAssertions();

    Circle target = new Circle(id, name, owner, new ArrayList<>());

    softly.assertThat(target.equals(target)).as("���g�Ɣ�r�����true").isTrue();
    softly.assertThat(target.equals(null)).as("null�Ɣ�r�����false").isFalse();
    softly.assertThat(target.equals(address)).as("���N���X�Ɣ�r�����false").isFalse();

    Circle sameIdCircle =
        new Circle(
            new CircleId("target"), new CircleName("different"), owner, new ArrayList<User>());

    softly.assertThat(target.equals(sameIdCircle)).as("����CircleId�̏ꍇ��true").isTrue();

    Circle differentIdCircle =
        new Circle(new CircleId("target" + "diff"), name, owner, new ArrayList<>());
    softly.assertThat(target.equals(differentIdCircle)).as("�قȂ�UserId�̏ꍇ��false").isFalse();

    softly.assertAll();
  }
}
