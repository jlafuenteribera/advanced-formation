import java.sql.*;

public class TransaccionJDBC {
    private String dbURL = "jdbc:postgresql://localhost:5432/postgres";
    private String user = "postgres";
    private String password = "postgres";
    private Connection conn;

    public void connect() {
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(dbURL, user, password);
            System.out.println("Connected.");
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            conn.close();
            System.out.println("Closed.");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void saveOrder() {
        PreparedStatement saleStatementa = null;
        PreparedStatement saleStatementb = null;

        try {
            conn.setAutoCommit(false);

            // A
            String sqlUpdateTotala = "update balances set balance = balance + 1000 where person_name = 'Julio'";
            saleStatementa = conn.prepareStatement(sqlUpdateTotala);
            saleStatementa.executeUpdate();

            // B
            String sqlUpdateTotalb = "update balances set balanze = balance - 1000 where person_name = 'Juan'";
            saleStatementb = conn.prepareStatement(sqlUpdateTotalb);
            saleStatementb.executeUpdate();

            conn.commit();

        } catch (SQLException ex) {
            if (conn != null) {
                try {

                    conn.rollback();

                    System.out.println("Rolled back.");
                } catch (SQLException exrb) {
                    exrb.printStackTrace();
                }
            }
        } finally {
            try {
                if (saleStatementb != null) {
                    saleStatementb.close();
                }

                if (saleStatementa != null) {
                    saleStatementa.close();
                }

                conn.setAutoCommit(true);
            } catch (SQLException excs) {
                excs.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        TransaccionJDBC demo = new TransaccionJDBC();

        demo.connect();

        demo.saveOrder();

        demo.disconnect();
    }
}