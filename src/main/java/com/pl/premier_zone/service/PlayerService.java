package com.pl.premier_zone.service;

import com.pl.premier_zone.entity.Player;
import com.pl.premier_zone.exception.BadRequestException;
import com.pl.premier_zone.exception.ResourceNotFoundException;
import com.pl.premier_zone.repository.PlayerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    // ===================== GET ALL =====================
    public List<Player> getPlayers() {
        List<Player> players = playerRepository.findAll();
        if (players.isEmpty()) {
            throw new ResourceNotFoundException("No players found");
        }
        return players;
    }

    // ===================== SEARCH METHODS =====================

    public List<Player> getPlayerFromTeam(String teamName) {
        List<Player> players = playerRepository.findByTeam(teamName);
        if (players.isEmpty()) {
            throw new ResourceNotFoundException("No players found for team: " + teamName);
        }
        return players;
    }

    // Used for name search (can return MULTIPLE players)
    public List<Player> getPlayerByName(String searchText) {
        List<Player> players =
                playerRepository.findByNameContainingIgnoreCase(searchText);

        if (players.isEmpty()) {
            throw new ResourceNotFoundException(
                    "No players found with name: " + searchText);
        }
        return players;
    }

    public List<Player> getPlayerByPosition(String position) {
        List<Player> players =
                playerRepository.findByPositionIgnoreCase(position);

        if (players.isEmpty()) {
            throw new ResourceNotFoundException(
                    "No players found for position: " + position);
        }
        return players;
    }

    public List<Player> getPlayerByNation(String nation) {
        List<Player> players =
                playerRepository.findByNationIgnoreCase(nation);

        if (players.isEmpty()) {
            throw new ResourceNotFoundException(
                    "No players found for nation: " + nation);
        }
        return players;
    }

    public List<Player> getPlayerByTeamAndPosition(String team, String position) {
        List<Player> players =
                playerRepository.findByTeamIgnoreCaseAndPositionIgnoreCase(team, position);

        if (players.isEmpty()) {
            throw new ResourceNotFoundException(
                    "No players found for team " + team + " and position " + position);
        }
        return players;
    }

    // ===================== GET BY ID (FOR PROFILE PAGE) =====================
    public Player getPlayerById(Long id) {
        return playerRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Player not found with id: " + id));
    }

    // ===================== ADD PLAYER =====================
    public Player addPlayer(Player player) {

        // Prevent exact duplicate (same name + team + age)
        boolean exists =
                playerRepository.existsByNameIgnoreCaseAndTeamIgnoreCaseAndAge(
                        player.getName(),
                        player.getTeam(),
                        player.getAge()
                );

        if (exists) {
            throw new BadRequestException(
                    "Player already exists in this team");
        }

        return playerRepository.save(player);
    }

    // ===================== UPDATE PLAYER (BY ID) =====================
    public Player updatePlayer(Player updatedPlayer) {

        Player existingPlayer =
                playerRepository.findById(updatedPlayer.getId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Player not found with id: " + updatedPlayer.getId()));

        existingPlayer.setName(updatedPlayer.getName());
        existingPlayer.setTeam(updatedPlayer.getTeam());
        existingPlayer.setPosition(updatedPlayer.getPosition());
        existingPlayer.setNation(updatedPlayer.getNation());
        existingPlayer.setAge(updatedPlayer.getAge());
        existingPlayer.setMp(updatedPlayer.getMp());
        existingPlayer.setStarts(updatedPlayer.getStarts());
        existingPlayer.setMin(updatedPlayer.getMin());
        existingPlayer.setGls(updatedPlayer.getGls());
        existingPlayer.setAst(updatedPlayer.getAst());
        existingPlayer.setPk(updatedPlayer.getPk());
        existingPlayer.setCrdy(updatedPlayer.getCrdy());
        existingPlayer.setCrdr(updatedPlayer.getCrdr());
        existingPlayer.setXg(updatedPlayer.getXg());
        existingPlayer.setXag(updatedPlayer.getXag());

        return playerRepository.save(existingPlayer);
    }

    // ===================== DELETE PLAYER (BY ID) =====================
    @Transactional
    public void deletePlayer(Long playerId) {

        Player player =
                playerRepository.findById(playerId)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Player not found with id: " + playerId));

        playerRepository.delete(player);
    }
}
