/*
 * Copyright 2012-2016, the original author or authors.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.flipkart.flux.dao;

import com.flipkart.flux.dao.iface.StateMachinesDAO;
import com.flipkart.flux.domain.StateMachine;
import com.flipkart.flux.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * @author shyam.akirala
 */
public class StateMachinesDAOImpl extends AbstractDAO<StateMachine> implements StateMachinesDAO {

    @Override
    public StateMachine create(StateMachine stateMachine) {
        return super.persist(stateMachine);
    }

    @Override
    public void update(StateMachine stateMachine) {
        super.update(stateMachine);
    }

    @Override
    public List<StateMachine> getAllStateMachines() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();

        Criteria criteria = session.createCriteria(StateMachine.class);
        List<StateMachine> stateMachines = criteria.list();

        tx.commit();
        return stateMachines;
    }

    @Override
    public StateMachine findByNameAndVersion(String stateMachineName, Long Version) {
        //TO DO: Implementation
        return null;
    }
}
