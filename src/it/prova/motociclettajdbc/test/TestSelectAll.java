package it.prova.motociclettajdbc.test;

import it.prova.motociclettajdbc.dao.MotociclettaDAO;
import it.prova.motociclettajdbc.model.Motocicletta;

import java.util.List;

public class TestSelectAll {

    public static void main(String[] args) {
        System.out.println("Inizio....");

        // questo risulta l'oggetto incaricato di operazioni dao
        MotociclettaDAO motociclettaDaoInstance = new MotociclettaDAO();
        int quantiSonoAttualmentePresenti = -1;

        // #####################################################################
        System.out.println("############### test per verifica esistenza dati ###########################");
        List<Motocicletta> attualmentePresentiSullaBaseDati = motociclettaDaoInstance
                .elencaTuttiQuelliAttualmenteSullaBaseDati();
        quantiSonoAttualmentePresenti = attualmentePresentiSullaBaseDati.size();
        System.out.println("Sono attualmente presenti " + quantiSonoAttualmentePresenti + " records");
        for (Motocicletta motociclettaItem : attualmentePresentiSullaBaseDati) {
            System.out.println(motociclettaItem);
        }
        System.out.println(
                "####################### test per verifica esistenza dati: FINE     ##################################");
        System.out.println("#####################################################################");

    }
}
