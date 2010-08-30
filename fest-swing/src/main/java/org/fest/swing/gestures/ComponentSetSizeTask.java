/*
 * Created on Feb 23, 2008
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
 * Copyright @2008-2010 the original author or authors.
 */
package org.fest.swing.gestures;

import static org.fest.swing.edt.GuiActionRunner.execute;

import java.awt.Component;

import org.fest.swing.annotation.RunsInEDT;
import org.fest.swing.edt.GuiTask;

/**
 * Sets the size of a <code>{@link Component}</code>.
 *
 * @author Alex Ruiz
 *
 * @since 1.3
 */
final class ComponentSetSizeTask {

  @RunsInEDT
  static void setComponentSize(final Component c, final int width, final int height) {
    execute(new GuiTask() {
      @Override protected void executeInEDT() {
        c.setSize(width, height);
      }
    });
  }

  private ComponentSetSizeTask() {}
}