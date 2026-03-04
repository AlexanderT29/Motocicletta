package it.prova.motociclettajdbc.test;

import it.prova.motociclettajdbc.dao.MotociclettaDAO;
import it.prova.motociclettajdbc.model.Motocicletta;

import java.util.List;

public class TestFindById {

    public static void main(String[] args) {
        System.out.println("Inizio....");

        // questo risulta l'oggetto incaricato di operazioni dao
        MotociclettaDAO motociclettaDaoInstance = new MotociclettaDAO();

        // #####################################################################
        System.out.println("############### test per verifica esistenza dati ###########################");
        System.out.println(motociclettaDaoInstance.findById(12L));

        System.out.println(
                "####################### test per verifica esistenza dati: FINE     ##################################");
        System.out.println("#####################################################################");

    }
}
