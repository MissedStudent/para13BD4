import java.sql.*;

public class BD {
    /**/
    public static String url = "jdbc:mysql://localhost/energyconsumption";
    public static String user = "root";
    public static String password = "";

    // открыть соединение
    public Connection openConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
    //закрыть соединение
    public void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void addAccount(int account_number,int consumer_id){
        Connection connection=null;
        try{
            connection=openConnection();
            String query="INSERT INTO `accounts` (`account_number`,`consumer_id`) VALUES (?,?)";
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setInt(1,account_number);
            statement.setInt(2,consumer_id);
            int count=statement.executeUpdate();
            if(count>0){
                System.out.println("Счет добавлен");
            }
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Счет не добавлен");
        } finally {
            closeConnection(connection);
        }
    }
    public void addConsumer(String consumer_name,int consumer_need,Date consumer_date_expire){
        Connection connection=null;
        try{
            connection=openConnection();
            String query="INSERT INTO `consumers` (`consumer_name`,`consumer_need`,`consumer_date_expire`) VALUES (?,?,?)";
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setString(1,consumer_name);
            statement.setInt(2,consumer_need);
            statement.setDate(3,consumer_date_expire);
            int count=statement.executeUpdate();
            if(count>0){
                System.out.println("Потребитель добавлен");
            }
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Потребитель не добавлен");
        } finally {
            closeConnection(connection);
        }
    }
    public void addDevice(String device_name,int consumer_id){
        Connection connection=null;
        try{
            connection=openConnection();
            String query="INSERT INTO `devices` (`device_name`,`consumer_id`) VALUES (?,?)";
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setString(1,device_name);
            statement.setInt(2,consumer_id);
            int count=statement.executeUpdate();
            if(count>0){
                System.out.println("Устройство добавлено");
            }
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Устройство не добавлено");
        } finally {
            closeConnection(connection);
        }
    }
    public void addIndication(int indication_number,int account_id){
        Connection connection=null;
        try{
            connection=openConnection();
            String query="INSERT INTO `indications` (`indication_number`,`account_id`) VALUES (?,?)";
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setInt(1,indication_number);
            statement.setInt(2,account_id);
            int count=statement.executeUpdate();
            if(count>0){
                System.out.println("Показание добавлено");
            }
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Показание не добавлено");
        } finally {
            closeConnection(connection);
        }
    }
    public void addResource(int resource_amount,int consumer_id){
        Connection connection=null;
        try{
            connection=openConnection();
            String query="INSERT INTO `resources` (`resource_amount`,`consumer_id`) VALUES (?,?)";
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setInt(1,resource_amount);
            statement.setInt(2,consumer_id);
            int count=statement.executeUpdate();
            if(count>0){
                System.out.println("Ресурс добавлен");
            }
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Ресурс не добавлен");
        } finally {
            closeConnection(connection);
        }
    }
    public void addBook(String book_title,int genre_id,int author_id){
        Connection connection=null;
        try{
            connection=openConnection();
            String query="INSERT INTO `Book` (`book_title`,`genre_id`,`author_id`) VALUES (?,?,?)";
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setString(1,book_title);
            statement.setInt(2,genre_id);
            statement.setInt(3,author_id);
            int count=statement.executeUpdate();
            if(count>0){
                System.out.println("Книга добавлена");
            }
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Книга не добавлена");
        } finally {
            closeConnection(connection);
        }
    }
    public int findIntByName(String idColumn,String tableName,String nameColumn,String name){
        //idColumn - название столбца с айди; tableName - название таблицы;
        // nameColumn - название столбца со значением для поиска; name - значение для поиска
        int id=-1;
        Connection connection=null;
        try {
            connection=openConnection();
            String query=String.format("SELECT %s FROM %s WHERE %s=?", idColumn,tableName,nameColumn);
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setString(1,name);
            ResultSet resultSet=statement.executeQuery();
            if (resultSet.next()){id=resultSet.getInt(idColumn);}
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("id не получен из "+tableName);
        } finally {
            closeConnection(connection);
        }
        return id;
    }
}
