package utn.guido.dao;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import utn.guido.model.Player;
import utn.guido.model.Word;

public class Dao {

    public static Word getRandomWord(){
        Word wordObject = null;
        String word="";
        int id = 0;
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ahorcado","root","");
            String query = "SELECT * FROM palabras ORDER BY RAND() LIMIT 1";
            PreparedStatement st = con.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                id = rs.getInt("id");
                word = rs.getString("palabra");
            }
            con.close();
            wordObject = new Word(id,word);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return wordObject;
    }

    public static void insertWinner(Player player, Word word, java.util.Date date){
        try {

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ahorcado","root","");
            String query = "INSERT INTO ganadores (id, nombre, fecha, id_palabra) VALUES (null,?,?,?);";
            PreparedStatement ps = con.prepareStatement(query);

            java.sql.Date sqlDate = new java.sql.Date(date.getTime());

            ps.setString(1,player.getPlayerName());
            ps.setDate(2, sqlDate);
            ps.setInt(3, word.getId());

            ps.execute();
            con.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }
}
