package utilidades;
    public class Utilidad {
        // Método para limpiar la pantalla
        public static void limpiarPantalla() {
            String os = System.getProperty("os.name").toLowerCase();
            System.out.println("Bandera");
            try {
                if (os.contains("win")) {
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                } else if (os.contains("mac") || os.contains("nix") || os.contains("nux")) {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                } else {
                    System.out.println("No se puede limpiar la pantalla porque el sistema operativo no es compatible.");
                }
            } catch (Exception e) {
                System.err.println("Error al limpiar la pantalla: " + e.getMessage());
            }
        }

        // Método para hacer una pausa
        public static void pausa(int segundos) {
            try {
                Thread.sleep(segundos * 1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("El hilo de espera fue interrumpido.");
            }
        }
    }


