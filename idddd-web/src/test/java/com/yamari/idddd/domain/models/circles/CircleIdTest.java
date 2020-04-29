package com.yamari.idddd.domain.models.circles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.Test;

public class CircleIdTest {

  @Test
  public void testNewSuccess() {
    String input = "newId";
    CircleId targetId = new CircleId(input);

    assertThat(targetId.getValue()).as("����ɃI�u�W�F�N�g����������邱�Ƃ��m�F").isEqualTo(input);
  }

  @Test
  public void testNewFailureNull() {
    String input = null;
    assertThatThrownBy(() -> new CircleId(input))
        .as("null�͋��e���Ȃ�")
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("�T�[�N��ID�͕K�����͂��Ă��������B");
  }

  @Test
  public void testNewFailureEmpty() {
    String input = "";
    assertThatThrownBy(() -> new CircleId(input))
        .as("�󕶎���͋��e���Ȃ�")
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("�T�[�N��ID�͕K�����͂��Ă��������B");
  }
}
