package de.vctrade.smartbank24loanapplicationacceptance.domain.service.internal;

import de.vctrade.smartbank24loanapplicationacceptance.domain.model.LoanApplication;
import de.vctrade.smartbank24loanapplicationacceptance.domain.repository.LoanApplicationRepository;
import de.vctrade.smartbank24loanapplicationacceptance.domain.service.LoanApplicationQueryService;
import de.vctrade.smartbank24loanapplicationacceptance.domain.service.LoanApplicatonCommandService;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.UUID;


@RequiredArgsConstructor
public class LoanApplicationServiceImpl implements LoanApplicationQueryService, LoanApplicatonCommandService {


    private final LoanApplicationRepository repo;

    public Optional<LoanApplication> findLoanApplivationById(final UUID id) {
        return repo.findById(id);
    }

    @Override
    public Iterable<LoanApplication> findAllLoanApplications() {
        return repo.findAll();
    }

    @Override
    public void accept(final LoanApplication application) {
        // Validation
        // Business check
        repo.create(application);
    }
}
