package org.module_10.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.sql.Date;
@Data
@Entity
@Table(name="Ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "created_at", insertable = false, updatable = false)
    private Date createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id",  nullable = false)
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_planet_id", nullable = false)
    private Planet from;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_planet_id", nullable = false)
    private Planet to;

}
