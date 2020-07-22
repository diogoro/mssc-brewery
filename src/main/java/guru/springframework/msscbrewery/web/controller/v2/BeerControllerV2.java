package guru.springframework.msscbrewery.web.controller.v2;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import guru.springframework.msscbrewery.services.v2.BeerServiceV2;
import guru.springframework.msscbrewery.web.model.v2.BeerDtoV2;
import lombok.RequiredArgsConstructor;
import lombok.val;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RequestMapping("/api/v2/beer")
@RestController
@RequiredArgsConstructor
public class BeerControllerV2 {
	
	private final BeerServiceV2 beerServiceV2;

	@GetMapping({ "/{beerId}" })
	public ResponseEntity<BeerDtoV2> getBeer(@PathVariable("beerId") UUID beerId) {

		return new ResponseEntity<>(beerServiceV2.getBeerById(beerId), HttpStatus.OK);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping // Using POST to create a new Beer
	public ResponseEntity handlePost(@RequestBody @Valid BeerDtoV2 beerDto) {
		log.debug("start handlePost ...");
		
		val saveDto = beerServiceV2.saveNewBeer(beerDto);

		var headers = new HttpHeaders();
		// The correct is return the full url
		// TODO Add hostmane at url
		headers.add("Location", "/api/v1/beer/" + saveDto.getId().toString());

		log.debug("end handlePost. Respense headers: " + headers.toString());
		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@SuppressWarnings("rawtypes")
	@PutMapping({ "/{beerId}" })
	public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId, @Valid @RequestBody BeerDtoV2 beerDto) {
		beerServiceV2.updateBeer(beerId, beerDto);

		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping({ "/{beerId}" })
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBeer(@PathVariable("beerId") UUID beerId) {
		beerServiceV2.deleteBeerById(beerId);

	}
}
