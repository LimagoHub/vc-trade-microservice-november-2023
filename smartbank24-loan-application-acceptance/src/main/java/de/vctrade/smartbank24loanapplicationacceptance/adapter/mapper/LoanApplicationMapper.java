package de.vctrade.smartbank24loanapplicationacceptance.adapter.mapper;


import de.vctrade.smartbank24loanapplicationacceptance.adapter.entity.LoanApplicationEntity;
import de.vctrade.smartbank24loanapplicationacceptance.domain.model.LoanApplication;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface LoanApplicationMapper {
    LoanApplication convert(LoanApplicationEntity loanApplicationEntity);
    LoanApplicationEntity convert(LoanApplication loanApplication);

    Iterable<LoanApplication> convert(Iterable<LoanApplicationEntity> entities);
}
