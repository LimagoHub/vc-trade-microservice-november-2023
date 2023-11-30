package de.vctrade.smartbank24loanapplicationscoring.adapter.listerner;


import de.vctrade.smartbank24loanapplicationscoring.adapter.mapper.LoanApplicationDTOMapper;
import de.vctrade.smartbank24loanapplicationscoring.application.events.LoanApplicationEvent;
import de.vctrade.smartbank24loanapplicationscoring.application.handler.LoanApplicationHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class MyEventListener {

    @Bean
    public Consumer<LoanApplicationEvent> loanApplicationPersisted (final LoanApplicationHandler handler, final LoanApplicationDTOMapper mapper) {
        System.out.println("Consumer registered");
        return event->{
                handler.handleScoring(mapper.convert(event.getLoanApplicationDTO()));
            System.out.println(event+ " Detected");
        };
    }
}
