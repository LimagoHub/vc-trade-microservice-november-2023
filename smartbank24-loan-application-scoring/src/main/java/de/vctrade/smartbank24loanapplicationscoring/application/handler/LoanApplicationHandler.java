package de.vctrade.smartbank24loanapplicationscoring.application.handler;


import de.vctrade.smartbank24loanapplicationscoring.domain.aggregates.LoanApplication;

public interface LoanApplicationHandler {
    void handleScoring(LoanApplication application);
}
