/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hortonworks.iotas.layout.design.component;

import java.util.Set;

/**
 * A source component
 */
public interface Source extends Component {
    /**
     * Set of declared output streams of a Source. A source can have
     * more than one output stream.
     *
     * @return the set of output streams.
     */
    Set<Stream> getDeclaredOutputStreams();

    /**
     * Returns the output Stream of this source corresponding to the given streamId.
     *
     * @throws IllegalArgumentException if the stream with the given streamId does not exist
     */
    Stream getStream(String streamId);
}
