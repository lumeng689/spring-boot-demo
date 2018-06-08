package com.nw.syn.service.impl;


import java.util.ArrayList;
import java.util.List;

import com.nw.syn.model.Player;
import com.nw.syn.model.Team;
import com.nw.syn.repository.PlayerRepository;
import com.nw.syn.repository.TeamRepository;
import com.nw.syn.service.SoccerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SoccerServiceImpl implements SoccerService {
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private TeamRepository teamRepository;

    public List<String> getAllTeamPlayers(long teamId) {
        List<String> result = new ArrayList<String>();
        List<Player> players = playerRepository.findByTeamId(teamId);
        for (Player player : players) {
            result.add(player.getName());
        }
        return result;
    }

    public void addBarcelonaPlayer(String name, String position, int number) {
        Team barcelona = teamRepository.findByPlayers(1l);
        Player newPlayer = new Player();
        newPlayer.setName(name);
        newPlayer.setPosition(position);
        newPlayer.setNum(number);
        newPlayer.setTeam(barcelona);
        playerRepository.save(newPlayer);
    }
}