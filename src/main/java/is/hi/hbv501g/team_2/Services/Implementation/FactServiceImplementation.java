package is.hi.hbv501g.team_2.Services.Implementation;


import is.hi.hbv501g.team_2.Persistence.Entities.Fact;
import is.hi.hbv501g.team_2.Persistence.Repositories.FactRepository;
import is.hi.hbv501g.team_2.Services.FactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class FactServiceImplementation implements FactService {

    private FactRepository factRepository;


    @Autowired
    public FactServiceImplementation(FactRepository factRepository) {
        this.factRepository = factRepository;
    }

    @Override
    public List<Fact> findAll() {
        return factRepository.findAll();
    }


    @Override
    public Fact getRandomFact() {
        Random rand = new Random();
        List<Fact> allFacts = findAll();
        return allFacts.get(rand.nextInt(allFacts.size()));
    }
}
