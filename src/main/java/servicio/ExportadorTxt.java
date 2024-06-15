package servicio;
import java.io.File;
import modelo.Cliente;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class ExportadorTxt extends Exportador{
    @Override
    public void exportar(String fileName, List<Cliente> listaClientes) {
        //variables
        String linea,os,ruta,nav;
        Scanner sc = new Scanner(System.in);
        //Devuelve el nombre del sistema operativo del usuario
        os = System.getProperty("os.name").toLowerCase();

        if(os.contains("win")){
            System.out.println("Ingresa la ruta en donde desea exportar el archivo DBClientes.txt:");
            System.out.println("Ejemplo -> C:\\\\usuario\\equipo\\Desktop");
            ruta = sc.nextLine();
            nav= ruta +"\\"+fileName;
        }else
            System.out.println("Ingresa la ruta en donde desea exportar el archivo DBClientes.txt:");
        System.out.println("Ejemplo -> home/usuario/Desktop");
        ruta = sc.nextLine();
        nav = ruta+"/"+fileName;

        File archivo = new File(nav);

        try(PrintWriter writer = new PrintWriter(new FileWriter(archivo))) {
            for (Cliente cliente : listaClientes) {
                linea = cliente.getRunCliente()+","+cliente.getNombreCliente()+","
                        +cliente.getApellidoCliente()+","+cliente.getAniosCliente()
                        +","+cliente.getCategoriaEnum();
                //Escribimos en el archivo
                writer.println(linea);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
        
    }

