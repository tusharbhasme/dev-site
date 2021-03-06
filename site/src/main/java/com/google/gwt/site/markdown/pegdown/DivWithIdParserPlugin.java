/**
 * Copyright 2015 ArcBees Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.gwt.site.markdown.pegdown;

import org.parboiled.Action;
import org.parboiled.Context;
import org.parboiled.Rule;
import org.pegdown.plugins.BlockPluginParser;

public class DivWithIdParserPlugin extends CommonParser<Object> implements BlockPluginParser {
    private final Action createDivAction = new Action() {
        @Override
        public boolean run(Context context) {
            String id = match();

            return push(new DivWithIdNode(id));
        }
    };

    @Override
    public Rule[] blockPluginRules() {
        return toRules(
                Sequence("$[",
                        Id(),
                        createDivAction,
                        "]"));
    }
}
