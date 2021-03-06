/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2012-2018 the original author or authors.
 */
package org.assertj.swing.driver;

import org.junit.Test;

/**
 * Tests for {@link JTableDriver#requireNoSelection(javax.swing.JTable)}.
 * 
 * @author Alex Ruiz
 * @author Yvonne Wang
 */
public class JTableDriver_requireNoSelection_Test extends JTableDriver_TestCase {
  @Test
  public void should_Pass_If_JTable_Does_Not_Have_Selection() {
    clearSelection();
    driver.requireNoSelection(table);
  }

  @Test
  public void should_Fail_If_JTable_Has_Have_Selection() {
    selectCell(0, 0);
    thrown.expectAssertionError("property:'selection'");
    thrown.expectMessageToContain("expected no selection but was:<rows=[0], columns=[0]>");
    driver.requireNoSelection(table);
  }
}
