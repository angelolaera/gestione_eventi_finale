package angelolaera.gestione_eventi_finale.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "eventi")

public class Evento {

    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titolo;
    private String descrizione;
    private LocalDateTime data;
    private String luogo;
    private int postiDisponibili;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente creatore;
}
