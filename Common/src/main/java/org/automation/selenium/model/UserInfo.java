package org.automation.selenium.model;

/**
 * Created by shantonu on 1/7/17.
 * represents a user
 */
public enum UserInfo {
    normal("user3", "pass"),
    admin("user1", "pass"),
    modarator("user2", "pass");

    private UserInfo(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    private String userName = "";
    private String password = "";
}
