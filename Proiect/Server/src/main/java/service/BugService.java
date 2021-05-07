package service;

import domain.Bug;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import repository.BugRepository;

import java.util.Optional;

public class BugService {
    private final BugRepository repository;
    private final static Logger logger = LogManager.getLogger();

    public BugService(BugRepository repository) {
        this.repository = repository;
    }

    /**
     * Method for saving a bug
     * @param bug: Bug
     * @return an {@code Optional}
     *          - null, if the bug was successfully saved
     *          - the bug, otherwise
     */
    public Optional<Bug> add(Bug bug){
        logger.traceEntry("Entry Add {}", bug);
        Optional<Bug> result = repository.save(bug);
        logger.traceExit("Exit Add result {}", result);
        return result;
    }
}
