/*
 * Created on Apr 19, 2010
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 *
 * Copyright @2010 the original author or authors.
 */
package org.fest.keyboard.mapping;

import static org.fest.swing.finder.WindowFinder.findDialog;
import static org.fest.swing.util.Platform.isMacintosh;

import org.fest.swing.annotation.GUITest;
import org.fest.swing.fixture.DialogFixture;
import org.junit.Test;

/**
 * Tests for <code>{@link MainFrame}</code> that verify that the "About" dialog is launched.
 *
 * @author Yvonne Wang
 * @author Alex Ruiz
 */
@GUITest
public class MainFrame_showAboutDialog_Test extends MainFrame_TestCase {

  @Test
  public void should_show_About_dialog() {
    if (isMacintosh()) return; // need to find menu in Mac's menu bar
    frame.menuItemWithPath("Help", "About").click();
    DialogFixture about = findDialog(AboutDialog.class).using(robot);
    about.button().click(); // close "About" dialog
  }
}
