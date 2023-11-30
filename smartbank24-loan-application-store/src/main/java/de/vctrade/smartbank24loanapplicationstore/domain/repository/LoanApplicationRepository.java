package de.vctrade.smartbank24loanapplicationstore.domain.repository;

import de.vctrade.smartbank24loanapplicationstore.domain.aggregate.LoanApplication;

import java.util.Optional;
import java.util.UUID;

public interface LoanApplicationRepository {

    void anlegen(LoanApplication application);

    boolean existenzPruefen(LoanApplication application);

    Optional<LoanApplication> findeAntragNachId(UUID id);

    Iterable<LoanApplication> findeAlle();
}
