package com.spring.myapp.exception;

public class ApplicationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String errCode;
	private final String errDescription;

	public static final String EXCEPTION_DATA_NOT_FOUND = "exception.data.notFound";

	public ApplicationException(final String errCode, final String errDescription) {
		super(errDescription);
		this.errCode = errCode;
		this.errDescription = errDescription;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[errCode=").append(errCode).append(", errDescription=").append(errDescription)
				.append(", detailedMessage=").append(getMessage()).append("]");
		return builder.toString();
		// return "ApplicationException [errCode=" + errCode + ",
		// errDescription=" + errDescription + "]";
	}

}
