interface Animal {
    void hacerSonido();
}

class Perro implements Animal {
    public void hacerSonido() {
        System.out.println("Ladrido");
    }
}

public class Ejemplo {
    public static void main(String[] args) {
        Animal miPerro = new Perro();
        miPerro.hacerSonido();
    }
}
