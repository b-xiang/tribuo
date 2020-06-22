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

package org.tribuo.test;

import com.oracle.labs.mlrg.olcut.provenance.Provenance;
import org.tribuo.ImmutableOutputInfo;
import org.tribuo.MutableOutputInfo;
import org.tribuo.OutputFactory;
import org.tribuo.evaluation.Evaluation;
import org.tribuo.evaluation.Evaluator;
import org.tribuo.provenance.OutputFactoryProvenance;

import java.util.Map;

/**
 * An OutputFactory for use in tests, very similar to LabelFactory.
 */
public class MockOutputFactory implements OutputFactory<MockOutput> {

    public static final MockOutput UNKNOWN_TEST_OUTPUT = new MockOutput("UNKNOWN");

    @Override
    public <V> MockOutput generateOutput(V label) {
        return new MockOutput(label.toString());
    }

    @Override
    public MockOutput getUnknownOutput() {
        return UNKNOWN_TEST_OUTPUT;
    }

    @Override
    public MutableOutputInfo<MockOutput> generateInfo() {
        return new MockOutputInfo();
    }

    @Override
    public ImmutableOutputInfo<MockOutput> constructInfoForExternalModel(Map<MockOutput, Integer> mapping) {
        throw new UnsupportedOperationException("constructInfoForExternalModel not implemented");
    }

    @Override
    public Evaluator<MockOutput, ? extends Evaluation<MockOutput>> getEvaluator() {
        throw new UnsupportedOperationException("generateEvaluator not implemented");
    }

    @Override
    public int hashCode() {
        return "MockOutputFactory".hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof MockOutputFactory;
    }

    @Override
    public OutputFactoryProvenance getProvenance() {
        return new TestOutputFactoryProvenance();
    }

    public static class TestOutputFactoryProvenance implements OutputFactoryProvenance {
        private static final long serialVersionUID = 1L;

        TestOutputFactoryProvenance() {}

        public TestOutputFactoryProvenance(Map<String, Provenance> map) { }

        @Override
        public String getClassName() {
            return MockOutputFactory.class.getName();
        }
        @Override
        public String toString() {
            return generateString("MockOutputFactory");
        }

        @Override
        public boolean equals(Object other) {
            return other instanceof TestOutputFactoryProvenance;
        }

        @Override
        public int hashCode() {
            return 31;
        }
    }
}
