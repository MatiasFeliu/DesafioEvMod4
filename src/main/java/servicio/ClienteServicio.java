package servicio;
import lombok.Getter;
import modelo.CategoriaEnum;
import modelo.Cliente;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
@Getter

public class ClienteServicio {
    private List<Cliente> listaClientes;
    public ClienteServicio(){
        this.listaClientes = new ArrayList<Cliente>();
    }
    public void listarClientes(){
        System.out.println("-----Datos del cliente------");
        if(!listaClientes.isEmpty()){
            for(Cliente cliente : listaClientes){
                System.out.println("RUN del Cliente: "+cliente.getRunCliente());
                System.out.println("Nombre del Cliente: "+cliente.getNombreCliente());
                System.out.println("Apellido del Cliente: "+cliente.getApellidoCliente());
                System.out.println("Años del Cliente: "+cliente.getAniosCliente());
                System.out.println("Categoria del Cliente: "+cliente.getCategoriaEnum());
                System.out.println("---------------------------");
            }
        }else{
            System.out.println("La lista de clientes esta vacia");
        }
    }
    public void agregarClientes(String runCliente, String nombreCliente,
                                String apellidoCliente, int aniosCliente,
                                CategoriaEnum nombreCategoria){

        Cliente cliente = new Cliente(runCliente, nombreCliente,
                apellidoCliente, aniosCliente, nombreCategoria);

        listaClientes.add(cliente);
    }
    public void editarCliente(){
        System.out.println(listaClientes);
        //Variables y objetos que usaremos en el metodo
        String rutSelection;
        int selectedIndex =0;
        Scanner sc = new Scanner(System.in);
        Cliente selectedClient = new Cliente();

        //Menu principal de editar Cliente
        System.out.println("-------------Editar Cliente-------------");
        System.out.println("Seleccione lo que desea hacer");
        System.out.println("1.-Cambiar el estado del Cliente");
        System.out.println("2.-Editar los datos ingresados del Cliente");
        System.out.println("Ingrese opcion: ");
        int optionMenu = sc.nextInt();
        sc.nextLine();

        if(optionMenu==1){
            System.out.println("Ingrese el RUN del Cliente que quiere editar");
            rutSelection = sc.nextLine();

            for(int i=0; i<listaClientes.size(); i++){
                System.out.println(listaClientes.get(i).getRunCliente());
                if(listaClientes.get(i).getRunCliente().equals(rutSelection)){
                    selectedClient = listaClientes.get(i);
                    selectedIndex = i;
                }
            }

            System.out.println("cliente seleccionado" + selectedClient);

            //subMenu editar Categoria cliente
            System.out.println("-----Actualizando estado del Cliente----");
            System.out.println("El estado actual del cliente es: "+selectedClient.getCategoriaEnum());
            System.out.println("1.-Si desea cambiar el estado del Cliente");
            System.out.println("2.-Si desea mantener el estado del cliente Activo");
            int optionSubmenu1 = sc.nextInt();
            sc.nextLine();

            //Cambiar categoria de cliente
            if(optionSubmenu1 == 1){
                if(selectedClient.getCategoriaEnum()==CategoriaEnum.ACTIVO){
                    selectedClient.setCategoriaEnum(CategoriaEnum.INACTIVO);
                }else{
                    selectedClient.setCategoriaEnum(CategoriaEnum.ACTIVO);
                }

                //Actualizar la lista con el cliente actualizado
                System.out.println("indice "+selectedIndex);
                listaClientes.set(selectedIndex,selectedClient);

            }else if(optionSubmenu1 == 2){
                System.out.println("Estado mantenido");
            }else{
                System.out.println("Escoja una opcion valida");
            }

        }else if(optionMenu==2){

            System.out.println("Ingrese el RUN del Cliente que quiere editar");
            rutSelection = sc.nextLine();

            for(int i=0; i<listaClientes.size(); i++){
                if(listaClientes.get(i).getRunCliente().equals(rutSelection)){
                    selectedClient = listaClientes.get(i);
                    selectedIndex = i;
                }else{
                    System.out.println("El cliente con el rut solicitado no existe");
                }
            }

            //subMenu editar datos clientes
            System.out.println("----Actualizando datos del Cliente-----");
            System.out.println("1.-El RUN del Cliente es: " +selectedClient.getRunCliente());
            System.out.println("2.-El Nombre del Cliente es: "+selectedClient.getNombreCliente());
            System.out.println("3.-El Apellido del Cliente es: "+selectedClient.getApellidoCliente());
            System.out.println("4.-Los años como Cliente son: "+selectedClient.getAniosCliente()+" años");
            System.out.println("Ingrese opcion a editar de los datos del cliente:");
            System.out.println("----------------------------------------");
            int optionSubmenu2 = sc.nextInt();
            sc.nextLine();

            String newData;
            switch (optionSubmenu2){
                case 1:
                    System.out.println("Ingrese nuevo RUN del Cliente");
                    newData = sc.nextLine();
                    selectedClient.setRunCliente(newData);
                    break;
                case 2:
                    System.out.println("Ingrese el nuevo nombre del Cliente");
                    newData = sc.nextLine();
                    selectedClient.setNombreCliente(newData);
                    break;
                case 3:
                    System.out.println("Ingrese el nuevo apellido del Cliente");
                    newData = sc.nextLine();
                    selectedClient.setApellidoCliente(newData);
                    break;
                case 4:
                    System.out.println("Ingrese los años del cliente");
                    int newAnios = sc.nextInt();
                    sc.nextLine();
                    selectedClient.setAniosCliente(newAnios);
                default:
                    System.out.println("opcion incorrecta");
            }

            //Actualizamos la lista con el objeto modificado
            listaClientes.set(selectedIndex,selectedClient);
            System.out.println("Datos cambiados con éxito");

        }else{
            System.out.println("Ingrese una opcion correcta");
        }
    }
}
