package domain;

import java.util.ArrayList;
import java.util.List;

public class Tester extends User {
    private final List<Bug> foundBugs = new ArrayList<>();

    public Tester(Long id, String username, String password) {
        super(id, username, password);
    }

    /**
     * Method for adding a bug to the collection of foundBugs
     * @param bug: {@code Bug}, the bug that was discovered
     */
    public void addBug(Bug bug){
        foundBugs.add(bug);
        bug.basicSetTester(this);
    }

    /**
     * Method for retrieving all the bugs that were found by a {@code Tester}
     * @return list of the founds bugs of the current {@code Tester}
     */
    public List<Bug> getFoundBugs() {
        return foundBugs;
    }

    /**
     * Basic method for adding a bug to the collection of foundBugs. Does not keep the ends synchronized
     * @param bug: {@code Bug}, the bug that was discovered
     */
    protected void basicAddBug(Bug bug){
        foundBugs.add(bug);
    }

    @Override
    public String toString() {
        return super.toString() + " Tester";
    }
}
