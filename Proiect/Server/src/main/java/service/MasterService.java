package service;

import domain.Bug;
import domain.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import services.Service;

import java.util.Optional;

public class MasterService implements Service {
    private final UserService userService;
    private final BugService bugService;
    private final static Logger logger = LogManager.getLogger();

    public MasterService(UserService userService, BugService bugService) {
        this.userService = userService;
        this.bugService = bugService;
    }

    @Override
    public User findUser(String username, String password) {
        logger.traceEntry("Entry Find User {} {}", username, password);
        Optional<User> resultFind = userService.find(username, password);
        User result = resultFind.orElse(null);
        logger.traceExit("Exit Find User result {}", result);
        return result;
    }

    @Override
    public Bug addBug(Bug bug) {
        logger.traceEntry("Entry Add Bug {}", bug);
        Optional<Bug> resultAdd = bugService.add(bug);
        Bug result = resultAdd.orElse(null);
        logger.traceExit("Exit Add Bug result {}", result);
        return result;
    }
}
