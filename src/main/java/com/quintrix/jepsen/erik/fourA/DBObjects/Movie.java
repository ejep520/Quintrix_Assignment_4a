package com.quintrix.jepsen.erik.fourA.DBObjects;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class Movie {
  private int releaseYear, movieId, addedByUserId, lastEditedByUserId;
  private String title, director, producer, star;
  private ZonedDateTime addedTime, editedTime;

  public Movie(String title) {
    this.title = title;
  }

  public int getAddedByUserId() {
    return addedByUserId;
  }

  public void setAddedByUserId(int addedByUserId) {
    this.addedByUserId = addedByUserId;
  }

  public int getReleaseYear() {
    return releaseYear;
  }

  public void setReleaseYear(int releaseYear) {
    this.releaseYear = releaseYear;
  }

  public int getMovieId() {
    return movieId;
  }

  public void setMovieId(int movieId) {
    this.movieId = movieId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDirector() {
    return director;
  }

  public void setDirector(String director) {
    this.director = director;
  }

  public String getProducer() {
    return producer;
  }

  public void setProducer(String producer) {
    this.producer = producer;
  }

  public String getStar() {
    return star;
  }

  public void setStar(String star) {
    this.star = star;
  }

  public int getLastEditedByUserId() {
    return lastEditedByUserId;
  }

  public void setLastEditedByUserId(int lastEditedByUserId) {
    this.lastEditedByUserId = lastEditedByUserId;
  }

  public ZonedDateTime getAddedTime() {
    return addedTime;
  }

  public void setAddedTime(ZonedDateTime addedTime) {
    this.addedTime = addedTime;
  }

  public ZonedDateTime getEditedTime() {
    return editedTime;
  }

  public void setEditedTime(ZonedDateTime editedTime) {
    this.editedTime = editedTime;
  }

  public void setEditedTime(Date editedTime) {
    this.editedTime = ZonedDateTime.ofInstant(editedTime.toInstant(), ZoneId.of("UTC"));
  }
}
