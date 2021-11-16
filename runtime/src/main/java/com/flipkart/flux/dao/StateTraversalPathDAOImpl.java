/*
 * Copyright 2012-2019, the original author or authors.
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

import com.flipkart.flux.dao.iface.StateTraversalPathDAO;
import com.flipkart.flux.domain.StateMachine;
import com.flipkart.flux.domain.StateMachineStatus;
import com.flipkart.flux.domain.StateTraversalPath;
import com.flipkart.flux.persistence.*;
import com.flipkart.flux.shard.ShardId;
import com.google.inject.name.Named;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <code>StateTraversalPathDAOImpl</code> is an implementation of {@link com.flipkart.flux.dao.iface.StateTraversalPathDAO}
 * which uses Hibernate to perform operations.
 *
 * @author akif.khan
 */
public class StateTraversalPathDAOImpl extends AbstractDAO<StateTraversalPath> implements StateTraversalPathDAO {

    @Inject
    public StateTraversalPathDAOImpl(@Named("fluxSessionFactoriesContext") SessionFactoryContext sessionFactoryContext) {
        super(sessionFactoryContext);
    }

    @Override
    @Transactional
    @SelectDataSource(type = DataSourceType.READ_WRITE, storage = Storage.SHARDED)
    public StateTraversalPath create(String StateMachineInstanceId, StateTraversalPath stateTraversalPath) {
        return super.save(stateTraversalPath);
    }

    @Override
    public StateTraversalPath findById(String stateMachineId, Long stateId) {
        return null;
    }

    @Override
    public List findByIdAndStateMachineId(String stateMachineId) {
        return null;
    }
}
