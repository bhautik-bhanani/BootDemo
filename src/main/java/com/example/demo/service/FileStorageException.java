package com.example.demo.service;

@SuppressWarnings("serial")
public class FileStorageException extends RuntimeException{
	public FileStorageException(String msg) {
		super(msg);
	}
	
	public FileStorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
