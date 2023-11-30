package de.vctrade.smartbank24loanapplicationscoring.application.handler.internal;


import de.vctrade.smartbank24loanapplicationscoring.application.events.service.EventService;
import de.vctrade.smartbank24loanapplicationscoring.application.handler.LoanApplicationHandler;
import de.vctrade.smartbank24loanapplicationscoring.domain.aggregates.LoanApplication;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LoanApplicationHandlerImpl implements LoanApplicationHandler {

    private final EventService eventService;
    @Override
    public void handleScoring(final LoanApplication application) {
        if(application.isSolvent()) {
            eventService.publishScoringPositivEvent(application.getCreditApplicationId());
        } else {
            eventService.publishScoringNegativEvent(application.getCreditApplicationId());
        }
    }
}
