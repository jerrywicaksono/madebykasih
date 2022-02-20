package com.made.by.kasih.madebykasih.enumerator;

public enum ErrorCodeEnum {
	/**
	 * MBK-1000-1999: General
	 * MBK-2000-2999: Business Process
	 * MBK-3000-3999: Business Process
	 * MBK-4000-4999: Business Process
	 * MBK-5000-5999: Business Process
	 * MBK-6000-6999: Database
	 * MBK-7000-7999: Hardware
	 * MBK-8000-8999: Integration
	 * MBK-9000-9999: Other
	 */

	SUCCESS("1000", "Berhasil."),

	DATA_NOT_FOUND("2000", "Data Tidak Ditemukan."),
	DATA_ALREADY_EXIST("2001", "Data Sudah Ada.");

	private String code;
	private String defaultMsg;

	private ErrorCodeEnum(String code, String defaultMsg) {
		this.code = code;
		this.defaultMsg = defaultMsg;
	}

	public final String getCode() {
		return code;
	}

	public String getDefaultMsg() {
		return defaultMsg;
	}

	public void setDefaultMsg(final String defaultMsg) {
		this.defaultMsg = defaultMsg;
	}

	public String getFullMsg() {
		return code + " : " + defaultMsg;
	}
}