import java.io.*;
import java.util.ArrayList;

public class AlumnoCRUD {

    private File f;

    public AlumnoCRUD(String nombreFichero) {
        try {
            f = new File(nombreFichero);
            f.createNewFile();
            if (f.length() == 0) {
                // Si el fichero indicado está vacío (ocupa 0 bytes), escribe un ArrayList vacío
                FileOutputStream fos = new FileOutputStream(f);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(new ArrayList<Alumno>());
                oos.flush();
                oos.close();
                fos.close();
            }
        }catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
    
    /*
        Escribe en el fichero un ArrayList de alumnos
     */
    public void escribirAlumnos(ArrayList<Alumno> listaAlumnos) {
        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(listaAlumnos);
            oos.flush();
            oos.close();
            fos.close();
        }catch (IOException e) {
            System.out.println("Fallo al escribir");
        }
    }

    /*
        Devuelve un ArrayList con todos los alumnos existentes en el fichero
     */
    public ArrayList<Alumno> leerAlumnos() {
        ArrayList<Alumno> listaAlumnos = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            listaAlumnos = (ArrayList<Alumno>) ois.readObject();
            ois.close();
            fis.close();
        }catch (IOException | ClassNotFoundException e) {
            System.out.println("Fallo al leer");
        }
        return listaAlumnos;
    }


}
