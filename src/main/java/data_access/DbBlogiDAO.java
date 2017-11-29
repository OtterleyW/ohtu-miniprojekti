package data_access;

import domain.Blogi;
import domain.Lukuvinkki;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbBlogiDAO implements BlogiDAO {

    private final Database database;

    public DbBlogiDAO(Database database) {
        this.database = database;
    }

    @Override
    public void save(Blogi blogi) {
        ArrayList values = new ArrayList();

        values.add(blogi.getOtsikko());
        values.add(blogi.getKirjoittaja());
        values.add(blogi.getUrl());

        database.executeQueryUpdate("INSERT INTO Blogi "
                    + "(otsikko, kirjoittaja, url)"
                    + " VALUES (?, ?, ?)", values);
        database.closeConnection();
    }
    

    @Override
    public ArrayList<Lukuvinkki> getAll() {
        ArrayList<Lukuvinkki> blogi_lukuvinkit = new ArrayList();

        ResultSet rS = database.executeQuerySelect("SELECT * FROM Blogi");


        try {
            while (rS.next()) {
                Lukuvinkki blogi = new Blogi(rS.getInt("id"), rS.getString("otsikko"), rS.getString("kirjoittaja"), rS.getString("url"));
                
                blogi_lukuvinkit.add(blogi);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        database.closeConnection();
        
        return blogi_lukuvinkit;
    }

    public void markAsLuettu(String id) {
        String table = parseIdToTable(id);
        String idNumber = id.substring(1,id.length());
        ArrayList values = new ArrayList<>();
        values.add(table);
        values.add(idNumber);
        database.executeQueryUpdate("UPDATE TABLE ? SET luettu=true WHERE id=?", values);
        database.closeConnection();
    }

    private String parseIdToTable(String id) {
        char letter = id.toCharArray()[0];
        if (letter == 'K') {
            return "kirja";
        } else if (letter == 'B') {
            return "blogi";
        }
        return null;
    }
    
}