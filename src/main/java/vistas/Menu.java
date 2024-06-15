package vistas;
import modelo.CategoriaEnum;
import modelo.Cliente;
import servicio.ExportadorCsv;
import servicio.ExportadorTxt;
import servicio.ArchivoServicio;
import servicio.ClienteServicio;
import utilidades.Utilidad;

import java.util.List;
import java.util.Scanner;

public class Menu {
    private ClienteServicio clienteServicio;
    private ArchivoServicio archivoServicio;
    private ExportadorCsv exportadorCsv;
    private ExportadorTxt exportarTxt;
    private String fileName1 = "DBClientes.csv";
    private String fileName = "Clientes";
    private Scanner sc = new Scanner(System.in);

    // metodos para construccion y seleccion de menú
    public Menu() {
        // instanciando atributos//
        clienteServicio = new ClienteServicio();
        archivoServicio = new ArchivoServicio();
        exportadorCsv = new ExportadorCsv();
        exportarTxt = new ExportadorTxt();
    }

    public void mostrarMenu() {
        int option;
        do{
            System.out.println("\u001B[36;40;1m"+ "-- Menú Principal --" +"\u001B[0m");
            System.out.println("\u001B[35m"+"1. Listar clientes" +"\u001B[0m");
            System.out.println("\u001B[35m"+"2. Agregar cliente" +"\u001B[0m");
            System.out.println("\u001B[35m"+"3. Editar cliente"+"\u001B[0m");
            System.out.println("\u001B[35m"+"4. Importar datos"+"\u001B[0m");
            System.out.println("\u001B[35m"+"5. Exportar datos"+"\u001B[0m");
            System.out.println("\u001B[33m"+"6. Terminar programa"+"\u001B[0m");
            System.out.println("\u001B[32m"+"   Elegir una opción:"+"\u001B[0m");

            option = sc.nextInt();
            sc.nextLine();

            switch (option){
                case 1: clienteServicio.listarClientes();
                    break;
                case 2: addCLiente();
                    break;
                case 3:clienteServicio.editarCliente();
                    break;
                case 4: archivoServicio.cargarDatos(fileName1,clienteServicio.getListaClientes());
                    break;
                case 5:exportarArchivo();
                    break;
                case 6:
                    System.out.println("Saliendo del programa");
                    Utilidad.pausa(2);
                    break;
                default:
                    System.out.println("Opción incorrecta, elige una opción valida");
                    break;

            }
        }while(option!=6);
    }

    public void addCLiente(){

        System.out.println("-------------Crear Cliente-------------");
        System.out.println("Ingresa RUN del Cliente: ");
        String rut = sc.nextLine();
        System.out.println("Ingresa Nombre del Cliente: ");
        String nombre = sc.nextLine();
        System.out.println("Ingresa Apellido del Cliente: ");
        String apellido = sc.nextLine();
        System.out.println("Ingresa años como Cliente: ");
        int edad = sc.nextInt();
        sc.nextLine();
        clienteServicio.agregarClientes(rut,nombre,apellido,edad, CategoriaEnum.ACTIVO);

    }
    //Método Exportar Archivo
    public void exportarArchivo(){
        System.out.println("---------Exportar Datos-----------");
        System.out.println("Seleccione el formato a exportar:");
        System.out.println("1-.Formato Csv");
        System.out.println("2.-Formato txt");
        System.out.println("Ingrese una opción para exportar:");
        int option;
        option = sc.nextInt();
        sc.nextLine();

        if (option==1){
            exportadorCsv.exportar(fileName1,clienteServicio.getListaClientes());
        }else if (option==2){
            exportarTxt.exportar(fileName,clienteServicio.getListaClientes());
        }
    }
}