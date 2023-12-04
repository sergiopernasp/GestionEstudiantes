# GestionEstudiantes
Documentación Programa   // Video explicativo https://www.loom.com/share/c44ae8d443ee4f3c8ff92e8b876b677b?sid=c569b952-071a-40f4-b95d-442195fc4358
una aplicación de consola para gestionar estudiantes en una base de datos MySQL. Permite realizar operaciones como insertar, mostrar, actualizar y eliminar registros de la tabla "estudiantes" en una base de datos local.

Clases y Métodos
Clase: GestionEstudiantes

Método: conectar()
Descripción: Establece la conexión con la base de datos MySQL.
Método: insertarEstudiante(String nombre, String apellido, int edad, String curso)
Descripción: Inserta un nuevo estudiante en la base de datos con los datos proporcionados.
Método: mostrarEstudiantes()
Descripción: Muestra todos los estudiantes almacenados en la base de datos.
Método: actualizarEstudiante(int id, String nombre, String apellido, int edad, String curso)
Descripción: Actualiza la información de un estudiante específico en la base de datos.
Método: eliminarEstudiante(int id)
Descripción: Elimina un estudiante de la base de datos según su ID.
Método: main(String[] args)

Descripción: Es el punto de entrada de la aplicación. Permite al usuario seleccionar opciones para interactuar con la base de datos, como insertar, mostrar, actualizar o eliminar estudiantes.
Funcionamiento
Conexión a la base de datos: La clase GestionEstudiantes contiene un método conectar() que establece una conexión con la base de datos MySQL utilizando el controlador com.mysql.cj.jdbc.Driver.

Operaciones de CRUD: La aplicación ofrece las siguientes opciones al usuario:

Insertar un nuevo estudiante con nombre, apellido, edad y curso.
Mostrar todos los estudiantes almacenados.
Actualizar la información de un estudiante existente mediante su ID.
Eliminar un estudiante de la base de datos según su ID.
Salir de la aplicación.
Interacción con el usuario: Utiliza la clase Scanner para recibir la entrada del usuario y realizar las operaciones correspondientes en la base de datos.
