package de.vctrade.smartbank24loanapplicationacceptance.adapter.events.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class BaseEvent {
    @Builder.Default
    private UUID eventID = UUID.randomUUID();
    @Builder.Default
    private LocalDateTime eventTimestamp = LocalDateTime.now();
}
