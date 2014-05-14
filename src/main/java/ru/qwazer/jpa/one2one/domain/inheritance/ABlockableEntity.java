package ru.qwazer.jpa.one2one.domain.inheritance;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class ABlockableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id")
    private Long id;




    @OneToOne(fetch=FetchType.LAZY)
    @JoinTable(
            name="QUEUE",
            joinColumns=
            @JoinColumn(name="child_id", referencedColumnName="id"),
            inverseJoinColumns=
            @JoinColumn(name="parent_id", referencedColumnName="id"))
    private ABlockableEntity parentId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ABlockableEntity getParentId() {
        return parentId;
    }

    public void setParentId(ABlockableEntity parentId) {
        this.parentId = parentId;
    }
}
