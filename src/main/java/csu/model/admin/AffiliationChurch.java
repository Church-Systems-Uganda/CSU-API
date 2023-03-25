package csu.model.admin;

import java.util.HashSet;
import java.util.Set;

import csu.model.admin.Church.ChurchHierrachy;
import csu.model.audit.UserDateAudit;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "churches", uniqueConstraints = { @UniqueConstraint(columnNames = { "name" }) })
public class AffiliationChurch extends UserDateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 100)
    private String name;

    // Church affiliation, a single church belongs to one affiliation
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "affiliation_id", nullable = false)
    private Affiliation affiliation;

    @OneToMany(mappedBy = "affiliationChurch", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ChurchHierrachy> hierarchies = new HashSet<>();

    public AffiliationChurch() {
        super();
    }

    public AffiliationChurch(@NotBlank @Size(max = 100) String name, Affiliation affiliation,
            Set<ChurchHierrachy> hierarchies) {
        this.name = name;
        this.affiliation = affiliation;
        this.hierarchies = hierarchies;
    }

    // Getters and setters
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

    public Affiliation getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(Affiliation affiliation) {
        this.affiliation = affiliation;
    }

    public Set<ChurchHierrachy> getHierarchies() {
        return hierarchies;
    }

    public void setHierarchies(Set<ChurchHierrachy> hierarchies) {
        this.hierarchies = hierarchies;
    }

    /**
     * Adds a new hierarchy to the church
     * 
     * @param hierarchy The hierarchy to add
     */
    public void addHierarchy(ChurchHierrachy hierarchy) {
        this.hierarchies.add(hierarchy);
        hierarchy.setAffiliationChurch(this);
    }

    /**
     * Removes a hierarchy from the church
     * 
     * @param hierarchy The hierarchy to remove
     */
    public void removeHierarchy(ChurchHierrachy hierarchy) {
        this.hierarchies.remove(hierarchy);
        hierarchy.setAffiliationChurch(null);
    }
}
