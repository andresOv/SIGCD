package SIGCD.Data.DataAccessObject;

import SIGCD.Logic.Formulario.AyudaTemporal;
import SIGCD.Logic.Formulario.BecaMunicipal;
import SIGCD.Logic.Persona.Estudiante;
import SIGCD.Logic.Persona.Persona;
import SIGCD.Logic.Persona.Solicitante;
import java.util.ArrayList;

public class Model {

    private static Model uniqueInstance;
    private AyudaTemporalDAO ayudaTemporalDao;
    private BecaMunicipalDAO becaMunicipalDao;
    private PersonaDAO personaDao;
    private EstudianteDAO estudianteDao;
    private SolicitanteDAO solicitanteDao;

    public Model() {
        this.ayudaTemporalDao = new AyudaTemporalDAO();
        this.becaMunicipalDao = new BecaMunicipalDAO();
        this.personaDao = new PersonaDAO();
        this.estudianteDao = new EstudianteDAO();
        this.solicitanteDao = new SolicitanteDAO();
    }

    public static Model instance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Model();
        }
        return uniqueInstance;
    }

    //Metodos Ayuda temporal
    public AyudaTemporal getAyudaTemporal(int IdAyudaTemporal) throws Exception {
        return ayudaTemporalDao.read(IdAyudaTemporal);
    }

    public void createAyudaTemporal(AyudaTemporal ayudaTemporal) throws Exception {
        ayudaTemporalDao.create(ayudaTemporal);
    }

    public ArrayList<AyudaTemporal> getAllAyudaTemporal() throws Exception {
        return ayudaTemporalDao.readAll();
    }

    //Metodos Beca municipal
    public BecaMunicipal getBecaMunicipal(int Id) throws Exception {
        return becaMunicipalDao.read(Id);
    }

    public void createBecaMunicipal(BecaMunicipal result) throws Exception {
        becaMunicipalDao.create(result);
    }

    public ArrayList<BecaMunicipal> getAllBecaMunicipal() throws Exception {
        return becaMunicipalDao.readAll();
    }

    //Metodos Persona
    public Persona getPersona(int Id) throws Exception {
        return personaDao.read(Id);
    }

    public void createPersona(Persona result) throws Exception {
        personaDao.create(result);
    }

    public ArrayList<Persona> getAllPersona() throws Exception {
        return personaDao.readAll();
    }

    //Metodos Estudiante
    public Estudiante getEstudiante(int Id) throws Exception {
        return estudianteDao.read(Id);
    }

    public void createEstudiante(Estudiante result) throws Exception {
        estudianteDao.create(result);
    }

    public ArrayList<Estudiante> getAllEstudiante() throws Exception {
        return estudianteDao.readAll();
    }

    //Metodos Solicitante
    public Solicitante getSolicitante(int Id) throws Exception {
        return solicitanteDao.read(Id);
    }

    public void createSolicitante(Solicitante result) throws Exception {
        solicitanteDao.create(result);
    }

    public ArrayList<Solicitante> getAllSolicitante() throws Exception {
        return solicitanteDao.readAll();
    }
}
