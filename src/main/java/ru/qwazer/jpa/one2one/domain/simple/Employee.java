package ru.qwazer.jpa.one2one.domain.simple;

import javax.persistence.*;

/**
 * @author ar
 * @since Date: 14.05.2014
 */
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_id")
    private Long id;

    @Column(name = "description")
    private String description;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinTable(
            name="EMP_ADD",
            joinColumns=
    @JoinColumn(name="EMP_ID", referencedColumnName="EMP_ID"),
            inverseJoinColumns=
            @JoinColumn(name="ADDR_ID", referencedColumnName="ADDRESS_ID"))
    private Address address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
