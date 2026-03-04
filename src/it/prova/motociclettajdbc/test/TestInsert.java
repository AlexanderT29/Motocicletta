package it.prova.motociclettajdbc.test;

import it.prova.motociclettajdbc.dao.MotociclettaDAO;
import it.prova.motociclettajdbc.model.Motocicletta;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class TestInsert {

    public static void main(String[] args) throws ParseException {
        System.out.println("Inizio....");

        // questo risulta l'oggetto incaricato di operazioni dao
        MotociclettaDAO motociclettaDaoInstance = new MotociclettaDAO();
        int quantiSonoAttualmentePresenti = -1;
        List<Motocicletta> attualmentePresentiSullaBaseDati = motociclettaDaoInstance
                .findAll();
        quantiSonoAttualmentePresenti = attualmentePresentiSullaBaseDati.size();

        System.out.println("############### test qualche insert ###########################");
        Motocicletta voceDaInserire = new Motocicletta("Honda", "CB650R2", 650,
                new SimpleDateFormat("dd/MM/yyyy").parse("20/10/1990"));
        System.out.println(motociclettaDaoInstance.insert(voceDaInserire));

        // faccio il test per verificare che siano state inserite altre due voci
        if (quantiSonoAttualmentePresenti + 1 != motociclettaDaoInstance.findAll()
                .size())
            throw new AssertionError("qualche insert: FAILED");
        else
            System.out.println("E' presente un elemento in più");

        System.out.println("################### test qualche insert: FINE ###################################");
        System.out.println("#####################################################################");

    }
}
