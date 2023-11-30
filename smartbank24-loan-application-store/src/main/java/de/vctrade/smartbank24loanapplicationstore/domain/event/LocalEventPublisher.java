package de.vctrade.smartbank24loanapplicationstore.domain.event;

public interface LocalEventPublisher {

    void sende(LoanApplicationPersistiertLocalEvent event);
    void sende(LoanApplicationAcceptedLocalEvent event);
    void sende(LoanApplicationDeniedLocalEvent event);

}
