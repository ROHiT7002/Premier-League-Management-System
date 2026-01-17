package com.pl.premier_zone.controller;

import com.pl.premier_zone.entity.Player;
import com.pl.premier_zone.service.PlayerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/player")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    // ===================== GET (SEARCH / FILTER) =====================
    @GetMapping
    public List<Player> getPlayer(
            @RequestParam(required = false) String team,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String position,
            @RequestParam(required = false) String nation) {

        if (team != null && position != null) {
            return playerService.getPlayerByTeamAndPosition(team, position);
        } else if (team != null) {
            return playerService.getPlayerFromTeam(team);
        } else if (name != null) {
            return playerService.getPlayerByName(name);
        } else if (position != null) {
            return playerService.getPlayerByPosition(position);
        } else if (nation != null) {
            return playerService.getPlayerByNation(nation);
        } else {
            return playerService.getPlayers();
        }
    }

    // ===================== GET BY ID =====================
    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable Long id) {
        Player player = playerService.getPlayerById(id);
        return new ResponseEntity<>(player, HttpStatus.OK);
    }

    // ===================== ADD PLAYER =====================
    @PostMapping
    public ResponseEntity<Player> addPlayer(@Valid @RequestBody Player player) {
        Player createdPlayer = playerService.addPlayer(player);
        return new ResponseEntity<>(createdPlayer, HttpStatus.CREATED);
    }

    // ===================== UPDATE PLAYER (BY ID) =====================
    @PutMapping("/{id}")
    public ResponseEntity<Player> updatePlayer(
            @PathVariable Long id,
            @RequestBody Player player) {

        // Ensure correct ID is used
        player.setId(id);

        Player updatedPlayer = playerService.updatePlayer(player);
        return new ResponseEntity<>(updatedPlayer, HttpStatus.OK);
    }

    // ===================== DELETE PLAYER (BY ID) =====================
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePlayer(@PathVariable Long id) {
        playerService.deletePlayer(id);
        return new ResponseEntity<>("Player deleted successfully", HttpStatus.OK);
    }
}
