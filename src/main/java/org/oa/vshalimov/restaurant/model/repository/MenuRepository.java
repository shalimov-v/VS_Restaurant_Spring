package org.oa.vshalimov.restaurant.model.repository;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.oa.vshalimov.restaurant.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Repository("menuRepository")
public class MenuRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional(readOnly = true)
    public List<Menu> loadAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Menu> menus = new ArrayList<>();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            menus = (List<Menu>) session.createQuery("FROM Menu").list();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return menus;
    }

    @Transactional(readOnly = true)
    public Menu findById(int itemId) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = null;
        Menu menu = null;
        try {
            transaction = session.beginTransaction();
            menu = (Menu) session.createQuery("FROM Menu WHERE menuId=" + itemId).uniqueResult();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return menu;
    }

    @Transactional
    public List<Menu> findByDishType(int dishTypeId) {
        Session session = sessionFactory.getCurrentSession();
        List<Menu> menus = new ArrayList<>();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            menus = (List<Menu>) session.createQuery("FROM Menu WHERE menuDish.dishType.dishTypeId IN (FROM DishType WHERE dishTypeId=" + dishTypeId + ") ORDER BY menuDish.dishName").list();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return menus;
    }

    @Transactional
    public boolean create(Menu itemToCreate) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(itemToCreate);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Transactional
    public boolean update(Menu itemToUpdate) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(itemToUpdate);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Transactional
    public boolean delete(Menu itemToDelete) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(itemToDelete);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
        return true;
    }

}