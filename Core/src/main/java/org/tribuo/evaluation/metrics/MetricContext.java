/*
 * Copyright (c) 2015-2020, Oracle and/or its affiliates. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.tribuo.evaluation.metrics;

import org.tribuo.Model;
import org.tribuo.Output;
import org.tribuo.Prediction;

import java.util.Collections;
import java.util.List;

/**
 * The context for a metric or set of metrics. At minimum the model used to generate
 * the predictions, and the predictions themselves.
 */
public abstract class MetricContext<T extends Output<T>> {

    private final Model<T> model;
    private final List<Prediction<T>> predictions;

    protected MetricContext(Model<T> model, List<Prediction<T>> predictions) {
        this.model = model;
        this.predictions = Collections.unmodifiableList(predictions);
    }

    /**
     * Gets the model used by this context.
     * @return The model.
     */
    public Model<T> getModel() {
        return model;
    }

    /**
     * Gets the predictions used by this context.
     * @return The predictions.
     */
    public List<Prediction<T>> getPredictions() {
        return predictions;
    }
}
