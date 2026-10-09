package br.com.pi.db;

public class DbConfig {
    // Ajuste estes valores conforme seu ambiente
    public static String HOST = "localhost";
    public static int PORT = 3306;
    public static String DATABASE = "pi_cadastro";
    public static String USER = "root";
    public static String PASSWORD = "";

    public static String getJdbcUrl() {
        return "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    }
}


