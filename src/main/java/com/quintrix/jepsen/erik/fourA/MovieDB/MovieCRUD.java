package com.quintrix.jepsen.erik.fourA.MovieDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import com.mysql.cj.jdbc.JdbcStatement;
import com.quintrix.jepsen.erik.fourA.DBObjects.Movie;
import com.quintrix.jepsen.erik.fourA.DBObjects.User;

class MovieCRUD {
  public AddMovieReply CreateMovie(User user, Movie movie, JdbcStatement stmt) throws SQLException {
    final String INSUFF_PRIV_ERR = "Insufficient Privilege Level.";
    final String MOVIE_ALREADY_EXISTS = "This movie was already in the database.";
    if (user.getPrivilegeLevel() < 2)
      return new AddMovieReply(false, INSUFF_PRIV_ERR);
    List<Movie> similarMovies = new ArrayList<>();
    stmt.clearAttributes();
    stmt.setAttribute("title", movie.getTitle());
    ResultSet rs = stmt.executeQuery(
        "SELECT * FROM movies WHERE movies.title LIKE mysql_query_attribute_string('title');");
    while (rs.next()) {
      Movie newMovie = new Movie(rs.getString("title"));
      newMovie.setDirector(rs.getString("director"));
      newMovie.setMovieId(rs.getInt("movieId"));
      newMovie.setProducer(rs.getString("producer"));
      newMovie.setReleaseYear(rs.getInt("year"));
      newMovie.setStar(rs.getString("star"));
      similarMovies.add(newMovie);
    }
    rs.close();
    if (similarMovies.size() > 0) {
      if (SimilarOkay(movie, similarMovies))
        return new AddMovieReply(false, MOVIE_ALREADY_EXISTS);
    }
    stmt.clearAttributes();
    stmt.setAttribute("title", movie.getTitle());
    stmt.setAttribute("director", movie.getDirector());
    stmt.setAttribute("producer", movie.getProducer());
    stmt.setAttribute("year", movie.getReleaseYear());
    stmt.setAttribute("star", movie.getStar());
    stmt.setAttribute("addedBy", user.getUserId());
    stmt.setAttribute("addedTime", ZonedDateTime.now(ZoneId.of("UTC")));
    int recordCount = stmt.executeUpdate("INSERT INTO movies"
        + " (title, director, producer, year, star, addedBy, addedTime) VALUES "
        + "(mysql_query_attribute_string('title'), mysql_query_attribute_string('director'), "
        + "mysql_query_attribute_string('producer'), mysql_query_attribute_long('year'), "
        + "mysql_query_attribute_string('star'), mysql_query_attribute_long('addedBy'), "
        + "mysql_query_attribute_timestamp('addedTime');");
    if (recordCount == 1)
      return new AddMovieReply(true, null);
    else
      return new AddMovieReply(false, "Insertion into the database failed.");
  }

  private boolean SimilarOkay(Movie movie, List<Movie> similars) {
    return true;
  }

  public Movie ReadMovie(int movieId, JdbcStatement stmt) throws SQLException {
    Movie returnValue;
    stmt.clearAttributes();
    stmt.setAttribute("movieId", movieId);
    ResultSet rs = stmt.executeQuery(
        "SELECT * FROM movies WHERE movies.movieId = mysql_query_attribute_long('movieId');");
    if (!rs.next())
      return null;
    returnValue = new Movie(rs.getString("title"));
    returnValue.setDirector(rs.getString("director"));
    returnValue.setProducer(rs.getString("producer"));
    returnValue.setReleaseYear(rs.getInt("year"));
    returnValue.setStar(rs.getString("star"));
    returnValue.setAddedByUserId(rs.getInt("addedBy"));
    returnValue.setMovieId(rs.getInt("movieId"));
    returnValue.setLastEditedByUserId(rs.getInt("lastEdit"));
    return returnValue;
  }


}
