package com.yamari.idddd.application.circles;

import com.yamari.idddd.domain.models.circles.CircleId;

public class CircleFullException extends Exception {

  public CircleFullException(CircleId circleId) {
    super("�T�[�N���̏����l������𒴉߂��Ă��܂��܂��B(CircleId;" + circleId.getValue() + ")");
  }
}
