/**
 * Copyright 2018 The original authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
**/

package io.ap4k.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.InputStream;
import java.util.Map;

import org.junit.jupiter.api.Test;

class MapsTest {

  @Test
  public void testMapFromProperties() throws Exception {
    try (InputStream is = MapsTest.class.getClassLoader().getResourceAsStream("simple.properties")) {
      Map<String, Object> map = Maps.fromProperties(is);
      assertNotNull(map);
      Map kubernetes = (Map) map.get("kubernetes");
      assertNotNull(kubernetes);
      assertTrue(kubernetes.containsKey("group"));
      assertTrue(kubernetes.containsKey("name"));
      assertTrue(kubernetes.containsKey("version"));
      assertTrue(kubernetes.containsKey("labels"));
      assertTrue(kubernetes.containsKey("labels"));
      Object labels = kubernetes.get("labels");
      assertTrue(labels instanceof Map);
      assertEquals("bar", (String) ((Map)labels).get("foo"));
    }
  }
}
