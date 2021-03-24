package com.java.spring.starterweb.model;

public class UserDetail {
    private String username;
    private ROLE role;
    
    public enum ROLE{
        ADMIN("admin"),USER("user");

        private final String val;
        
        ROLE(final String val){
            this.val = val;
        }

        @Override
        public String toString(){
            return val;
        }
    }

    public UserDetail() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ROLE getRole() {
        return role;
    }

    public void setRole(ROLE role) {
        this.role = role;
    }

    public UserDetail(String username, ROLE role) {
        this.username = username;
        this.role = role;
    }
}
