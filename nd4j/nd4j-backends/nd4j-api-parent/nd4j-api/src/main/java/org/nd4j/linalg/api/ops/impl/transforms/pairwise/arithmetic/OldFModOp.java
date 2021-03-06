/*******************************************************************************
 * Copyright (c) 2015-2018 Skymind, Inc.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Apache License, Version 2.0 which is available at
 * https://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 ******************************************************************************/

package org.nd4j.linalg.api.ops.impl.transforms.pairwise.arithmetic;

import org.nd4j.autodiff.samediff.SDVariable;
import org.nd4j.autodiff.samediff.SameDiff;
import org.nd4j.imports.NoOpNameFoundException;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.api.ops.BaseTransformAnyOp;
import org.nd4j.linalg.api.ops.BaseTransformOp;
import org.nd4j.linalg.api.ops.BaseTransformSameOp;

import java.util.List;

/**
 * Floating point remainder
 *
 * @author raver119@gmail.com
 */
public class OldFModOp extends BaseTransformAnyOp {
    public OldFModOp(SameDiff sameDiff, SDVariable i_v1, SDVariable i_v2) {
        super(sameDiff, i_v1, i_v2);
    }

    public OldFModOp(SameDiff sameDiff, SDVariable i_v1, SDVariable i_v2, boolean inPlace) {
        super(sameDiff, i_v1, i_v2, inPlace);
    }

    public OldFModOp(SameDiff sameDiff) {
        super(sameDiff);
    }

    public OldFModOp(SameDiff sameDiff, SDVariable i_v1, SDVariable i_v2, Object[] extraArgs) {
        super(sameDiff, i_v1, i_v2, extraArgs);
    }

    public OldFModOp(SameDiff sameDiff, SDVariable i_v, boolean inPlace) {
        super(sameDiff, i_v, inPlace);
    }

    public OldFModOp(SameDiff sameDiff, SDVariable i_v, int[] shape, boolean inPlace, Object[] extraArgs) {
        super(sameDiff, i_v, shape, inPlace, extraArgs);
    }

    public OldFModOp(SameDiff sameDiff, SDVariable i_v, Object[] extraArgs) {
        super(sameDiff, i_v, extraArgs);
    }

    public OldFModOp() {}

    public OldFModOp(INDArray x, INDArray y, INDArray z, long n) {
        super(x, y, z, n);
    }

    public OldFModOp(INDArray x) {
        super(x);
    }

    public OldFModOp(INDArray x, INDArray z) {
        super(x, z);
    }

    public OldFModOp(INDArray x, INDArray z, long n) {
        super(x, z, n);
    }

    public OldFModOp(INDArray x, INDArray y, INDArray z) {
        super(x, y, z, x.lengthLong());
    }

    @Override
    public int opNum() {
        return 15;
    }

    @Override
    public String opName() {
        return "oldfmod";
    }

    @Override
    public String onnxName() {
        throw new NoOpNameFoundException("No onnx op opName found for " +  opName());
    }

    @Override
    public String tensorflowName() {
        throw new NoOpNameFoundException("No tensorflow op opName found for " +  opName());
    }


    @Override
    public void init(INDArray x, INDArray y, INDArray z, long n) {
        super.init(x, y, z, n);
        if (y == null)
            throw new IllegalArgumentException("No components to divide");
    }

    @Override
    public List<SDVariable> doDiff(List<SDVariable> f1) {
        return null;
    }
}
