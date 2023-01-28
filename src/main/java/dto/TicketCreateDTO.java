package dto;

import entities.Ticket;
import lombok.Data;

@Data
public class TicketCreateDTO {
    private Ticket ticket;
    private Long authorId;
}
