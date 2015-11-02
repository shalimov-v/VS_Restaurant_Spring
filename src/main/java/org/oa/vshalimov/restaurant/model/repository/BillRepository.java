package org.oa.vshalimov.restaurant.model.repository;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.oa.vshalimov.restaurant.model.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Repository("billRepository")
public class BillRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional(readOnly = true)
    public List<Bill> loadAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Bill> bills = new ArrayList<>();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            bills = (List<Bill>) session.createQuery("FROM Bill").list();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return bills;
    }

    @Transactional(readOnly = true)
    public Bill findById(int itemId) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = null;
        Bill bill = null;
        try {
            transaction = session.beginTransaction();
            bill = (Bill) session.createQuery("FROM Bill WHERE billId=" + itemId).uniqueResult();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return bill;
    }

    @Transactional
    public boolean create(Bill itemToCreate) {
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
    public boolean update(Bill itemToUpdate) {
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
    public boolean delete(Bill itemToDelete) {
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
