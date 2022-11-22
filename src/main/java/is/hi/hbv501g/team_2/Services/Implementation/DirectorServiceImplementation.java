package is.hi.hbv501g.team_2.Services.Implementation;

import is.hi.hbv501g.team_2.Persistence.Entities.Director;
import is.hi.hbv501g.team_2.Persistence.Repositories.DirectorRepository;
import is.hi.hbv501g.team_2.Services.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

@Service
public class DirectorServiceImplementation implements DirectorService {
    private DirectorRepository directorRepository;

    private List<Director> allDirectors;
    private LinkedList<Director> directorQueue;

    private static final int MIN_QUEUE_SIZE = 5;
    private static final int INIT_QUEUE_SIZE = 10;

    @Autowired
    public DirectorServiceImplementation(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
        this.allDirectors = directorRepository.findAll();
        this.directorQueue = new LinkedList<>();
    }

    /**
     * @return A random from director from the allDirectors list
     */
    private Director getRandomFromAll() {
        int random = (int)(Math.random() * allDirectors.size());
        return allDirectors.get(random);
    }

    /**
     * populates the directorQueue with random directors when the queue is smaller than MIN_QUEUE_SIZE,
     * adds a random director until the queue is of size INIT_QUEUE_SIZE
     */
    private void populateQueue() {
        if (directorQueue.size() < MIN_QUEUE_SIZE) {
            for (int i = 0; i < INIT_QUEUE_SIZE - directorQueue.size(); i++) {
                directorQueue.add(getRandomFromAll());
            }
        }
    }

    @Override
    public List<Director> findAll() {
        return allDirectors;
    }

    /**
     * @return The first director in the queue but does not remove it
     */
    @Override
    public Director getDirectorFromQueue() {
        populateQueue();
        return directorQueue.getFirst();
    }

    /**
     * Removes the first director in the queue
     */
    @Override
    public void removeDirectorFromQueue() {
        directorQueue.removeFirst();
    }
}
