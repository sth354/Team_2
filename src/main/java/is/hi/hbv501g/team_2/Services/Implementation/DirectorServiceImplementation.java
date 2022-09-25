package is.hi.hbv501g.team_2.Services.Implementation;

import is.hi.hbv501g.team_2.Persistence.Entities.Director;
import is.hi.hbv501g.team_2.Persistence.Repositories.DirectorRepository;
import is.hi.hbv501g.team_2.Services.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorServiceImplementation implements DirectorService {
    private DirectorRepository directorRepository;

    @Autowired
    public DirectorServiceImplementation(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    @Override
    public List<Director> findAll() {
        return directorRepository.findAll();
    }
}
