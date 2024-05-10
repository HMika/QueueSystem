# Queue System Application

## Overview
This application is a simple queue system built with Spring Boot. It provides a RESTful API to manage a ticket queue, allowing users to peek the current ticket, issue new tickets, get the current queue size, list all tickets, and remove the first ticket from the queue.

## Features
- **Peek Current Ticket**: View the current ticket without removing it from the queue.
- **Issue New Ticket**: Add a new ticket to the queue.
- **Get Current Queue Size**: Retrieve the current size of the ticket queue.
- **List All Tickets**: List all tickets currently in the queue.
- **Remove First Ticket**: Remove the first ticket from the queue and update the positions of the remaining tickets.

## API Endpoints

| Method | Endpoint               | Description                             |
|--------|------------------------|-----------------------------------------|
| GET    | `/peekCurrentTicket`   | Returns the current ticket.             |
| GET    | `/issueNewTicket`      | Adds a new ticket to the queue.         |
| GET    | `/getCurrentQueueSize` | Returns the size of the queue.          |
| GET    | `/listAllTickets`      | Lists all the tickets in the queue.     |
| GET    | `/takeTheOneOnTheLine` | Removes the first ticket from the queue.|
