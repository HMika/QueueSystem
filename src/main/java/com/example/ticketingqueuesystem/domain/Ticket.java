package com.example.ticketingqueuesystem.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Ticket {
    private int id;
    private LocalDateTime time;
    private int placement;
}
