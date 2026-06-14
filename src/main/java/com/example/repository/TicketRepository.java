package com.example.repository;

import com.example.model.Ticket;
import com.example.model.TicketStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findAllByOrderByCreatedAtDesc();
    List<Ticket> findByStatus(TicketStatus status);
}