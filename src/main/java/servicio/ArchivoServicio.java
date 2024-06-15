package servicio;

import modelo.CategoriaEnum;
import modelo.Cliente;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ArchivoServicio {
    public void cargarDatos(String fileName,List<Cliente> listaClientes){
        String linea ,os, ruta,nav;
        Scanner sc = new Scanner(System.in);
        //Devuelve el nombre del sistema operativo del usuario
        os = System.getProperty("os.name").toLowerCase();

        if(os.contains("win")){
            System.out.println("Ingresa la ruta en donde desea exportar el archivo DBClientes.csv:");
            System.out.println("Ejemplo -> C:\\\\usuario\\equipo\\Desktop");
            ruta = sc.nextLine();
            nav = ruta+"\\"+fileName;
        }else{
            System.out.println("Ingresa la ruta en donde desea exportar el archivo DBClientes.csv:");
            System.out.println("Ejemplo -> home/usuario/Desktop");
            ruta = sc.nextLine();
            nav = ruta+"/"+fileName;
        }

        try(BufferedReader buffer = new BufferedReader(new FileReader(nav))){
            while ((linea = buffer.readLine())!=null){
                //System.out.println(linea);
                String[] clienteData = linea.split(",");
                //Creamos objeto
                Cliente cliente = new Cliente(clienteData[0],clienteData[1],clienteData[2], Integer.parseInt(clienteData[3])
                        ,CategoriaEnum.valueOf(clienteData[4]));

                listaClientes.add(cliente);
            }

            System.out.println("Datos cargados en la lista!!");
            //System.out.println(ps.getListaProductos());

        }catch(IOException e){
            System.out.println("Ha ocurrido un error" + e.getMessage());
        }


    }
}
