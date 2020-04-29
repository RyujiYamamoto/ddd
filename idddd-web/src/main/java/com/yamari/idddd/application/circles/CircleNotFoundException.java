package com.yamari.idddd.application.circles;

import com.yamari.idddd.domain.models.circles.CircleId;

public class CircleNotFoundException extends Exception {

  public CircleNotFoundException(CircleId circleId) {
    super("�T�[�N����������܂���ł����B(circleId:" + circleId.getValue() + ")");
  }
}
