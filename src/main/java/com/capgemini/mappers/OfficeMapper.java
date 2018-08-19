package com.capgemini.mappers;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
		List<LoanTO> loansTOTOs=LoanMapper.map2TOs(officeEntity.getLoansTo());
		return new OfficeTOBuilder()
				.withAddress(AddressMapper.toAddressTO(officeEntity.getAddress()))
				.withPhoneNumber(officeEntity.getPhoneNumber()).withMail(officeEntity.getMail()).withId(officeEntity.getId()).build();
	}

	public static OfficeEntity toOfficeEntity(OfficeTO officeTO) {
		if (officeTO == null) {
			return null;
		}
		OfficeEntity officeEntity = new OfficeEntity();
		officeEntity.setId(officeTO.getId());
		officeEntity.setAddress(AddressMapper.toAddressEntity(officeTO.getAddress()));
		officeEntity.setPhoneNumber(officeTO.getPhoneNumber());
		officeEntity.setMail(officeEntity.getMail());
		return officeEntity;
	}

	public static Set<OfficeTO> map2TOs(Set<OfficeEntity> officeEntities) {
		return officeEntities.stream().map(OfficeMapper::toOfficeTO).collect(Collectors.toSet());
	}

	public static Set<OfficeEntity> map2Entities(Set<OfficeTO> officeTOs) {
		return officeTOs.stream().map(OfficeMapper::toOfficeEntity).collect(Collectors.toSet());
	}
}
