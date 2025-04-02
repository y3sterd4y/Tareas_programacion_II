class TrabajoDeImpresora {
    private static int contador = 0;
    private int id_documento;
    private String nombre_documento;
    private int numero_paginas;
    
    public TrabajoDeImpresora(String nombre, int n_paginas) {
        this.id_documento = ++contador;
        this.nombre_documento = nombre;
        this.numero_paginas = n_paginas;
    }
    
    @Override
    public String toString() {
        return "TrabajoDeImpresora{id=" + id_documento + ", nombre=" + nombre_documento + ", paginas=" + numero_paginas + "}";
    }
}
