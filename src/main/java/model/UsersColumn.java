package model;

public enum UsersColumn {
    ID("id"),
    EMAIL("email"),
    PASS("password"),
    FULLNAME("fullname"),
    AVATAR("avatar"),
    ROLE_ID("role_id");

    private String value;

    UsersColumn(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
