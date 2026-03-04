package it.prova.motociclettajdbc.dao;

import it.prova.motociclettajdbc.model.Motocicletta;

import it.prova.motociclettajdbc.connection.MyConnetion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MotociclettaDAO {

    // =============================================== LIST
    public List<Motocicletta> elencaTuttiQuelliAttualmenteSullaBaseDati() {

        Connection c = null;
        ResultSet rs = null;
        Statement s = null;
        Motocicletta temp = null;
        List<Motocicletta> result = new ArrayList<Motocicletta>();

        try {

            c = MyConnetion.getConnection();
            s = c.createStatement();

            rs = s.executeQuery("select * from motocicletta;");

            while (rs.next()) {
                temp = new Motocicletta();
                temp.setId(rs.getLong("id"));
                temp.setMarca(rs.getString("marca"));
                temp.setModello(rs.getString("modello"));
                temp.setCilindrata(rs.getInt("cilindrata"));
                temp.setDataImmatricolazione(rs.getDate("dataimmatricolazione"));
                result.add(temp);

            }

        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            try {
                rs.close();
                s.close();
                c.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
