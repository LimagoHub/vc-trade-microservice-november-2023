package de.vctrade.smartbank24loanapplicationacceptance.application.internal;

import de.vctrade.smartbank24loanapplicationacceptance.application.LoanApplicationHandler;
import de.vctrade.smartbank24loanapplicationacceptance.domain.model.LoanApplication;
import de.vctrade.smartbank24loanapplicationacceptance.domain.service.LoanApplicatonCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional(propagation = Propagation.REQUIRED)
public class LoanApplicationHandlerImpl implements LoanApplicationHandler {

    private final LoanApplicatonCommandService service;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void handle(final LoanApplication loanApplication) {
        service.accept(loanApplication);
        // Be sure to fire event after the database operation is commited
        applicationEventPublisher.publishEvent(loanApplication); // If the event failes DB Actions will roll back
        // undo database operation if publish event failed
    }
}
