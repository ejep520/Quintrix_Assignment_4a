package com.quintrix.jepsen.erik.fourA.DBObjects;

public class Review {
  public int getReviewId() {
    return reviewId;
  }

  public void setReviewId(int reviewId) {
    this.reviewId = reviewId;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public int getMovieId() {
    return movieId;
  }

  public void setMovieId(int movieId) {
    this.movieId = movieId;
  }

  public int getStarVal() {
    return starVal;
  }

  public void setStarVal(int starVal) {
    this.starVal = starVal;
  }

  private int reviewId, userId, movieId, starVal;
}
