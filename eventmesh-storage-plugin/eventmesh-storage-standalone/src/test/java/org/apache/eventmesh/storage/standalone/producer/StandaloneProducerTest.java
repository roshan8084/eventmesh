/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.eventmesh.storage.standalone.producer;

import org.apache.eventmesh.api.SendResult;
import org.apache.eventmesh.storage.standalone.TestUtils;

import java.util.Properties;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import io.cloudevents.CloudEvent;

public class StandaloneProducerTest {

    private StandaloneProducer standaloneProducer;

    @Before
    public void setUp() {
        standaloneProducer = new StandaloneProducer(new Properties());
    }

    @Test
    public void testIsStarted() {
        Assert.assertFalse(standaloneProducer.isStarted());
    }

    @Test
    public void testIsClosed() {
        Assert.assertTrue(standaloneProducer.isClosed());
    }

    @Test
    public void testStart() {
        standaloneProducer.start();
        Assert.assertTrue(standaloneProducer.isStarted());
    }

    @Test
    public void testShutdown() {
        standaloneProducer.shutdown();
        Assert.assertTrue(standaloneProducer.isClosed());
    }

    @Test
    public void testPublish() {
        CloudEvent cloudEvent = TestUtils.createDefaultCloudEvent();
        SendResult sendResult = standaloneProducer.publish(cloudEvent);
        Assert.assertNotNull(sendResult);
    }
}
