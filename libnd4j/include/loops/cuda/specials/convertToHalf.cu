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

//
// @author raver119@gmail.com
// @author Yurii Shyrma, created on 15.11.2018
//

#include <loops/special_kernels.h>

////////////////////////////////////////////////////////////////////////
template <typename T>
__device__ void convertToHalf(void *dx, Nd4jLong n, half *dz) {
    
    auto x = reinterpret_cast<T*>(dx);
    int tid = threadIdx.x + blockIdx.x * gridDim.x;

    for (Nd4jLong i = tid; i < n; i += blockDim.x * gridDim.x )
        dz[i] = __float2half(static_cast<T>(x[i]));
}

////////////////////////////////////////////////////////////////////////
template <typename T>
__global__ void execConvertToHalf(void *dx, Nd4jLong n, half *dz) {

	convertToHalf<T>(dx, n, dz);
}

////////////////////////////////////////////////////////////////////////
template <typename T>
__host__ void convertToHalfGeneric(dim3& launchDims, Nd4jPointer* extraPointers, void *dx, Nd4jLong n, half *dz) {

	cudaStream_t *stream = reinterpret_cast<cudaStream_t *>(&extraPointers[1]);
	
	execConvertToHalf<T><<<launchDims.x, launchDims.y, launchDims.z, stream>>>(dx, n, dz);
}