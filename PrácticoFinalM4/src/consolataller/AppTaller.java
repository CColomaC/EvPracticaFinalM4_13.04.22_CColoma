package consolataller;


	import java.time.LocalDate;
	import java.util.Scanner;
	import taller.*;
	import java.util.ArrayList;


	public class AppTaller {
		
		//Scanner estático para uso a lo largo del código
		static Scanner scanner = new Scanner(System.in);
		
		// ArrayList de los objetos que se utilizarán
		private static ArrayList<Vehiculo> vehiculos 		= new ArrayList<>();
		private static ArrayList<Cliente> clientes			= new ArrayList<>();
		private static ArrayList<Mantencion> mantenciones 	= new ArrayList<>();
		
		
		private final static int OPCION_MENU_CREAR_CLIENTE 		= 1;
		private final static int OPCION_MENU_CREAR_MANTENCION 	= 2;
		private final static int OPCION_MENU_ELIMINAR_CLIENTE 	= 3;
		private final static int OPCION_MENU_LISTA_MANTENCIONES = 4;
		private final static int OPCION_MENU_VER_CLIENTES 		= 5;
		private final static int OPCION_MENU_RECAUDACIONES 		= 6;
		private final static int OPCION_MENU_SALIR 				= 0;
		
		public static void main(String[] args) {
	
			menu();

		}

		private static void menu() {
			int opcion = 99;
			
			// Bucle hasta que el usuario escoja opción SALIR.
			do {
				System.out.printf("Operando sistema taller%n"
								+"========================%n"
								+"1. Crear cliente%n"
								+"2. Crear mantencion vehiculo%n"
								+"3. Eliminar cliente%n"
								+"4. Lista de mantenciones%n"
								+"5. Ver clientes%n"
								+"6. Recaudaciones del dia%n%n"
								+"0. Salir%n%n"
								+"Escoja una opcion%n");
				
				try {
					
				// Toma un int del usuario para ejecutar una opción si está en las alternativas.
					opcion = scanner.nextInt();
		
					switch(opcion) {
						case OPCION_MENU_CREAR_CLIENTE:
							crearCliente();
							break;
						case OPCION_MENU_CREAR_MANTENCION:
							crearMantencion();
							break;
						case OPCION_MENU_ELIMINAR_CLIENTE:
							eliminarCliente();
							break;
						case OPCION_MENU_LISTA_MANTENCIONES:
							listarMantenciones();
							break;
						case OPCION_MENU_VER_CLIENTES:
							verClientes();
							break;	
						case OPCION_MENU_RECAUDACIONES:
							verRecaudaciones();
							break;
						case OPCION_MENU_SALIR:
							System.out.println("Programa Cerrado.");
							break;
						default:
							System.out.println("Opción inválida, vuelva a intentarlo\n\n");
							break;
					}
				}catch(Exception e){
					System.out.println("Ingreso no valido.\n");
					scanner.nextLine();
				}	
			}while(opcion != OPCION_MENU_SALIR);
			
		}
		
		private static void crearCliente() {
			scanner.nextLine(); 
			
				System.out.println("Digite RUT del cliente");
			String rutCliente = scanner.nextLine();
			
			//Busca al cliente con el rut y si existe en los registros, se salta el resto del método y pasa directo a añadir vehículos.
			for(Cliente cli : clientes) {
				if (cli.getRut().equalsIgnoreCase(rutCliente)) {
					agregarVehiculos(cli);	
					break;
				}
			}
			
			System.out.println("No existe cliente. Registre a nuevo cliente.");
			System.out.println("Escriba nombres del cliente");
			String nombresCliente = scanner.nextLine();
			
			System.out.println("Escriba apellidos del cliente");
			String apellidosCliente = scanner.nextLine();
			
			System.out.println("Escriba correo del cliente");
			String correoCliente = scanner.nextLine();

			System.out.println("Digite teléfono del cliente");
			String fonoCliente = scanner.nextLine();
			
			//CREACION CLIENTE CON DATOS SOLICITADOS
			Cliente cliente = new Cliente(nombresCliente,apellidosCliente,rutCliente,correoCliente,fonoCliente);
			clientes.add(cliente);
			
			//Agrega los vehículos para el cliente. Envía al cliente recién creado como parametro
			agregarVehiculos(cliente);
		}
		
		private static void crearMantencion() {
			try {
						
				// Guarda los datos de vehiculos a mantener
				String stringVehiculo = "";
				
				// Usa los datos de vehiculos registrados añadiendolos al string. Caso contrario arroja error.
				if (vehiculos.size() > 0) {
				System.out.println("VEHICULOS REGISTRADOS SIN MANTENCION");
				
					for (Vehiculo vehiculo : vehiculos){
						if (vehiculo.isMantenido() == false) {
						
						stringVehiculo += "=======================================\n"
									 +"PPU VEHICULO: "+vehiculo.getPpu()+"\n"
									 +"MARCA VEHICULO: "+vehiculo.getMarca()+"\n"
									 +"MODELO VEHICULO: "+vehiculo.getModelo()+"\n"
									 +"FABRICACION VEHICULO: "+vehiculo.getFecha()+"\n"
									 +"DUEÑO VEHICULO: "+vehiculo.getDueño().getNombres()+" "+vehiculo.getDueño().getApellidos()+"\n"
									 +"=======================================\n";
					}
				}
			}else {
				System.out.println("NO HAY VEHICULOS REGISTRADOS.");
				throw new Exception("No hay vehiculos registrados");
				
			}
				//Se chequea si stringVehículo fue modificado. Si = vacio, no hay vehículos a los que hacer mantencion, cancela y vuelve al menú.
			if(stringVehiculo.equalsIgnoreCase("")) {
				System.out.println("NO HAY VEHICULOS A LOS QUE HACER MANTENCION");
				throw new Exception("No hay vehiculos que mantener");
			}
			
			// Muestra en pantalla los vehiculos disponibles para hacer mantencion
			System.out.println(stringVehiculo);
			
			
			scanner.nextLine(); 
			
			// Pide la PPU del vehiculo que ha sido mantenido
			System.out.println("Digite PPU del vehiculo al que se ha hecho mantencion");
			String ppuMantencion = scanner.nextLine();
			
			// Declara a un Vehiculo como nulo para una futura asignacion
			Vehiculo vehiculoMantencion = null;
			
			// BUSCA EL VEHICULO
			for(Vehiculo vehiculo : vehiculos) {
				if(ppuMantencion.equalsIgnoreCase(vehiculo.getPpu())) {
					vehiculoMantencion = vehiculo;
				}
			}
			
			// Si esta variable es nula cancela todo. 
			if (vehiculoMantencion == null){
				System.out.println("VEHICULO NO ENCONTRADO");
				throw new Exception("Vehiculo no encontrado");
			}
			
			// Solicita los datos para la creacion de un objeto Mantencion
			System.out.println("Digite la mantencion realizada");
			String tipoMantencion = scanner.nextLine();
			
			System.out.println("Anote observaciones");
			String observacionesMantencion = scanner.nextLine();
			
			System.out.println("Digite monto cobrado");
			int montoMantencion = scanner.nextInt(); 
			

			//CREA EL OBJETO MANTENCION Y LO AGREGA A ARRALIST MANTENCIONES
			Mantencion mantencion = new Mantencion(tipoMantencion,observacionesMantencion,montoMantencion,vehiculoMantencion,LocalDate.now());
			mantenciones.add(mantencion);
			//Setea el estado de mantenido del vehículo a true.
			vehiculoMantencion.setMantenido(true);
			}catch (Exception e) {
			}
		}
		
		private static void eliminarCliente() {
			scanner.nextLine();
			
			//Busca al cliente por rut y  elimina todos los vehiculos asociados al mismo cliente.
			//Si uno de los vehiculos asociados ya ha sido mantenido, no lo elimina, para poder mantenerlo en el registro.
			System.out.println("Digite el rut de cliente a eliminar: ");
			String rut = scanner.nextLine();
			
			for (Cliente cli : clientes) {
				if(rut.equalsIgnoreCase(cli.getRut())) {
					
					for (Vehiculo vehiculo : vehiculos) {
						if(vehiculo.getDueño().getRut().equalsIgnoreCase(rut) && vehiculo.isMantenido() == false) {
							System.out.println("Vehiculo eli: "+vehiculo.getPpu());
							vehiculos.remove(vehiculo);
						}
					}
					
					System.out.printf("Se ha eliminado el cliente: %s %n%n", cli.getNombres());
					clientes.remove(cli);
					break;
				}
			}		
		}
		
		private static void listarMantenciones() {
			System.out.println("Lista de mantenciones realizadas: \n===============================================");
			
			// Muestra los datos en la App por cada mantención realizada
			for(Mantencion mantencion : mantenciones) {
				System.out.println("PPU VEHICULO MANTENIDO: "+mantencion.getVehiculo().getPpu());
				System.out.println("FECHA DE MANTENCION: "+mantencion.getFechaMantencion());
				System.out.println("DUEÑO DE VEHICULO MANTENIDO: "+mantencion.getVehiculo().getDueño().getNombres()+" "+mantencion.getVehiculo().getDueño().getApellidos());
				System.out.println("TIPO DE MANTENCION: "+mantencion.getMantencionRealizada());
				System.out.println("OBSERVACIONES: "+mantencion.getObservaciones());
				System.out.println("MONTO: "+mantencion.getMontoServicio());
				System.out.println("===========================================\n");
			}		
		}
		
		private static void verClientes() {
			for (Cliente cliente : clientes) {		
				System.out.printf("NOMBRE CLIENTE: %s %s%n"
								+ "RUT CLIENTE: %s%n"
								+ "FONO CLIENTE: %s%n"
								+ "CORREO CLIENTE: %s%n"
								+ "VEHICULOS REGISTRADOS: %n%n",
								cliente.getNombres(), cliente.getApellidos(),
								cliente.getRut(),
								cliente.getFono(),
								cliente.getCorreo());
				
				System.out.println(cliente.vehiculosCliente());
			}
			
		}

		private static void verRecaudaciones() {
			// Declara int para recaudaciones y vehiculos mantenidos, aumentará el valor por cada mantención realizada
			int recaudaciones = 0;
			int vehiculosMantenidos = 0;
			
			for(Mantencion mantencion : mantenciones) {
				recaudaciones += mantencion.getMontoServicio();
				vehiculosMantenidos++;
			}
			// Invoca método listarMantenciones y muestra un listado de los vehiculos a los que se les hizo mantencion
			listarMantenciones();
			System.out.printf("Recaudaciones totales: $%d%n "
							+ "Vehiculos mantenidos: %d %n%n",
							recaudaciones,
							vehiculosMantenidos);
			
		}

			public static void agregarVehiculos(Cliente cliente){

			// Se repite según la cantidad de vehiculos del cliente
			boolean agregarVehiculos = true;
			try {
			do {
				System.out.println("Digite PPU del vehículo");
				String ppuVehiculo = scanner.nextLine().toUpperCase();
				
				System.out.println("Escriba la marca del vehículo");
				String marcaVehiculo = scanner.nextLine();
				
				System.out.println("Escriba el modelo del vehículo");
				String modeloVehiculo = scanner.nextLine();
				
				System.out.println("Digite año de fabricación del vehículo");
				int yearVehiculo = scanner.nextInt();
				if (yearVehiculo < 1960 || String.valueOf(yearVehiculo).length() > 4) {
					throw new Exception("Parametros invalidos. Intente de nuevo");
				}
							
				// Crea el objeto Vehiculo.
				Vehiculo vehiculo = new Vehiculo(ppuVehiculo,marcaVehiculo,modeloVehiculo,yearVehiculo,cliente,false);
				vehiculos.add(vehiculo);
				cliente.addVehiculo(vehiculo); 
				
				scanner.nextLine(); 
				
				System.out.println("¿Desea seguir añadiendo vehículos? (si/no)");
				String decision = scanner.nextLine();
				
				if(decision.equalsIgnoreCase("NO")) {
					agregarVehiculos = false;
					break;
				}	
			}while(agregarVehiculos);
			}catch(Exception e) {
				System.out.println("PARAMETROS INVALIDOS. INTENTE DE NUEVO");
			}
		}
	}
	