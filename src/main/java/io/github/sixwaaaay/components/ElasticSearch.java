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

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.elasticsearch.client.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

/**
 * ElasticSearch is a component that provides a ElasticsearchClient instance.
 */
@ApplicationScoped
public class ElasticSearch {
    @Produces
    public ElasticsearchClient wrap(RestClient restClient) {
        // Create the transport with a Jackson mapper
        var mapper = new JacksonJsonpMapper();
        var transport = new RestClientTransport(restClient, mapper);
        return new ElasticsearchClient(transport);
    }
}
