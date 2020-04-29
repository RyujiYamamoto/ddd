package com.yamari.idddd.domain.services;

import com.yamari.idddd.domain.models.circles.Circle;
import com.yamari.idddd.domain.models.circles.ICircleRepository;

public class CircleService {

  private final ICircleRepository circleRepository;

  public CircleService(ICircleRepository circleRepository) {
    this.circleRepository = circleRepository;
  }

  /**
   * �T�[�N���̏d���m�F���s���B
   *
   * @param circle �d���m�F������T�[�N��
   * @return �d�����Ă����true, �d�����Ă��Ȃ����false
   */
  public boolean exists(Circle circle) {
    Circle found = circleRepository.find(circle.name);
    return found != null;
  }
}
