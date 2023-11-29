package de.vctrade.smartbank24loanapplicationacceptance.adapter.persistence.internal;

import de.vctrade.smartbank24loanapplicationacceptance.adapter.mapper.LoanApplicationMapper;
import de.vctrade.smartbank24loanapplicationacceptance.adapter.persistence.LoanApplicationPersistence;
import de.vctrade.smartbank24loanapplicationacceptance.domain.model.LoanApplication;
import de.vctrade.smartbank24loanapplicationacceptance.domain.repository.LoanApplicationRepository;
import de.vctrade.smartbank24loanapplicationacceptance.domain.service.LoanApplicationServiceException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Repository
public class LoadApplicationRepositoryImpl implements LoanApplicationRepository {
    private final LoanApplicationPersistence persistence;
    private final LoanApplicationMapper mapper;
    @Override
    public void create(final LoanApplication loanApplication) {
        try {
            if(persistence.existsById(loanApplication.getCreditApplicationId()))
                throw new LoanApplicationServiceException("loan application already exists");
            persistence.save(mapper.convert(loanApplication));
        } catch (LoanApplicationServiceException e) {
            throw e;
        }
        catch (Exception e) {
            throw new LoanApplicationServiceException("can not save the application", e);
        }
    }

    @Override
    public boolean exitsById(final UUID id) {
        try {
            return persistence.existsById(id);
        } catch (Exception e) {
            throw new LoanApplicationServiceException("can not check the application", e);
        }
    }

    @Override
    public Optional<LoanApplication> findById(final UUID id) {
        try {
            return persistence.findById(id).map(mapper::convert);
        } catch (Exception e) {
            throw new LoanApplicationServiceException("error", e);
        }
    }

    @Override
    public Iterable<LoanApplication> findAll() {
        try {
            return mapper.convert(persistence.findAll());
        } catch (Exception e) {
            throw new LoanApplicationServiceException("error", e);
        }
    }
}
