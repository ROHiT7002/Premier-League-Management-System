package com.pl.premier_zone.repository;

import com.pl.premier_zone.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    //findBy + FieldName + Keyword

    // Search by name (can return multiple players)
    List<Player> findByNameContainingIgnoreCase(String name); //findByNameContainingIgnoreCase --> in sql LIKE %text%

    // Filter methods
    List<Player> findByTeam(String team);

    List<Player> findByPositionIgnoreCase(String position);

    List<Player> findByNationIgnoreCase(String nation);

    List<Player> findByTeamIgnoreCaseAndPositionIgnoreCase(
            String team, String position);

    // Used to prevent exact duplicate players
    boolean existsByNameIgnoreCaseAndTeamIgnoreCaseAndAge(
            String name,
            String team,
            Integer age
    );
}
