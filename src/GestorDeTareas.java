import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class GestorDeTareas {
    private ArrayList<Tarea> listaTareas = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void mostrarMenu() {
        int opcion = 1;
        do {
            var menu =
                    """
                            -------------------------------------------------------------------
                            Elija una opcion:
                            1- Agregar tarea
                            2- Listar Tareas
                            3- Editar tarea
                            4- Marcar como completa
                            0- Salir
                            """;

            System.out.println(menu);
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    agregarTarea();
                    break;
                case 2:
                    listarTareas();
                    break;
                case 3:
                    AztualizarTarea();
                    break;
                case 4:
                    CambiarEstadoTarea();
                    break;


                case 0:
                    System.out.println("""             
                            CERRANDO APP....................
                            """);
                    break;
            }
        } while (opcion != 0);
    }


    public void agregarTarea() {
        System.out.print("Ingrese ID de la tarea: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Ingrese titulo: ");
        String titulo = sc.nextLine();

        System.out.print("Ingrese descripción: ");
        String descripcion = sc.nextLine();

        LocalDate fechaVencimiento = null;
        while(fechaVencimiento == null){
            try{
                System.out.print("Ingrese fecha de vencimiento (YYYY-MM-DD): ");
                String fechaStr = sc.nextLine();
                fechaVencimiento = LocalDate.parse(fechaStr);
            }catch (DateTimeParseException e){
                System.out.println("Error!!! Formato de fecha inválido. Intente nuevamente.");
            }
        }

        //Crear tarea
        Tarea nuevaTarea = new Tarea(id, titulo, descripcion, fechaVencimiento);
        listaTareas.add(nuevaTarea);

        System.out.println("Tarea agregada correctamente! ");
    }

    public void listarTareas() {
        if (listaTareas.isEmpty()) {
            System.out.println("No hay tareas registradas.");
        } else {
            System.out.println("Tareas registradas: ");
            for (Tarea tareas : listaTareas) {
                System.out.println("Id: " + tareas.getId() +
                        " | Titulo: " + tareas.getTitulo() +
                        " | Descripcion: " + tareas.getDescripcion() +
                        " | Vence: " + tareas.getFechaDeVencimiento() +
                        " | Estado: " + tareas.getEstado());
                System.out.println("______________________________________");
            }
        }
    }

    public void AztualizarTarea() {
        System.out.println("Ingrese el ID de la tarea que desea actualizar");
        int actualizar = sc.nextInt();
        sc.nextLine();

        boolean tareaEncontrada = false;

        for (int i = 0; i < listaTareas.size(); i++) {
            if (listaTareas.get(i).getId() == actualizar) {
                Tarea tarea = listaTareas.get(i);
                System.out.println("Tarea encontrada: ");
                System.out.println(tarea);// Aqui se muestra la tarea antes de actualizar

                tareaEncontrada = true;


                int opcion;
                do {
                    System.out.println("\n¿Qué desea actualizar?");
                    System.out.println("1. Título");
                    System.out.println("2. Descripción");
                    System.out.println("3. Fecha de vencimiento");
                    System.out.println("4. Salir");
                    System.out.print("Ingrese su opción: ");
                    opcion = sc.nextInt();
                    sc.nextLine(); // Consumir el salto de línea

                    switch (opcion) {
                        case 1:
                            System.out.println("Ingrese el nuevo título:");
                            String nuevoTitulo = sc.nextLine();
                            tarea.setTitulo(nuevoTitulo);
                            System.out.println("Título actualizado.");
                            break;

                        case 2:
                            System.out.println("Ingrese la nueva descripción:");
                            String nuevaDescripcion = sc.nextLine();
                            tarea.setDescripcion(nuevaDescripcion);
                            System.out.println("Descripción actualizada.");
                            break;
                        case 3:
                            System.out.println("Ingrese la nueva fecha de vencimiento (YYYY-MM-DD):");
                            String entradaFecha = sc.nextLine();
                            try {
                                LocalDate nuevaFecha = LocalDate.parse(entradaFecha);
                                tarea.setFechaDeVencimiento(nuevaFecha);
                                System.out.println("Fecha de vencimiento actualizada.");
                            } catch (DateTimeException e) {
                                System.out.println("Formato de fecha inválido. Use YYYY-MM-DD.");
                            }
                            break;

                        case 4:
                            System.out.println("Saliendo del menú de actualización.");
                            break;

                        default:
                            System.out.println("Opción no válida. Intente de nuevo.");
                    }

                    // Mostrar la tarea actualizada después de cada cambio
                    System.out.println("\n Tarea actualizada:");
                    System.out.println(tarea);

                } while (opcion != 4); // Repetir hasta que elija salir

                break; // Salimos del bucle al encontrar la tarea

            }
        }
        if (!tareaEncontrada) {
            System.out.println("Tarea no encontrada.");
        }
    }

    public void CambiarEstadoTarea() {
        System.out.println("Ingrese el ID de la tarea que desea marcar como completada: ");
        int idTarea = sc.nextInt();
        sc.nextLine();
        boolean tareaEncontrada = false;

        for (Tarea tarea : listaTareas) {
            if (tarea.getId() == idTarea) {
                tareaEncontrada = true;


                if(tarea.getEstado().equals("Pendiente")){
                    tarea.setEstado("Completado");
                    System.out.println("La tarea ha sido marcada como 'Completado'.");
                }else {
                    System.out.println("La tarea ya está completada.");
                }

                System.out.println("\nTarea actualizada:");
                System.out.println(tarea);
                break;
            }
        }
    }
}


