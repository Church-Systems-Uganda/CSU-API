@RestController
@RequestMapping("/api/admin")
public class ChurchHierrachyController {

    @Autowired
    ChurchHierrachy churchHierrachy;

    @GetMapping("/ChurchHierrachy")
	public List<ChurchHierrachyPayload> getAllChurchHierrachy() {
		return ChurchHierrachyService.getAllChurchHierrachy();
	}
    
}
