package com.example.ticketingqueuesystem.controller;

import com.example.ticketingqueuesystem.domain.Ticket;
import com.example.ticketingqueuesystem.service.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.Queue;

@RestController
public class TicketController {

    private final TicketService ticketService;
    private Queue<Ticket> tickets = new LinkedList<>();


    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/peekCurrentTicket")
    public ResponseEntity<?> peekCurrentTicket(){
        Ticket currentTicket = tickets.peek();
        if (currentTicket == null) {
            return ResponseEntity.status(HttpStatus.OK).body("No tickets are currently available.");
        }
        return ResponseEntity.ok(tickets.peek());
    }

    @PostMapping("/issueNewTicket")
    public ResponseEntity<Ticket> issueNewTicket(){
        Ticket takenTicket = ticketService.addToQueue(tickets);
        tickets.add(takenTicket);
        return ResponseEntity.ok(takenTicket);
    }

    @GetMapping("/getCurrentQueueSize")
    public ResponseEntity<Integer> getCurrentQueueSize(){
        return ResponseEntity.ok(tickets.size());
    }

    @GetMapping("/listAllTickets")
    public ResponseEntity<Queue<Ticket>> listAllTickets(){
        return ResponseEntity.ok(tickets);
    }

    @DeleteMapping("/takeTheOneOnTheLine")
    public ResponseEntity<?> removeFirstTicketFromQueue(){
        if (tickets.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("The ticket queue is empty.");
        }
        tickets.poll();
        tickets = ticketService.inFront(tickets);
        return ResponseEntity.ok(tickets);
    }


}
