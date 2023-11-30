package de.vctrade.smartbank24loanapplicationstore.application.commandHandler;

import de.vctrade.smartbank24loanapplicationstore.domain.aggregate.LoanApplication;

import java.util.UUID;

public interface LoanApplicationHandler {

    void handleKreditantragRegistriert(LoanApplication application);
    void handleScoringPositiv(UUID id);
    void handleScoringNegativ(UUID id);
    void handleCityScoringPositiv(UUID id);
    void handleCityScoringNegativ(UUID id);
}
