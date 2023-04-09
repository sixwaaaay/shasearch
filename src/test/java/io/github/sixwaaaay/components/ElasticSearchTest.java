/*
 * Copyright (c) 2023 sixwaaaay.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.sixwaaaay.components;

import static org.junit.jupiter.api.Assertions.assertTrue;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import io.quarkus.test.junit.QuarkusTest;
import java.io.IOException;
import javax.inject.Inject;
import org.junit.jupiter.api.Test;

@QuarkusTest
class ElasticSearchTest {
  @Inject ElasticsearchClient client;

  @Test
  void testConn() throws IOException {
    var ping = client.ping();
    assertTrue(ping.value());
  }
}
