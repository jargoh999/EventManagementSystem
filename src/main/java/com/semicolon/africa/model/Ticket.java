package com.semicolon.africa.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Ticket {
@Id
@GeneratedValue(strategy = GenerationType.AUTO )
private Long id;
  @ManyToOne
  @Nullable
  private Event event;
  @Enumerated(value = EnumType.STRING)
  private TicketType ticketType;
  private BigDecimal price;
  @OneToOne
  @Nullable
  private Discount discount;
  @Enumerated(value = EnumType.STRING)
  private TicketStatus ticketStatus;
}
