package com.spring.di;

public class AirConditionerRemoteControl implements RemoteControl {

	private String company;
	
	public AirConditionerRemoteControl() {}
	
	public AirConditionerRemoteControl(String company) {
		super();
		this.company = company;
	}

	@Override
	public void on() {
		System.out.println(company + " 에어컨의 전원을 켭니다");
	}

	@Override
	public void off() {
		System.out.println(company + " 에어컨의 전원을 끕니다");
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

}
