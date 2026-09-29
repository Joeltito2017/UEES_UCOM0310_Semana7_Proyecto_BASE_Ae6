# Pull Request: Implementación de Suite de Pruebas Unitarias y Mocks

## Descripción
Se ha implementado una suite completa de pruebas unitarias utilizando JUnit 5 y Mockito para la clase `ReservaService`.

## Cambios realizados
* Creación de casos de prueba para el método `puedeCancelar` (incluyendo valores límite).
* Pruebas de lógica de negocio para `calcularTotal` (descuentos Normal, VIP, Estudiante y manejo de excepciones por valores negativos).
* Implementación de pruebas con Stubs y Mocks para el flujo de confirmación de reservas.
* Documentación de la matriz de pruebas y análisis de cobertura en la carpeta `docs`.

## Checklist
- [x] Pruebas unitarias ejecutadas exitosamente (8/8 en verde).
- [x] Matriz de casos documentada.
- [x] Análisis de cobertura completado.