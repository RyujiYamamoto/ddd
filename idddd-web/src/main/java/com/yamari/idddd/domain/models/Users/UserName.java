package com.yamari.idddd.domain.models.Users;

class UserName {
	private String value;
	
	public UserName(String value) {
		if (value == null) {
			throw new IllegalArgumentException("���[�U���͕K�����͂��Ă��������B");
		} 
		if (value.length() < 3) {
			throw new IllegalArgumentException("���[�U����3�����ȏ�ł��B");			
		}
		this.value = value;
	}
}
