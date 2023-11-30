package de.vctrade.smartbank24loanapplicationstore.adapter.repositories.impl;


import de.vctrade.smartbank24loanapplicationstore.adapter.mapper.LoanApplicationMapper;
import de.vctrade.smartbank24loanapplicationstore.adapter.repositories.LoanApplicationPersistence;
import de.vctrade.smartbank24loanapplicationstore.domain.aggregate.LoanApplication;
import de.vctrade.smartbank24loanapplicationstore.domain.repository.LoanApplicationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@AllArgsConstructor
public class LoanApplicationRepositoryImpl implements LoanApplicationRepository {

    private final LoanApplicationPersistence persistence;
    private final LoanApplicationMapper mapper;

    @Override
    public void anlegen(LoanApplication antrag) {
        persistence.save(mapper.convert(antrag));
    }

    @Override
    public boolean existenzPruefen(LoanApplication k) {
        return persistence.existsById(k.getCreditApplicationId());
    }

    @Override
    public Optional<LoanApplication> findeAntragNachId(UUID id) {
        return persistence.findById(id).map(mapper::convert);
    }

    @Override
    public Iterable<LoanApplication> findeAlle() {
        return mapper.convert(persistence.findAll());
    }
}
