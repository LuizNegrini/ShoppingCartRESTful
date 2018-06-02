package bases;

import javax.inject.Inject;

public abstract class BaseController<TDao> {
    @Inject
    private TDao dao;

    public TDao getDao(){
        return dao;
    }
}
