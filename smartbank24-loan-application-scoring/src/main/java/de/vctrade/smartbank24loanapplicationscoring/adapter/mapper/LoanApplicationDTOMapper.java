package de.vctrade.smartbank24loanapplicationscoring.adapter.mapper;


import de.vctrade.smartbank24loanapplicationscoring.adapter.dto.LoanApplicationDTO;
import de.vctrade.smartbank24loanapplicationscoring.domain.aggregates.LoanApplication;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface LoanApplicationDTOMapper {
    LoanApplication convert(LoanApplicationDTO dto);
}
