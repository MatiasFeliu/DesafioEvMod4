package modelo;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Cliente {
    private String runCliente;
    private String nombreCliente;
    private String apellidoCliente;
    private int aniosCliente;
    private CategoriaEnum categoriaEnum;

    public String toCsv() {
        return runCliente + "," + nombreCliente + "," + apellidoCliente + "," + aniosCliente;
    }
}

