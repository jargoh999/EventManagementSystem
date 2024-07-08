package com.semicolon.africa.model;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Ticket {
@Id
@GeneratedValue(strategy = GenerationType.AUTO )
private UUID id;
  @ManyToOne
  @Nullable
  @JoinTable(name = "event_tickets")
  private Event event;
  @Enumerated(value = EnumType.STRING)
  private TicketType ticketType;
  private BigDecimal price;
  @OneToOne
  @Nullable
  private Discount discount;
}
