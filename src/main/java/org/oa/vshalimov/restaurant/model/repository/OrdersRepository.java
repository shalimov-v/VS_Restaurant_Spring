package org.oa.vshalimov.restaurant.model.repository;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.oa.vshalimov.restaurant.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Repository("ordersRepository")
public class OrdersRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional(readOnly = true)
    public List<Orders> loadAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Orders> orders = new ArrayList<>();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            orders = (List<Orders>) session.createQuery("FROM Orders").list();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return orders;
    }

    @Transactional(readOnly = true)
    public List<Orders> findByBillId(int itemId) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = null;
        List<Orders> orders = null;
        try {
            transaction = session.beginTransaction();
            orders = (List<Orders>) session.createQuery("FROM Orders WHERE ordersBillId=" + itemId).list();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return orders;
    }

    @Transactional(readOnly = true)
    public Orders findMenuItemByBillId(int billId, int menuId) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = null;
        Orders order = null;
        try {
            transaction = session.beginTransaction();
            order = (Orders) session.createQuery("FROM Orders WHERE ordersBillId=" + billId + " AND ordersMenuId=" + menuId).uniqueResult();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return order;
    }

    @Transactional
    public boolean create(Orders itemToCreate) {
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

}