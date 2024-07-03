package com.africa.semicolon.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Builder
@Setter
@Getter
@RequiredArgsConstructor
public class Ticket {
@Id
@GeneratedValue
private Long id;
  @ManyToOne
  @Nullable
  private Event event;
  @Enumerated(value = EnumType.STRING)
  private TicketType table;
  private BigDecimal price;
  @OneToOne
  @Nullable
  private Discount discount;
  @Enumerated(value = EnumType.STRING)
  private TicketStatus ticketStatus;
}
