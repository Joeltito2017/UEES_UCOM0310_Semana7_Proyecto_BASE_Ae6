| ID | Método | Escenario | Entrada | Esperado | Tipo |
| :--- | :--- | :--- | :--- | :--- | :--- |
| CP-01 | puedeCancelar | Normal | 5 días de anticipación | true | Normal |
| CP-02 | puedeCancelar | Límite válido | 2 días de anticipación | true | Límite |
| CP-03 | puedeCancelar | Debajo del límite | 1 día de anticipación | false | Límite |
| CP-04 | calcularTotal | Descuento VIP | "VIP", monto 100 | 85 | Alternativo |
| CP-05 | calcularTotal | Descuento Normal | "NORMAL", monto 100 | 100 | Normal |
| CP-06 | calcularTotal | Monto Negativo | "NORMAL", monto -1 | Excepción (IllegalArgumentException) | Inválido |
| CP-07 | calcularTotal | Estudiante | "ESTUDIANTE", monto 100 | 90 | Alternativo |
| CP-08 | confirmar | Reserva Disponible | ID: R-001, disponible: true | Estado: CONFIRMADA | Normal |
| CP-09 | confirmar | No disponible | ID: R-002, disponible: false | Excepción (IllegalStateException) | Alternativo |
| CP-10 | confirmar | Reserva Nula | null | Excepción (NullPointerException) | Inválido |