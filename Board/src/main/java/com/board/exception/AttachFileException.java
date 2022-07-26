package com.board.exception;

public class AttachFileException extends RuntimeException{
	public AttachFileException(String message) {
		super(message);
	}

	public AttachFileException(String message, Throwable cause) {
		super(message, cause);
	}
}//파일 처리 exception
