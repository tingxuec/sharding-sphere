/*
 * Copyright 2016-2018 shardingsphere.io.
 * <p>
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
 * </p>
 */

package io.shardingsphere.dbtest.cases.assertion.dcl;

import io.shardingsphere.dbtest.cases.assertion.root.IntegrateTestCaseAssertion;
import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * JAXB definition of DCL integrate test case assertion.
 *
 * @author panjuan
 */
@Getter
public final class DCLIntegrateTestCaseAssertion extends IntegrateTestCaseAssertion {
    
    @XmlAttribute(name = "init-sqls")
    private String initSQLs;
    
    @XmlAttribute(name = "clean-sqls")
    private String cleanSQLs;
    
    @XmlAttribute(name = "db-types")
    private String dbTypes;
    
}
