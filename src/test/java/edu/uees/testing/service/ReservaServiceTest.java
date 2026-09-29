package edu.uees.testing.service;

import edu.uees.testing.availability.DisponibilidadClient;
import edu.uees.testing.domain.EstadoReserva;
import edu.uees.testing.domain.Reserva;
import edu.uees.testing.notification.Notificador;
import edu.uees.testing.repository.ReservaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ReservaServiceTest {

    @Mock
    private DisponibilidadClient disponibilidadClient;

    @Mock
    private ReservaRepository reservaRepository;

    @Mock
    private Notificador notificador; // Agregamos el mock del notificador que faltaba

    @InjectMocks
    private ReservaService servicio;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // --- PRUEBAS DE CANCELACIÓN ---
    @Test
    void dosHorasPermitenCancelar() {
        assertTrue(servicio.puedeCancelar(2));
    }

    @Test
    void cincoHorasPermitenCancelar() {
        assertTrue(servicio.puedeCancelar(5));
    }

    @Test
    void unaHoraNoPermiteCancelar() {
        assertFalse(servicio.puedeCancelar(1));
    }

    // --- PRUEBAS DE DESCUENTOS Y EXCEPCIONES ---
    @Test
    void calcularTotalNormal() {
        assertEquals(100.0, servicio.calcularTotal("NORMAL", 100.0));
    }

    @Test
    void calcularTotalVip() {
        assertEquals(85.0, servicio.calcularTotal("VIP", 100.0));
    }

    @Test
    void calcularTotalEstudiante() {
        assertEquals(90.0, servicio.calcularTotal("ESTUDIANTE", 100.0));
    }

    @Test
    void totalNegativoLanzaExcepcion() {
        assertThrows(
                IllegalArgumentException.class,
                () -> servicio.calcularTotal("NORMAL", -1)
        );
    }

    // --- PRUEBA DE CONFIRMACIÓN (STUBS Y MOCKS) ---
    @Test
    void confirmarReservaDisponible() {
        Reserva reserva = new Reserva("R-001", "ClienteTest");

        // Stub: simulamos que está disponible
        when(disponibilidadClient.estaDisponible(any())).thenReturn(true);

        servicio.confirmar(reserva);

        // Verificaciones (Mock)
        assertEquals(EstadoReserva.CONFIRMADA, reserva.getEstado());
        verify(reservaRepository).guardar(reserva);
        verify(notificador).enviarConfirmacion(reserva); // Verificamos que se intente notificar
    }
}