package com.quintrix.jepsen.erik.fourA.DBObjects;

import java.time.ZonedDateTime;

public class User {
  private int userId, privilegeLevel;
  private String userName, emailAddress, passwordHash;
  private ZonedDateTime lastAccessed, created;
  private String[] reviews;

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getEmailAddress() {
    return emailAddress;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public String getPasswordHash() {
    return passwordHash;
  }

  public void setPasswordHash(String passwordHash) {
    this.passwordHash = passwordHash;
  }

  public ZonedDateTime getLastAccessed() {
    return lastAccessed;
  }

  public void setLastAccessed(ZonedDateTime lastAccessed) {
    this.lastAccessed = lastAccessed;
  }

  public ZonedDateTime getCreated() {
    return created;
  }

  public void setCreated(ZonedDateTime created) {
    this.created = created;
  }

  public String[] getReviews() {
    return reviews;
  }

  public void setReviews(String[] reviews) {
    this.reviews = reviews;
  }

  public int getPrivilegeLevel() {
    return privilegeLevel;
  }

  public void setPrivilegeLevel(int privilegeLevel) {
    this.privilegeLevel = privilegeLevel;
  }
}
