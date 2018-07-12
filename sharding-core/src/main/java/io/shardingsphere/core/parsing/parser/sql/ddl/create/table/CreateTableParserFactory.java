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

package io.shardingsphere.core.parsing.parser.sql.ddl.create.table;

import io.shardingsphere.core.constant.DatabaseType;
import io.shardingsphere.core.parsing.lexer.LexerEngine;
import io.shardingsphere.core.parsing.parser.dialect.mysql.sql.MySQLCreateTableParser;
import io.shardingsphere.core.parsing.parser.dialect.oracle.sql.OracleCreateTableParser;
import io.shardingsphere.core.parsing.parser.dialect.postgresql.sql.PostgreSQLCreateTableParser;
import io.shardingsphere.core.parsing.parser.dialect.sqlserver.sql.SQLServerCreateTableParser;
import io.shardingsphere.core.rule.ShardingRule;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Create parser factory.
 *
 * @author zhangliang
 * @author panjuan
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CreateTableParserFactory {
    
    /**
     * Create create parser instance.
     *
     * @param dbType database type
     * @param shardingRule databases and tables sharding rule
     * @param lexerEngine lexical analysis engine.
     * @return create parser instance
     */
    public static AbstractCreateTableParser newInstance(final DatabaseType dbType, final ShardingRule shardingRule, final LexerEngine lexerEngine) {
        switch (dbType) {
            case H2:
            case MySQL:
                return new MySQLCreateTableParser(shardingRule, lexerEngine);
            case Oracle:
                return new OracleCreateTableParser(shardingRule, lexerEngine);
            case SQLServer:
                return new SQLServerCreateTableParser(shardingRule, lexerEngine);
            case PostgreSQL:
                return new PostgreSQLCreateTableParser(shardingRule, lexerEngine);
            default:
                throw new UnsupportedOperationException(String.format("Cannot support database [%s].", dbType));
        }
    }
}