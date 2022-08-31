package com.quintrix.jepsen.erik.fourA.MovieDB;

public class AddMovieReply {
  private boolean addedOK;
  private String reason;

  public AddMovieReply(boolean addedOK, String reason) {
    this.addedOK = addedOK;
    if (reason == null || reason.isEmpty())
      this.reason = null;
    else
      this.reason = reason;
  }

  public boolean wasAddedOK() {
    return addedOK;
  }

  public String getReason() {
    if (reason == null)
      return "No reason given.";
    return reason;
  }
}
