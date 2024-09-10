package com.example.appeventos.ENUM;

public enum DEFAULT_VALUES {

    USUARIO_DEFAULT_VALUE("admin"),
    SENHA_DEFAULT_VALUE("123");

    public String value;

    DEFAULT_VALUES(String value) {
        this.value = value;
    }
}
