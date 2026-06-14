package com.example.controller;

import com.example.dto.TicketCreatedto;
import com.example.model.Ticket;
import com.example.service.TicketService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping
    public String showTickets(Model model) {
        model.addAttribute("tickets", ticketService.getAllTickets());
        return "tickets";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("ticket", new TicketCreatedto());
        return "ticket-form";
    }

    @PostMapping
    public String createTicket(
            @Valid @ModelAttribute("ticket") TicketCreatedto ticketCreateDto,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "ticket-form";
        }
        Ticket savedTicket = ticketService.createTicket(ticketCreateDto);
        return "redirect:/tickets/" + savedTicket.getId() + "/success";
    }

    @GetMapping("/{id}/success")
    public String showSuccessPage(@PathVariable Long id, Model model) {
        Ticket ticket = ticketService.getTicketById(id);
        model.addAttribute("ticket", ticket);
        return "ticket-success";
    }
}