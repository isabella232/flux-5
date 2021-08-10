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

package com.flipkart.flux.examples.concurrent;

import java.util.Random;

import javax.inject.Singleton;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.flipkart.flux.client.model.Task;

/**
 * Used to dispatch emails
 */
@Singleton
public class EmailDispatcher {

    private static Logger logger = LogManager.getLogger(EmailDispatcher.class);
    private Random random;

    public EmailDispatcher() {
        random = new Random();
    }

    @Task(version = 1, timeout = 1000l, retries = 2)
    public EmailAcknowledgement sendEmail(Email email) {
        System.out.println("[EmailMarketingWorkflow] Sending email " + email);
        return new EmailAcknowledgement(random.nextBoolean());
    }
}
