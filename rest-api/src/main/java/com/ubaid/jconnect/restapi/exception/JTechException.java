package com.ubaid.jconnect.restapi.exception;

public class JTechException extends RuntimeException
{
	private static final long serialVersionUID = -6675390008634823952L;

	public JTechException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public JTechException(String message)
	{
		super(message);
	}

	public JTechException(Throwable cause)
	{
		super(cause);
	}

	
}