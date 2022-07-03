package com.ivanart555.hrtemplate.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "positions", schema = "hrtemplate")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "postion_id")
    private Integer id;

    @Column(name = "position_name", unique = true)
    private String name;

    @Override
    public String toString() {
        return "Position [id=" + id + ", name=" + name + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return id.equals(position.id) && name.equals(position.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
