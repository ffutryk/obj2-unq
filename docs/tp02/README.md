# Trabajo Práctico Nº2 | UML

2.c) Para extender el modelo agregando a los empleados contratados, no necesité modificar la clase `Empresa`. El conjunto de empleados en `Empresa` está definido como un `Set<Empleado>`, y `EmpleadoContratado` es una subclase de `Empleado`. Por lo tanto, hereda y puede extender la interfaz de `Empleado`, lo que permite que pueda ser tratado como un `Empleado` dentro de `Empresa` gracias al polimorfismo.
