/*
 * Copyright 1999-2101 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.druid.sql.ast;

import com.alibaba.druid.sql.visitor.SQLASTVisitor;

public class SQLSubPartition extends SQLObjectImpl {

    protected SQLName           name;

    protected SQLPartitionValue values;

    public SQLName getName() {
        return name;
    }

    public void setName(SQLName name) {
        if (name != null) {
            name.setParent(this);
        }
        this.name = name;
    }
    
    public SQLPartitionValue getValues() {
        return values;
    }

    public void setValues(SQLPartitionValue values) {
        if (values != null) {
            values.setParent(this);
        }
        this.values = values;
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            acceptChild(visitor, name);
            acceptChild(visitor, values);
        }
        visitor.endVisit(this);
    }

}
