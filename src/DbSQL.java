import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DbSQL {
    private Connection connection;
    private Statement statement;

    DbSQL() {
        connection = null;
        statement = null;
        try {
            String url = "jdbc:sqlite:C:/sqlite/nogetno.db";
            connection = DriverManager.getConnection(url);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void opretTabelStuderende() {
        try {
            String sql = "CREATE TABLE if not exists studerende("
                    + "stdnr integer PRIMARY KEY,"
                    + "fnavn TEXT NOT NULL,"
                    + "enavn TEXT NOT NULL,"
                    + "adresse TEXT NOT NULL,"
                    + "postnr TEXT NOT NULL,"
                    + "mobil TEXT NOT NULL,"
                    + "klasse TEXT NOT NULL"
                    + ");";
            statement = connection.createStatement();
            statement.execute(sql);
            System.out.println("Connection to SQLite has been established.");
            statement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void opretTabelFag() {
        try {
            String sql = "CREATE TABLE if not exists fag("
                    + "fagNr integer PRIMARY KEY,"
                    + "fagNavn TEXT NOT NULL"
                    + ");";
            statement = connection.createStatement();
            statement.execute(sql);
            System.out.println("Connection to SQLite has been established.");
            statement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void opretTabelStudfag() {
        try {
            String sql = "CREATE TABLE if not exists studfag("
                    + "stdNr integer PRIMARY KEY,"
                    + "fagNr integer NOT NULL"
                    +");";
            statement = connection.createStatement();
            statement.execute(sql);
            System.out.println("Connection to SQLite has been established.");
            statement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    //Indsætter Sql data ind i Studerende column
    public void indsaetStud(Studerende s) {
        try {

            String sql = "INSERT INTO studerende(stdnr,fnavn,enavn,adresse,postnr,mobil,klasse) VALUES(" +
                    String.valueOf(s.getStdnr()) + ",'" + s.getFnavn() + "','" + s.getEnavn() + "','" + s.getAdresse() + "','" + s.getPostnr() + "','" + s.getMobil() + "','" + s.getKlasse() + "');";
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
