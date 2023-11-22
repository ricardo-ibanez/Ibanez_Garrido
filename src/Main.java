import java.io.*;

public class Main {



    public static void main(String[] args) throws IOException, ClassNotFoundException {

        AlumnoCRUD crud = new AlumnoCRUD("alumnos");

        crud.altaAlumno(new Alumno("manolo", "gomez", "77174133k", "DAM", 22));


        crud.mostrarTodos();


    }
}