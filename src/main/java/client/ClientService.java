package client;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import dbService.Database;

public class ClientService {

    public Long create(String name) {
        Long clientId = null;
        String sql = "INSERT INTO client (name) VALUES (?)";

        try (Connection conn = Database.getInstance().getConnection()) {
            PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, name);
            st.executeUpdate();

            ResultSet generatedKeys = st.getGeneratedKeys();
            if (generatedKeys.next()) {
                clientId = generatedKeys.getLong("id");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return clientId;
    }

    public String getById(long id) {
        String clientName = null;
        String sql = "SELECT id, name FROM client WHERE id = ?";

        try (Connection conn = Database.getInstance().getConnection()) {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setLong(1, id);
            ResultSet resultSet = st.executeQuery();

            while (resultSet.next()) {
                clientName = resultSet.getString("client_name");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return clientName;
    }

    public void setName(Long id, String name) {
        String sql = "UPDATE client SET name = ? WHERE id = ?";

        try (Connection conn = Database.getInstance().getConnection()) {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, name);
            st.setLong(2, id);
            st.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void deleteById(long id) {
        String sql = "DELETE FROM client WHERE id = ?";

        try (Connection conn = Database.getInstance().getConnection()) {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setLong(1, id);
            st.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Client> listAll() {
        List<Client> clients = new ArrayList<>();
        String sql = "SELECT id, name FROM client ORDER BY id";

        try (Connection conn = Database.getInstance().getConnection()) {
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet resultSet = st.executeQuery();

            while (resultSet.next()) {
                Long clientID = resultSet.getLong("id");
                String clientName = resultSet.getString("name");
                Client client = new Client(clientID, clientName);
                clients.add(client);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return clients;
    }


}
