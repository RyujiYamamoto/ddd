package com.yamari.idddd.domain.models.circles;

import java.util.Objects;

public class CircleName {

  private String value;

  public CircleName(String value) {
    if (value == null) {
      throw new IllegalArgumentException("�T�[�N�����͕K�����͂��Ă��������B");
    }
    if (value.length() < 3) {
      throw new IllegalArgumentException("�T�[�N������3�����ȏ�ł��B");
    }
    if (value.length() > 20) {
      throw new IllegalArgumentException("�T�[�N������20�����ȉ��ł��B");
    }
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CircleName circleName = (CircleName) o;
    return value.equals(circleName.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
}
