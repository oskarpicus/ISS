package repository;

import domain.Bug;
import domain.Tester;

public interface BugRepository extends Repository<Long, Bug> {

    /**
     * Method for finding bugs that were added by a Tester
     * @param tester: Tester, the tester that added the bugs
     * @return i: Iterable<Bug>, containing all of tester's bugs
     * @throws IllegalArgumentException if tester is null
     */
    Iterable<Bug> findBugsByTester(Tester tester);
}
