/*
 * JBoss, Home of Professional Open Source
 * Copyright 2011 Red Hat Inc. and/or its affiliates and other contributors
 * as indicated by the @authors tag. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
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
package org.jboss.arquillian.showcase.extension.systemproperties;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * SystemPropertiesIntegrationTestCase
 *
 * @author <a href="mailto:aslak@redhat.com">Aslak Knutsen</a>
 * @version $Revision: $
 */
@RunWith(Arquillian.class)
public abstract class SystemPropertiesIntegrationTestBase
{
   public static String propertyName = "ARQ_TEST";
   public static String propertyValue = "ALL_OK";
   
   public static WebArchive createDeployment()
   {
      return ShrinkWrap.create(WebArchive.class)
             .addClass(SystemPropertiesIntegrationTestBase.class);
   }
   
   @Test
   public void shouldBeAbleToReadProperty()
   {
      Object property = System.getProperty(propertyName);
      
      Assert.assertNotNull("Verify property was found", property);
      Assert.assertEquals("Verify property was set correctly", property.toString(), propertyValue);
   }
}