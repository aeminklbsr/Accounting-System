package com.muhasebe.model;

public class UserRole implements Role {

    @Override
    public String getRole() {
        return "USER";
    }
}
