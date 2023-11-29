package de.vctrade.smartbank24loanapplicationacceptance.adapter.persistence;

import de.vctrade.smartbank24loanapplicationacceptance.adapter.entity.LoanApplicationEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface LoanApplicationPersistence extends CrudRepository<LoanApplicationEntity, UUID> {
}
