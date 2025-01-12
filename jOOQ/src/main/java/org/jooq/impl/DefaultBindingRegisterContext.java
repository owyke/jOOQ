/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Other licenses:
 * -----------------------------------------------------------------------------
 * Commercial licenses for this work are available. These replace the above
 * ASL 2.0 and offer limited warranties, support, maintenance, and commercial
 * database integrations.
 *
 * For more information, please visit: http://www.jooq.org/licenses
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
package org.jooq.impl;

import java.sql.CallableStatement;

import org.jooq.BindingRegisterContext;
import org.jooq.Converter;
import org.jooq.ExecuteContext;

/**
 * @author Lukas Eder
 */
class DefaultBindingRegisterContext<U> extends AbstractExecuteScope implements BindingRegisterContext<U> {

    private final CallableStatement statement;
    private final int               index;

    DefaultBindingRegisterContext(ExecuteContext ctx, CallableStatement statement, int index) {
        super(ctx);

        this.statement = statement;
        this.index = index;
    }

    @Override
    public final CallableStatement statement() {
        return statement;
    }

    @Override
    public final int index() {
        return index;
    }

    @Override
    public final <T> BindingRegisterContext<T> convert(Converter<? super T, ? extends U> converter) {
        return new DefaultBindingRegisterContext<>(ctx, statement, index);
    }

    @Override
    public String toString() {
        return "DefaultBindingRegisterContext [index=" + index + "]";
    }
}
