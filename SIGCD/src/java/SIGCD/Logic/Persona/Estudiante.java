package SIGCD.Logic.Persona;

public class Estudiante extends Persona {

    private int idEstudiante;
    private int gradoAcademico;
    private int edad;
    private String fechaNacimiento;

    public Estudiante() {
    }

    public Estudiante(int idEstudiante, int idPersona, int gradoAcademico, int edad, String fechaNacimiento) {
        super(idPersona);
        this.idEstudiante = idEstudiante;
        this.gradoAcademico = gradoAcademico;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Estudiante(int idPersona, int gradoAcademico, int edad, String fechaNacimiento) {
        super(idPersona);
        this.gradoAcademico = gradoAcademico;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getGradoAcademico() {
        return gradoAcademico;
    }

    public void setGradoAcademico(int gradoAcademico) {
        this.gradoAcademico = gradoAcademico;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "idEstudiante=" + idEstudiante + ", gradoAcademico=" + gradoAcademico + ", edad=" + edad + ", fechaNacimiento=" + fechaNacimiento + '}';
    }

}
