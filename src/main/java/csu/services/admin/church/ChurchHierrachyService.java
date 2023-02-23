
@Service
public class ChurchHierrachyService {
    
    @Autowired
    ChurchHierrachyRepository churchHierrachyRepository;


    /*
	 * Getting all affiliations
	 */
	public List<ChurchHierrachyPayload> getAllChurchHierrachy() {

		List<ChurchHierrachyPayload> churchHierrachyPayload = new ArrayList<>();

		for (ChurchHierrachy churchHierrachy : churchHierrachyRepositoryy.findAll()) {

			ChurchHierrachyPayload payload = new ChurchHierrachyPayload();

			payload.setId(churchHierrachy.getId());
			payload.setTier(churchHierrachy.getTier());
			payload.setPosition(churchHierrachy.getPosition());
			churchHierrachyPayload.add(payload);

		}
		return churchHierrachyPayload;
	}

    


}
