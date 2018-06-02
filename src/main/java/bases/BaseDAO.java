package bases;

import java.util.List;

import javax.persistence.*;

public abstract class BaseDAO<TEntity extends BaseEntity> {

    @PersistenceContext
    private EntityManager manager;
    private EntityTransaction transaction;

    private final Class<TEntity> type;

    public BaseDAO(Class<TEntity> type) {
        transaction = manager.getTransaction();
        this.type = type;
    }

    public TEntity Insert(TEntity entity) {
        BeginTransaction();
        TEntity createdObject = manager.merge(entity);
        CommitAndClose();

        return createdObject;
    }

    public void Delete(TEntity entity) {
        BeginTransaction();

        TEntity object = manager.find(type, entity.getId());
        manager.remove(object);

        CommitAndClose();
    }

    public TEntity GetBy(int id) {
        BeginTransaction();
        TEntity object = manager.find(type, id);
        Close();

        return object;
    }

    public List<TEntity> GetAll() {
        BeginTransaction();
        List<TEntity> objs = manager.createQuery(String.format("SELECT entity FROM %s entity", type.getName())).getResultList();

        Close();
        return objs;
    }

    private void BeginTransaction() {
        if (!transaction.isActive())
            transaction.begin();
    }

    private void CommitAndClose() {
        transaction.commit();
        Close();
    }

    private void Close() {
        if (manager.isOpen())
            manager.close();
    }
}
