package ru.qwazer.jpa.one2one.domain.inheritance;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Event extends ABlockableEntity {
    @Column(name = "description")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
