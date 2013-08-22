package com.whiteleys.zoo.dao.hibernate;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.whiteleys.zoo.dao.UserDao;
import com.whiteleys.zoo.domain.User;

public class HibernateUserDao extends HibernateDaoSupport implements UserDao {

	@Override
	public void update(User user) {
		this.getHibernateTemplate().update(user);
    }
	
	@Override
    public void save(User user) {
		this.getHibernateTemplate().save(user);
    }

	@Override
    public User find(String username, String password) {
        List<User> user = getHibernateTemplate().find("FROM User WHERE username = ? AND password = ?", new Object[] {username, password});
        if (user.size() == 1) {
            return user.get(0);
        }
        return null;
    }

	@Override
    public boolean exists(String username) {
        return getHibernateTemplate().find("FROM User WHERE username = ?", username).size() == 1;
    }
}
