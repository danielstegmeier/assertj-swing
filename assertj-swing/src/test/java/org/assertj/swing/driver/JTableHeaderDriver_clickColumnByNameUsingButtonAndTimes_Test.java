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

import static org.assertj.core.util.Lists.newArrayList;
import static org.assertj.swing.core.MouseButton.LEFT_BUTTON;

import java.util.Collection;

import org.assertj.swing.test.recorder.ClickRecorder;
import org.assertj.swing.test.recorder.ClickRecorderManager;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Tests for {@link JTableHeaderDriver#clickColumn(javax.swing.table.JTableHeader, String)}.
 * 
 * @author Yvonne Wang
 */
@RunWith(Parameterized.class)
public class JTableHeaderDriver_clickColumnByNameUsingButtonAndTimes_Test extends JTableHeaderDriver_TestCase {
  @Rule
  public ClickRecorderManager clickRecorder = new ClickRecorderManager();

  private final String name;
  private final int index;

  @Parameters
  public static Collection<Object[]> indices() {
    return newArrayList(columnIndices());
  }

  public JTableHeaderDriver_clickColumnByNameUsingButtonAndTimes_Test(int index) {
    name = columnNameFromIndex(index);
    this.index = index;
  }

  @Test
  public void should_Click_Column() {
    showWindow();
    ClickRecorder recorder = clickRecorder.attachDirectlyTo(tableHeader);
    driver.clickColumn(tableHeader, name, LEFT_BUTTON, 3);
    recorder.wasClickedWith(LEFT_BUTTON).timesClicked(3);
    assertThatColumnWasClicked(recorder, index);
  }
}
