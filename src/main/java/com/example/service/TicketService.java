package com.example.service;

import com.example.dto.TicketCreatedto;
import com.example.model.Ticket;
import java.util.List;

public interface TicketService {
    Ticket createTicket(TicketCreatedto ticketCreateDto);
    List<Ticket> getAllTickets();
    Ticket getTicketById(Long id);
}