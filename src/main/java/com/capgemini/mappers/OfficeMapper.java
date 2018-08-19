package com.capgemini.mappers;

import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.domain.LoanEntity;
import com.capgemini.domain.OfficeEntity;
import com.capgemini.to.LoanTO;
import com.capgemini.to.OfficeTO;
import com.capgemini.to.OfficeTO.OfficeTOBuilder;

public class OfficeMapper {

	public static OfficeTO toOfficeTO(OfficeEntity officeEntity) {
		if (officeEntity == null) {
			return null;
		}
		List<LoanTO> loansFromTOs=LoanMapper.map2TOs(officeEntity.getLoansFrom());
		List<LoanTO> loansToTOs=LoanMapper.map2TOs(officeEntity.getLoansTo());
		return new OfficeTOBuilder()
				.withId(officeEntity.getId())
				.withAddress(AddressMapper.toAddressTO(officeEntity.getAddress()))
				.withPhoneNumber(officeEntity.getPhoneNumber())
				.withMail(officeEntity.getMail())
				.withLoansFrom(loansFromTOs)
				.withLoansTo(loansToTOs)
				.build();
	}

	public static OfficeEntity toOfficeEntity(OfficeTO officeTo) {
		if (officeTo == null) {
			return null;
		}
		OfficeEntity officeEntity = new OfficeEntity();
		List<LoanEntity> loansFromEntities=LoanMapper.map2Entities(officeTo.getLoansFrom());
		List<LoanEntity> loansToEntities=LoanMapper.map2Entities(officeTo.getLoansTo());
		officeEntity.setId(officeTo.getId());
		officeEntity.setAddress(AddressMapper.toAddressEntity(officeTo.getAddress()));
		officeEntity.setPhoneNumber(officeTo.getPhoneNumber());
		officeEntity.setMail(officeEntity.getMail());
		officeEntity.setLoansFrom(loansFromEntities);
		officeEntity.setLoansTo(loansToEntities);
		return officeEntity;
	}

	public static List<OfficeTO> map2TOs(List<OfficeEntity> officeEntities) {
		return officeEntities.stream().map(OfficeMapper::toOfficeTO).collect(Collectors.toList());
	}

	public static List<OfficeEntity> map2Entities(List<OfficeTO> officeTOs) {
		return officeTOs.stream().map(OfficeMapper::toOfficeEntity).collect(Collectors.toList());
	}
}
