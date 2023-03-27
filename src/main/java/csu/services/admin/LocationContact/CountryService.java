package src.main.java.csu.services.admin.LocationContact;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CountryService {
	
	@Autowired
	CountryRepository countryRepository;
	
	
	public List<CountryRepositoryPayload> getAllCountries() {

		List<CountryRepositoryPayload> CountryRepositoryPayload = new ArrayList<>();

		for (Country churchHierrachy : countryRepository.findAll()) {

			CountryRepositoryPayload payload = new countryRepository();
			payload.setId(countryRepository.getId());
			payload.setTier(countryRepository.getTier());
			// payload.setPosition(churchHierrachy.getPosition());
			countryRepositoryPayload.add(payload);
		}

		return countryRepositoryPayload;
	}
	
	//create
	
	public ResponseEntity<?> createCountry(CountryRequest request) {
		
		if (request.getName() != null) {

			Optional<Country> existingcountry = request.getId() != null
					? countryRepository.findById(request.getId())
					: Optional.empty();
			
			if (!existingcountry.isPresent() && countryRepository.existsByName(request.getName())) {
				return new ResponseEntity<>(new ApiResponse(false, "country Exists"), HttpStatus.BAD_REQUEST);
			}
			
			Country country = existingcountry.isPresent() ? existingcountry.get()
					: new Country();
			
			country.setName(request.getName());
			

			Country result = countryRepository.save(country);

			if (result != null) {
				return new ResponseEntity<>(new ApiResponse(true, "country Created"), HttpStatus.OK);
			}

		}

		return new ResponseEntity<>(new ApiResponse(false, "country Not Created"), HttpStatus.BAD_REQUEST);

	}
	
	// delete

		public ResponseEntity<?> deleteChurchHierrachy(CountryRequest request) {

			if (request.getId() != null) {

				try {
					countryRepository.deleteById(request.getId());

					return new ResponseEntity<>(new ApiResponse(true, "Country Deleted"), HttpStatus.OK);
				} catch (Exception e) {
					// TODO: handle exception
				}

			}

			return new ResponseEntity<>(new ApiResponse(false, "Country Not Deleted"), HttpStatus.BAD_REQUEST);

		}

	}
	


