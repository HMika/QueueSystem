package com.example.ticketingqueuesystem.service;

import com.example.ticketingqueuesystem.domain.Ticket;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Queue;

@Service
public class TicketService {

    public Ticket addToQueue(Queue<Ticket> tickets) {
        Ticket t = Ticket.builder()
                .id(incrementId(tickets))
                .time(LocalDateTime.now())
                .placement(tickets.size())
                .build();

        return t;
    }

    private static int incrementId(Queue<Ticket> tickets) {
        int lastId = 0;

        if (tickets.isEmpty()) {
            return 1;
        }
        for (Ticket t : tickets) {
            if (t.getId() > lastId) {
                lastId = t.getId();
            }
        }

        return lastId+1;
    }

    public Queue<Ticket> inFront (Queue<Ticket> tickets) {
        for (Ticket t : tickets) {
            t.setPlacement(t.getPlacement()-1);
        }
         return tickets;
    }


}
