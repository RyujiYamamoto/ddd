package com.yamari.idddd.domain.models.users;

public class UserName {
	private String value;
	
	public UserName(String value) {
		if (value == null) {
			throw new IllegalArgumentException("���[�U���͕K�����͂��Ă��������B");
		} 
		if (value.length() < 3) {
			throw new IllegalArgumentException("���[�U����3�����ȏ�ł��B");			
		}
		if (value.length() > 20) {
			throw new IllegalArgumentException("���[�U����20�����ȉ��ł��B");			
		}
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
