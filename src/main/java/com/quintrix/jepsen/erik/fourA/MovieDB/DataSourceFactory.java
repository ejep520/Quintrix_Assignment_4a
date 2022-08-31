package com.quintrix.jepsen.erik.fourA.MovieDB;

import javax.sql.DataSource;
import com.mysql.cj.jdbc.MysqlDataSource;

class DataSourceFactory {
  public static DataSource GenerateDataSource() {
    MysqlDataSource mysqlDS;
    mysqlDS = null;
    try {
      mysqlDS = new MysqlDataSource();
      mysqlDS.setUrl("jdbc:mysql://localhost");
      mysqlDS.setUser("DBAdmin");
      mysqlDS.setPassword("admin");
    } catch (Exception e) {
      e.printStackTrace();
    }
    return mysqlDS;
  }
}
