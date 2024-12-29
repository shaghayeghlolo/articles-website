package org.example.dao;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

//import org.springframework.core.SpringVersion;
public class DbConnectionProvider {
    //
//    ip
//    db connection provider



    public static void main(String[] args) {
        Connection connection = null;

        try{
            FileInputStream fileInputStream =
                    new FileInputStream("src/main/resources/application.properties");

            Properties properties = new Properties();
            properties.load(fileInputStream);
            properties.list(System.out);
            String DataBaseUrl = properties.getProperty("spring.datasource.url");
            String DataBaseUsername = properties.getProperty("spring.datasource.username");
            String DataBasePassword = properties.getProperty("spring.datasource.password");
            connection = DriverManager.getConnection(
                    DataBaseUrl, DataBaseUsername,DataBasePassword);


            Statement statement;
            statement = connection.createStatement();
            ResultSet resultSet;
            String query = "select  * from article";
            resultSet = statement.executeQuery(query);
            System.out.println(resultSet);

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String brief = resultSet.getString("brief");
                String content = resultSet.getString("content");
                Timestamp createDate = resultSet.getTimestamp("createDate");
                boolean isPublished = resultSet.getBoolean("isPublished");
                Timestamp lastUpdateDate = resultSet.getTimestamp("lastUpdateDate");
                Timestamp publishDate = resultSet.getTimestamp("publishDate");
                System.out.println("title = " + title);
            }



            resultSet.close();
            statement.close();
            connection.close();

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
