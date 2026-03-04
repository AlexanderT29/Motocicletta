package it.prova.motociclettajdbc.dao;

import it.prova.motociclettajdbc.model.Motocicletta;

import it.prova.motociclettajdbc.connection.MyConnetion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MotociclettaDAO {

    // =============================================== LIST
    public List<Motocicletta> findAll() {

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


    // =============================================== FINDBYID
    public Motocicletta findById(Long input) {

        if (input == null || input < 1) {
            return null;
        }

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Motocicletta result = null;

        try {

            c = MyConnetion.getConnection();
            ps = c.prepareStatement("select * from motocicletta u where u.id=?;");
            ps.setLong(1, input);

            rs = ps.executeQuery();

            if (rs.next()) {
                result = new Motocicletta();
                result.setId(rs.getLong("id"));
                result.setMarca(rs.getString("marca"));
                result.setModello(rs.getString("modello"));
                result.setDataImmatricolazione(rs.getDate("dataimmatricolazione"));
                result.setCilindrata(rs.getInt("cilindrata"));
            }

        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            try {
                rs.close();
                ps.close();
                c.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    // =============================================== UPDATE
    public int update(Motocicletta input) {

        if (input == null || input.getId() < 1) {
            return 0;
        }

        Connection c = null;
        PreparedStatement ps = null;
        int result = 0;

        try {

            c = MyConnetion.getConnection();
            ps = c.prepareStatement("UPDATE motocicletta SET marca=?, modello=?, " + "cilindrata=?, dataimmatricolazione=? where id=?;");
            ps.setString(1, input.getMarca());
            ps.setString(2, input.getModello());
            // quando si fa il setDate serve un tipo java.sql.Date
            ps.setInt(3, input.getCilindrata());
            ps.setDate(4, new java.sql.Date(input.getDataImmatricolazione().getTime()));
            ps.setLong(5, input.getId());

            result = ps.executeUpdate();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            try {
                ps.close();
                c.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    // =============================================== DELETE
    public int delete(Long idElementToDelete) {

        if (idElementToDelete == null || idElementToDelete < 1) {
            return 0;
        }

        Connection c = null;
        PreparedStatement ps = null;
        int result = 0;

        try {

            c = MyConnetion.getConnection();
            ps = c.prepareStatement("DELETE from motocicletta where id=?;");
            ps.setLong(1, idElementToDelete);

            result = ps.executeUpdate();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            try {
                ps.close();
                c.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    // =============================================== INSERT
    public int insert(Motocicletta input) {

        Connection c = null;
        PreparedStatement ps = null;
        int result = 0;

        try {

            c = MyConnetion.getConnection();
            ps = c.prepareStatement(
                    "INSERT INTO motocicletta (marca, modello, cilindrata, dataimmatricolazione) " + "VALUES (?, ?, ?,?) ");
            ps.setString(1, input.getMarca());
            ps.setString(2, input.getModello());
            ps.setInt(3, input.getCilindrata());
            ps.setDate(4, new java.sql.Date(input.getDataImmatricolazione().getTime()));

            result = ps.executeUpdate();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            try {
                ps.close();
                c.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return result;
    }
}
