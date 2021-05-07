package domain;

public class Entity<ID> {
    private ID id;

    public Entity(ID id) {
        this.id = id;
    }

    public Entity(){

    }

    /**
     * Getter for the id of an {@code Entity}
     * @return id: ID, id of the current {@code Entity}
     */
    public ID getId() {
        return id;
    }

    /**
     * Setter for the id of an @code Entity}
     * @param id: ID
     * id of the current @code Entity} is set to {@param id}
     */
    public void setId(ID id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return getId().toString();
    }
}
