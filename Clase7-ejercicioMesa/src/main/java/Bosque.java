public class Bosque {

    public static void plantarArbol(){
        for(int i = 1; i < 500; i++){
            ArbolFactory.getArbol(500,300,"rojo");
            ArbolFactory.getArbol(200,400,"verde");
        }
    }

    public static void main(String[] args) {
        plantarArbol();
    }

}
