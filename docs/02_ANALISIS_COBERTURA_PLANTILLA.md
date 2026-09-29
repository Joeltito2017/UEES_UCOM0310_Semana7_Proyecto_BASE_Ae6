# Análisis de Cobertura de Pruebas

## Resultados Obtenidos
* **Total de Pruebas Ejecutadas:** 8
* **Pruebas Exitosas:** 8
* **Pruebas Fallidas:** 0
* **Cobertura estimada de métodos:** 100% de los métodos principales de `ReservaService` evaluados (cancelaciones, cálculos con descuentos, excepciones y confirmación con Mocks).

## Observaciones
* Las pruebas unitarias cubren los caminos felices (casos normales y VIP/estudiante) y los caminos alternativos (límites de cancelación y excepciones por montos negativos o reservas no disponibles).
* El uso de Mockito permitió aislar correctamente las dependencias externas como el `DisponibilidadClient` y el repositorio.