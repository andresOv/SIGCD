
import SIGCD.Data.DataAccessObject.Model;
import SIGCD.Logic.Direccion.Direccion;
import SIGCD.Logic.Formulario.AyudaTemporal;
import SIGCD.Logic.Formulario.BecaMunicipal;
import SIGCD.Logic.Persona.Estudiante;
import SIGCD.Logic.Persona.Persona;
import SIGCD.Logic.Persona.Solicitante;
import java.sql.Timestamp;

public class MainPruebas {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String args[]) throws Exception {
        Model model = Model.instance();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Persona persona = new Persona("1111", "Sebas", "Cabe", "Madri");
        Persona persona1 = new Persona("0000", "Sebas", "Cabe", "Madri");
        Direccion direccion = new Direccion(1, 1, "San Pablo");
        Solicitante solicitante = new Solicitante(1, "0000", "1111", direccion);
        Estudiante estudiante = new Estudiante(2, 1, 10, "2021");
        AyudaTemporal ayudaTemporal = new AyudaTemporal(1, 1, "Emergencia", timestamp);
        BecaMunicipal becaMunicipal = new BecaMunicipal(2, 1, 1, 2, timestamp);

        model.createPersona(persona);
        model.createPersona(persona1);
        model.createSolicitante(solicitante);
        model.createEstudiante(estudiante);
        model.createAyudaTemporal(ayudaTemporal);
        model.createBecaMunicipal(becaMunicipal);
    }
}
