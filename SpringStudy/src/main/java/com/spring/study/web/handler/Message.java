package com.spring.study.web.handler;

import lombok.Data;

@Data
public class Message<T> {
	private int code;
	private T data;
}
