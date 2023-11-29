package de.vctrade.smartbank24loanapplicationacceptance.adapter.mapper;


import de.vctrade.smartbank24loanapplicationacceptance.adapter.dto.LoanApplicationDTO;
import de.vctrade.smartbank24loanapplicationacceptance.domain.model.LoanApplication;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface LoanApplicationDTOMapper {
    LoanApplicationDTO convert(LoanApplication loanApplication);
    LoanApplication convert(LoanApplicationDTO dto);

    Iterable<LoanApplicationDTO> convert(Iterable<LoanApplication> applications);
}
