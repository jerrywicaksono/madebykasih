package com.made.by.kasih.madebykasih.enumerator;

import java.util.HashMap;
import java.util.Map;

public enum MbkColorEnum {

	PUTIH(0, "PUTIH"), 
	MERAH(1, "MERAH"),
	UNGU(2, "UNGU"),
	BIRU(3, "BIRU"), 
	HIJAU(4, "HIJAU");
	
	private int key;
	private String value;
	
	private MbkColorEnum(int key, String value) {
		this.key = key;
		this.value = value;
	}

	public int getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

	private static final Map<String, MbkColorEnum> lookup = new HashMap<String, MbkColorEnum>();
    static {
        for (MbkColorEnum d : MbkColorEnum.values())
            lookup.put(d.getValue(), d);
    }
    
    public static MbkColorEnum get(String type) {
        return lookup.get(type);
    }
}