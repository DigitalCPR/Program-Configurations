// Copyright 2017 The Nomulus Authors. All Rights Reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package google.registry.tools.params;

import google.registry.util.TypeUtils.TypeInstantiator;

/** Base class for Enum-based parameters.
 *
 * <p>This is not necessary for single-value Enum parameters (i.e. arity = 1) as JCommander natively
 * supports them, but is necessary for variable-arity ({@code List&lt;Enum&gt;}) parameters.
 */
public abstract class EnumParameter<T extends Enum<T>> extends ParameterConverterValidator<T> {

  @Override
  public T convert(String value) {
    return Enum.valueOf(new TypeInstantiator<T>(getClass()){}.getExactType(), value);
  }
}
