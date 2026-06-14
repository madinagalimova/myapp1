package com.example.service;

import com.example.dto.TicketCreatedto;
import com.example.model.Ticket;
import com.example.model.TicketStatus;
import com.example.repository.TicketRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Ticket createTicket(TicketCreatedto ticketCreateDto) {
        Ticket ticket = new Ticket();
        ticket.setCustomerName(ticketCreateDto.getCustomerName());
        ticket.setTitle(ticketCreateDto.getTitle());
        ticket.setDescription(ticketCreateDto.getDescription());
        ticket.setStatus(TicketStatus.NEW);
        ticket.setCreatedAt(LocalDateTime.now());
        return ticketRepository.save(ticket);
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Заявка не найдена: " + id));
    }
}