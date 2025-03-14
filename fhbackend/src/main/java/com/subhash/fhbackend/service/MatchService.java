package com.subhash.fhbackend.service;

import com.subhash.fhbackend.model.Match;
import com.subhash.fhbackend.model.User;
import com.subhash.fhbackend.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;

    public void createMatch(User currentUser, User targetUser) {
        Match match = new Match();
        match.setUser1(currentUser);
        match.setUser2(targetUser);
        match.setMatched(true);
        matchRepository.save(match);
    }

}
