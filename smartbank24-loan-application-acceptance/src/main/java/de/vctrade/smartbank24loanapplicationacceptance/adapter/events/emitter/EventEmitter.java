package de.vctrade.smartbank24loanapplicationacceptance.adapter.events.emitter;


import de.vctrade.smartbank24loanapplicationacceptance.adapter.events.event.LoanApplicationAcceptedEvent;
import de.vctrade.smartbank24loanapplicationacceptance.adapter.mapper.LoanApplicationDTOMapper;
import de.vctrade.smartbank24loanapplicationacceptance.domain.model.LoanApplication;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventEmitter {

    private static final String SUPPLIER_BINDIN_NAME = "loan-application-accepted-out-0";
    private final StreamBridge bridge;
    private final LoanApplicationDTOMapper mapper;

    @EventListener // Eventlistener for inner Spring events
    public void send(LoanApplication loanApplication) {
          bridge.send(SUPPLIER_BINDIN_NAME, new LoanApplicationAcceptedEvent(mapper.convert(loanApplication)));
    }

}
