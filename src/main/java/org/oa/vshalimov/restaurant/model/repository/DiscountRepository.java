package org.oa.vshalimov.restaurant.model.repository;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.oa.vshalimov.restaurant.model.Discount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Repository("discountRepository")
public class DiscountRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional(readOnly = true)
    public List<Discount> loadAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Discount> discounts = new ArrayList<>();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            discounts = (List<Discount>) session.createQuery("FROM Discount ORDER BY discountValue").list();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return discounts;
    }

    @Transactional(readOnly = true)
    public Discount findById(int itemId) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = null;
        Discount discount = null;
        try {
            transaction = session.beginTransaction();
            discount = (Discount) session.createQuery("FROM Discount WHERE discountId=" + itemId).uniqueResult();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return discount;
    }

    @Transactional
    public boolean create(Discount itemToCreate) {
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
    public boolean update(Discount itemToUpdate) {
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
    public boolean delete(Discount itemToDelete) {
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
