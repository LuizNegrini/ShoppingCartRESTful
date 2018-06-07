package bases;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
public abstract class BaseDAO<TEntity extends BaseEntity> {

    @PersistenceContext
    protected EntityManager manager;

    private final Class<TEntity> type;

    public BaseDAO(Class<TEntity> type) {
        this.type = type;
    }

    public TEntity Insert(TEntity entity) {
        TEntity createdObject = manager.merge(entity);

        return createdObject;
    }

    public TEntity Update(TEntity entity) {
        TEntity ent = manager.getReference(this.type, entity.getId());
        ent = entity;
        return ent;
    }

    public void Delete(int id) {
        TEntity object = manager.getReference(this.type, id);

        if (object != null) {
            manager.getReference(this.type, id);
            manager.remove(object);
        }
    }

    public TEntity GetBy(int id) {
        TEntity object = manager.find(type, id);

        return object;
    }

    public List<TEntity> GetAll() {
        List<TEntity> objs = manager.createQuery(String.format("SELECT entity FROM %s entity", type.getName())).getResultList();

        return objs;
    }
}
