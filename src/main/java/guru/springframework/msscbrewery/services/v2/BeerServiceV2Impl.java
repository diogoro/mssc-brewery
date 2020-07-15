package guru.springframework.msscbrewery.services.v2;

import java.util.UUID;

import org.springframework.stereotype.Service;

import guru.springframework.msscbrewery.web.model.BeerDto;
import guru.springframework.msscbrewery.web.model.v2.BeerDtoV2;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BeerServiceV2Impl implements BeerServiceV2 {

	@Override
	public BeerDtoV2 getBeerById(UUID beerId) {
		log.debug("Get by Id v2");
		return null;
	}

	@Override
	public BeerDto saveNewBeer(BeerDtoV2 beerDto) {
		log.debug("Create new Beer v2");
		return null;
	}

	@Override
	public void updateBeer(UUID beerId, BeerDtoV2 beerDto) {
		log.debug("Update beer v2");
	}

	@Override
	public void deleteBeerById(UUID beerId) {
		log.debug("Delete by Id v2");
	}

}
