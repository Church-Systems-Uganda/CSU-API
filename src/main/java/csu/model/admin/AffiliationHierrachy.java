package csu.model.admin;

import java.util.HashSet;
import java.util.Set;

import csu.model.audit.UserDateAudit;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;

@Entity
public class Hierarchy extends UserDateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // A hierarchy belongs to an affiliation
    @ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
    @JoinColumn(name = "affiliation_ID", nullable = false)
    private Affiliation affiliation;

    // Name of the hierarchy
    @NotNull
    private String name;

    // Level of the hierarchy
    private Integer level;

    // Positions who are the heads of this hierarchy
    @OneToMany(mappedBy = "hierarchy", cascade = CascadeType.ALL)
    private Set<Position> levelHead = new HashSet<>();

    public Hierarchy() {
        super();
    }

    public Hierarchy(Affiliation affiliation, String name, Integer level, Set<Position> levelHead) {
        super();
        this.affiliation = affiliation;
        this.name = name;
        this.level = level;
        this.levelHead = levelHead;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Affiliation getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(Affiliation affiliation) {
        this.affiliation = affiliation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Set<Position> getLevelHead() {
        return levelHead;
    }

    public void setLevelHead(Set<Position> levelHead) {
        this.levelHead = levelHead;
    }
}
