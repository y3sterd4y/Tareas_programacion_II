class Juego {
  private int numeroVidas;
  private int record;

  public Juego(int numeroVidas) {
    this.numeroVidas = numeroVidas;
    this.record = 0;
  }
  public int getNumeroVidas() {
    return this.numeroVidas;
  }

  public void reiniciarPartida() {
    this.numeroVidas = 3;
    this.record = 0;
  }

  public void actulizarRecord(int puntos) {
    this.record = puntos;
  }

  public boolean quitaVida() {
    this.numeroVidas -= 1;
    if (this.numeroVidas == 0) {
      return false;
    } else {
      return true;
    }
  } 
  public int getRecord() {
    return this.record;
  }
}