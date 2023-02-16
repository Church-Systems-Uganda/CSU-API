
@Entity
@Table(name = "activity", uniqueConstraints = { @UniqueConstraint(columnNames = { "name" }) })


public class Activity {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String name;

     
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "church_id", nullable = true)
    private Church church;

	public Activity(String name, Church church) {
		super();
		
		this.name = name;
	}

	public Activity() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    public void setChurch(Church church) {
		this.church = church;
	}
    








    
}
