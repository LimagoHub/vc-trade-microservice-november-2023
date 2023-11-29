package de.vctrade.smartbank24loanapplicationacceptance.adapter.events.event;

import java.time.LocalDateTime;
import java.util.UUID;

public class GenericEvent<T> {

    UUID id;
    LocalDateTime timestamp;

    T payload;
}
