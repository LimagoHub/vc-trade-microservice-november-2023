package de.vctrade.smartbank24loanapplicationacceptance.domain.service;

import de.vctrade.smartbank24loanapplicationacceptance.domain.model.LoanApplication;

import java.util.Optional;
import java.util.UUID;

public interface LoanApplicationQueryService {

    Optional<LoanApplication> findLoanApplivationById(UUID id);
    Iterable<LoanApplication> findAllLoanApplications();
}
