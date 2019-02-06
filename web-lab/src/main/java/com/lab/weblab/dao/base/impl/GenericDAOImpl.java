package com.lab.weblab.dao.base.impl;

import com.lab.weblab.dao.base.GenericDAO;
import org.hibernate.LockOptions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

public class GenericDAOImpl implements GenericDAO
{

    private SessionFactory sessionFactory;

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public <T> void delete(T transientObject)
    {
        getSession().delete(transientObject);
    }

    protected SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }

    @SuppressWarnings("unchecked")
    protected DetachedCriteria createDetachedCriteria(Class clazz) {
        return DetachedCriteria.forClass(clazz);
    }

    @SuppressWarnings("unchecked")
    public <T> List<T> findAll(Class clazz) {
        DetachedCriteria criteria = createDetachedCriteria(clazz);
        return criteria.getExecutableCriteria(getSession()).list();
    }

    @SuppressWarnings("unchecked")
    public <T> List<T> findAllByProperty(Class clazz, String propertyName, Object value) {
        DetachedCriteria criteria = createDetachedCriteria(clazz);
        criteria.add(Restrictions.eq(propertyName, value));
        return criteria.getExecutableCriteria(getSession()).list();
    }

    public <T> T findByProperty(Class clazz, String propertyName, Object value) {
        DetachedCriteria criteria = createDetachedCriteria(clazz);
        criteria.add(Restrictions.eq(propertyName, value));
        return (T) criteria.getExecutableCriteria(getSession()).uniqueResult();
    }

    public <T, PK extends Serializable> T findById(Class<T> type, PK id) {
        return (T) getSession().get(type, id);
    }

    @SuppressWarnings("unchecked")
    public <T, PK> PK save(T newInstance) {
        return (PK) getSession().save(newInstance);
    }

    public <T> void saveOrUpdate(T transientObject) {
        getSession().saveOrUpdate(transientObject);
    }

    public <T> void update(T transientObject) {
        getSession().update(transientObject);
    }

    public <T> void evict(T transientObject) {
        if (getSession().contains(transientObject)) {
            getSession().refresh(transientObject);
        }
    }

    public <T> void reattachUsingLock(T transientObject) {
        getSession().buildLockRequest(LockOptions.NONE).lock(transientObject);
    }

    public void flushSessionChanges() {
        getSession().flush();
    }

    public boolean isSessionContainsObject(Object detachedObject) {
        return getSession().contains(detachedObject);
    }

    @SuppressWarnings("unchecked")
    public <T> T merge(T transientObject) {
        transientObject = (T) getSession().merge(transientObject);
        return transientObject;
    }

/*    public <T extends BaseEntity> List<Long> getIds(Collection<T> processList) {
        List<Long> ids = Lists.newArrayList();
        for (T entity : processList) {
            ids.add(entity.getId());
        }
        return ids;
    }*/


}
