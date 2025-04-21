class JuegoAdivinaNumero extends Juego {
  private int numeroAdivinar;

  public JuegoAdivinaNumero(int numeroVidas) {
    super(numeroVidas);
    this.numeroAdivinar = (int) (Math.random() * 10) + 1;
  }

  public int getNumeroAdivinar() {
    return this.numeroAdivinar;
  }

  public void nuevoNumeroAdivinar() {
    this.numeroAdivinar = (int) (Math.random() * 10) + 1;
  }

  public void otraPartida() {
    System.out.println("¡Adivina otro numero!");
    this.nuevoNumeroAdivinar();
  }
  
  public void resultado() {
      System.out.println("tu puntuacion es " + this.getRecord());
  }

  public void juega(int numero) {
    if (this.getNumeroVidas() > 0) {
      if (numero == this.numeroAdivinar) {
        System.out.println("¡Has ganado!");
        this.actulizarRecord(1);
        this.otraPartida();
      } else {
        System.out.println("¡Numero incorrecto!");
        this.quitaVida();
        System.out.println("Tienes " + this.getNumeroVidas() + " vidas.");
        if (numero < this.numeroAdivinar) {
          System.out.println("El número es mayor.");
        } else {
          System.out.println("El número es menor.");
        }
      }
    } else {
      System.out.println("¡Has perdido xd!");
      this.reiniciarPartida();
      System.out.println("Reiniciando partida...");
      this.resultado
    }
  }
}
