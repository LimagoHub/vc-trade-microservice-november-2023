package de.vctrade.smartbank24loanapplicationacceptance.application;

import de.vctrade.smartbank24loanapplicationacceptance.domain.model.LoanApplication;

public interface LoanApplicationHandler {

    void handle(LoanApplication loanApplication);
}
