package com.springAcademy.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.springAcademy.dtos.IssueTicketRequestDto;
import com.springAcademy.dtos.IssueTicketResponseDto;
import com.springAcademy.dtos.ResponseStatus;
import com.springAcademy.models.Gate;
import com.springAcademy.models.GateStatus;
import com.springAcademy.models.GateType;
import com.springAcademy.models.Operator;
import com.springAcademy.models.VehicleTypes;
import com.springAcademy.repositories.GateRepository;
import com.springAcademy.repositories.ParkingLotRepository;
import com.springAcademy.repositories.TicketRepository;
import com.springAcademy.repositories.VehicleRepository;
import com.springAcademy.services.TicketService;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TicketControllerDiffblueTest {
    /**
     * Test {@link TicketController#issueTicket(IssueTicketRequestDto)}.
     * <p>
     * Method under test:
     * {@link TicketController#issueTicket(IssueTicketRequestDto)}
     */
    @Test
    @DisplayName("Test issueTicket(IssueTicketRequestDto)")
    void testIssueTicket() {
        // Arrange
        GateRepository gateRepository = new GateRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        TicketController ticketController = new TicketController(
                new TicketService(gateRepository, vehicleRepository, parkingLotRepository, new TicketRepository()));

        IssueTicketRequestDto issueTicketRequestDto = new IssueTicketRequestDto();
        issueTicketRequestDto.setGateId(1L);
        issueTicketRequestDto.setOwnerName("Owner Name");
        issueTicketRequestDto.setVehicleNumber("42");
        issueTicketRequestDto.setVehicleType(VehicleTypes.SMALL);

        // Act
        IssueTicketResponseDto actualIssueTicketResult = ticketController.issueTicket(issueTicketRequestDto);

        // Assert
        assertNull(actualIssueTicketResult.getTicket());
        assertEquals(ResponseStatus.FAILURE, actualIssueTicketResult.getResponseStatus());
    }

    /**
     * Test {@link TicketController#issueTicket(IssueTicketRequestDto)}.
     * <p>
     * Method under test:
     * {@link TicketController#issueTicket(IssueTicketRequestDto)}
     */
    @Test
    @DisplayName("Test issueTicket(IssueTicketRequestDto)")
    void testIssueTicket2() {
        // Arrange
        VehicleRepository vehicleRepository = new VehicleRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        TicketController ticketController = new TicketController(
                new TicketService(null, vehicleRepository, parkingLotRepository, new TicketRepository()));

        IssueTicketRequestDto issueTicketRequestDto = new IssueTicketRequestDto();
        issueTicketRequestDto.setGateId(1L);
        issueTicketRequestDto.setOwnerName("Owner Name");
        issueTicketRequestDto.setVehicleNumber("42");
        issueTicketRequestDto.setVehicleType(VehicleTypes.SMALL);

        // Act
        IssueTicketResponseDto actualIssueTicketResult = ticketController.issueTicket(issueTicketRequestDto);

        // Assert
        assertNull(actualIssueTicketResult.getTicket());
        assertEquals(ResponseStatus.FAILURE, actualIssueTicketResult.getResponseStatus());
    }

    /**
     * Test {@link TicketController#issueTicket(IssueTicketRequestDto)}.
     * <p>
     * Method under test:
     * {@link TicketController#issueTicket(IssueTicketRequestDto)}
     */
    @Test
    @DisplayName("Test issueTicket(IssueTicketRequestDto)")
    void testIssueTicket3() {
        // Arrange
        Gate gate = new Gate();
        gate.setCreatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        gate.setGateNumber("42");
        gate.setGateStatus(GateStatus.OPEN);
        gate.setGateType(GateType.ENTRY);
        gate.setId(1L);
        gate.setLastupdatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        gate.setOperator(new Operator());

        GateRepository gateRepository = new GateRepository();
        gateRepository.save(gate);
        VehicleRepository vehicleRepository = new VehicleRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        TicketController ticketController = new TicketController(
                new TicketService(gateRepository, vehicleRepository, parkingLotRepository, new TicketRepository()));

        IssueTicketRequestDto issueTicketRequestDto = new IssueTicketRequestDto();
        issueTicketRequestDto.setGateId(1L);
        issueTicketRequestDto.setOwnerName("Owner Name");
        issueTicketRequestDto.setVehicleNumber("42");
        issueTicketRequestDto.setVehicleType(VehicleTypes.SMALL);

        // Act
        IssueTicketResponseDto actualIssueTicketResult = ticketController.issueTicket(issueTicketRequestDto);

        // Assert
        assertNull(actualIssueTicketResult.getTicket());
        assertEquals(ResponseStatus.FAILURE, actualIssueTicketResult.getResponseStatus());
    }

    /**
     * Test {@link TicketController#issueTicket(IssueTicketRequestDto)}.
     * <ul>
     *   <li>Given {@link TicketController#TicketController(TicketService)} with
     * ticketService is {@code null}.</li>
     * </ul>
     * <p>
     * Method under test:
     * {@link TicketController#issueTicket(IssueTicketRequestDto)}
     */
    @Test
    @DisplayName("Test issueTicket(IssueTicketRequestDto); given TicketController(TicketService) with ticketService is 'null'")
    void testIssueTicket_givenTicketControllerWithTicketServiceIsNull() {
        // Arrange
        TicketController ticketController = new TicketController(null);

        IssueTicketRequestDto issueTicketRequestDto = new IssueTicketRequestDto();
        issueTicketRequestDto.setGateId(1L);
        issueTicketRequestDto.setOwnerName("Owner Name");
        issueTicketRequestDto.setVehicleNumber("42");
        issueTicketRequestDto.setVehicleType(VehicleTypes.SMALL);

        // Act
        IssueTicketResponseDto actualIssueTicketResult = ticketController.issueTicket(issueTicketRequestDto);

        // Assert
        assertNull(actualIssueTicketResult.getTicket());
        assertEquals(ResponseStatus.FAILURE, actualIssueTicketResult.getResponseStatus());
    }

    /**
     * Test {@link TicketController#TicketController(TicketService)}.
     * <p>
     * Method under test: {@link TicketController#TicketController(TicketService)}
     */
    @Test
    @DisplayName("Test new TicketController(TicketService)")
    void testNewTicketController() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     TicketController.ticketService

        // Arrange
        GateRepository gateRepository = new GateRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();

        // Act
        new TicketController(
                new TicketService(gateRepository, vehicleRepository, parkingLotRepository, new TicketRepository()));
    }
}
