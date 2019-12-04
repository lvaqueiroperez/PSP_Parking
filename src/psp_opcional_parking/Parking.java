package psp_opcional_parking;

//EN ESTA CLASE SE CREARÁN LOS HILOS
public class Parking {

    //define el numero de elementos del array (variable global para que podamos acceder desde otra Clase)
    public static int numPlazas;
    //cuantos coches estarán entrando y saliendo (el número de hilos)
    private int numCoches;

    public Parking(int numPlazas, int numCoches) {
        this.numPlazas = numPlazas;
        this.numCoches = numCoches;
    }

    //Método donde se crearán hilos
    public void crearHilos() {
        //Objeto para que accedan a la misma clase
        MonitorParking objM = new MonitorParking();
        //Inicializamos el array poniendo 0 en todas sus celdas !!!
        objM.inicializarArray();
        //Array para ir creando y almacenando los hilos
        CochesHilos[] arrayCoches = new CochesHilos[numCoches];

        for (int i = 0; i < numCoches; i++) {

            arrayCoches[i] = new CochesHilos("C" + i, objM);

        }
        //iniciamos los hilos
        //(Java parece que deja inicializar los hilos en un for sin que haya
        //fallos a primera vista)
        for (int i = 0; i < arrayCoches.length; i++) {

            arrayCoches[i].start();

        }

    }

}
