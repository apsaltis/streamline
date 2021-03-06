/**
  * Copyright 2017 Hortonworks.
  *
  * Licensed under the Apache License, Version 2.0 (the "License");
  * you may not use this file except in compliance with the License.
  * You may obtain a copy of the License at

  *   http://www.apache.org/licenses/LICENSE-2.0

  * Unless required by applicable law or agreed to in writing, software
  * distributed under the License is distributed on an "AS IS" BASIS,
  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  * See the License for the specific language governing permissions and
  * limitations under the License.
 **/

package com.hortonworks.streamline.streams.runtime.splitjoin;

import com.hortonworks.streamline.streams.StreamlineEvent;
import com.hortonworks.streamline.streams.common.StreamlineEventImpl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Default implementation of {@link Joiner}
 *
 */
public class DefaultJoiner implements Joiner {

    public DefaultJoiner() {
    }

    @Override
    public StreamlineEvent join(EventGroup eventGroup) {
        Map<String, Object> fieldValues = new HashMap<>();
        Map<String, Object> auxiliaryFieldValues = new HashMap<>();
        for (StreamlineEvent subEvent : eventGroup.getSplitEvents()) {
            if(subEvent.getAuxiliaryFieldsAndValues() != null) {
                auxiliaryFieldValues.putAll(subEvent.getAuxiliaryFieldsAndValues());
            }
            fieldValues.putAll(subEvent);
        }

        return StreamlineEventImpl.builder()
                .fieldsAndValues(fieldValues)
                .dataSourceId(eventGroup.getDataSourceId())
                .auxiliaryFieldsAndValues(auxiliaryFieldValues)
                .build();
    }
}
