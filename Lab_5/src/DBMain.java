import java.sql.Connection;

public class DBMain {
    public static void main(String[] args) {

        DBConnection c = new DBConnection();
        Connection connection = c.connectToSQLite();

        // Connection connection = c.connectToMySql();

        c.createTable();
        DBOperation operation = new DBOperation(connection);
        // operation.insertPerson("Damian", "Hanusiak", 22);
        operation.getAllRecord();
        c.disconnect();
    }
}
