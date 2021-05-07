package repository.hibernate;

import domain.Bug;
import org.hibernate.Session;
import org.hibernate.query.Query;
import repository.BugRepository;
import validator.Validator;

public class BugDBRepository extends AbstractDBRepository<Long, Bug> implements BugRepository {

    public BugDBRepository(Validator<Long, Bug> validator) {
        super(validator);
    }

    @Override
    protected Query<Bug> getFindQuery(Session session, Long aLong) {
        return session.createQuery("from Bug where id=:id", Bug.class)
                .setParameter("id", aLong);
    }

    @Override
    protected Query<Bug> getFindAllQuery(Session session) {
        return session.createQuery("from Bug", Bug.class);
    }
}
