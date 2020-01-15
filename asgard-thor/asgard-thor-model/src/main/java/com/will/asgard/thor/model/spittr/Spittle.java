package com.will.asgard.thor.model.spittr;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@Data
@NoArgsConstructor
public class Spittle {
    private Long id;
    private String message;
    private Date time;
    private Double latitude;
    private Double longitude;

    public Spittle(String message, Date time) {
        this.message = message;
        this.time = time;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;
        return EqualsBuilder.reflectionEquals(this, that, "id", "time");
    }

    @Autowired
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, "id", "time");
    }
}
