package domain;

import java.util.ArrayList;
import java.util.List;

public class Programmer extends User {
    private final List<Bug> resolvedBugs = new ArrayList<>();

    public Programmer(Long id, String username, String password) {
        super(id, username, password);
    }

    /**
     * Method for adding a bug that was resolved by a {@code Programmer}
     * @param bug: {@code Bug}, the resolved {@code Bug}
     */
    public void addBug(Bug bug){
        resolvedBugs.add(bug);
        bug.basicSetProgrammer(this);
    }

    /**
     * Method for retrieving all the resolved bugs of a {@code Programmer}
     * @return list of all the resolved bugs of a Programmer
     */
    public List<Bug> getResolvedBugs() {
        return resolvedBugs;
    }

    /**
     * Basic method for adding a resolved bug. Does not keep the ends synchronised
     * @param bug: {@code Bug}, the resolved {@code Bug}
     */
    protected void basicAddBug(Bug bug){
        resolvedBugs.add(bug);
    }

    @Override
    public String toString() {
        return super.toString() + " Programmer";
    }
}
