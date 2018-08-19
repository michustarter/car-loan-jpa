package com.capgemini.mappers;

import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.domain.LoanEntity;
import com.capgemini.to.LoanTO;
import com.capgemini.to.LoanTO.LoanTOBuilder;

public class LoanMapper {

	public static LoanTO toLoanTO(LoanEntity loanEntity) {
		if(loanEntity==null) {
			return null;
		}
		return new LoanTOBuilder()
				.withId(loanEntity.getId())
				.withCustomer(CustomerMapper.toCustomerTO(loanEntity.getCustomer()))
				.withCar(CarMapper.toCarTO(loanEntity.getCar()))
				.withOfficeFrom(OfficeMapper.toOfficeTO(loanEntity.getOfficeFrom()))
				.withOfficeTo(OfficeMapper.toOfficeTO(loanEntity.getOfficeTo()))
				.withRentalDate(loanEntity.getRentalDate())
				.withReturnDate(loanEntity.getReturnDate())
				.withLoanPrice(loanEntity.getLoanPrice())
				.build();
	}
	
	public static LoanEntity toLoanEntity(LoanTO loanTO) {
		if(loanTO==null) {
			return null;
		}
		LoanEntity loanEntity=new LoanEntity();
		loanEntity.setId(loanTO.getId());
		loanEntity.setCustomer(CustomerMapper.toCustomerEntity(loanTO.getCustomer()));
		loanEntity.setCar(CarMapper.toCarEntity(loanTO.getCar()));
		loanEntity.setOfficeFrom(OfficeMapper.toOfficeEntity(loanTO.getOfficeFrom()));
		loanEntity.setOfficeTo(OfficeMapper.toOfficeEntity(loanTO.getOfficeTo()));
		loanEntity.setRentalDate(loanTO.getRentalDate());
		loanEntity.setReturnDate(loanTO.getReturnDate());
		loanEntity.setLoanPrice(loanTO.getLoanPrice());
		return loanEntity;
	}
		public static List<LoanTO> map2TOs(List<LoanEntity> loanEntities) {
			return loanEntities.stream().map(LoanMapper::toLoanTO).collect(Collectors.toList());
		}
		public static List<LoanEntity> map2Entities(List<LoanTO> loanTOs) {
			return loanTOs.stream().map(LoanMapper::toLoanEntity).collect(Collectors.toList());
		}
	}

