/*
 * Copyright © 2014 - 2018 Leipzig University (Database Research Group)
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
 */
package org.gradoop.flink.algorithms.gelly.functions;

import org.apache.flink.api.java.functions.FunctionAnnotation;
import org.gradoop.common.model.impl.id.GradoopId;
import org.gradoop.common.model.impl.pojo.Vertex;

/**
 * Maps EPGM vertex to a Gelly vertex with the {@link GradoopId} as its id and value.
 */
@FunctionAnnotation.ForwardedFields("id->f0;id->f1")
public class VertexToGellyVertexWithGradoopId implements VertexToGellyVertex<GradoopId> {
  /**
   * Reduce object instantiations
   */
  private final org.apache.flink.graph.Vertex<GradoopId, GradoopId> reuseVertex;

  /**
   * Constructor.
   */
  public VertexToGellyVertexWithGradoopId() {
    reuseVertex = new org.apache.flink.graph.Vertex<>();
  }

  @Override
  public org.apache.flink.graph.Vertex<GradoopId, GradoopId> map(Vertex epgmVertex) {
    GradoopId id = epgmVertex.getId();
    reuseVertex.setId(id);
    reuseVertex.setValue(id);
    return reuseVertex;
  }
}
