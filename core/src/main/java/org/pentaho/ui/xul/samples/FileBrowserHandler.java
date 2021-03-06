/*!
 * This program is free software; you can redistribute it and/or modify it under the
 * terms of the GNU Lesser General Public License, version 2.1 as published by the Free Software
 * Foundation.
 *
 * You should have received a copy of the GNU Lesser General Public License along with this
 * program; if not, you can obtain a copy at http://www.gnu.org/licenses/old-licenses/lgpl-2.1.html
 * or from the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * Copyright (c) 2002-2017 Hitachi Vantara..  All rights reserved.
 */

package org.pentaho.ui.xul.samples;

import org.pentaho.ui.xul.XulException;
import org.pentaho.ui.xul.components.XulFileDialog;
import org.pentaho.ui.xul.components.XulFileDialog.RETURN_CODE;
import org.pentaho.ui.xul.components.XulTextbox;
import org.pentaho.ui.xul.impl.AbstractXulEventHandler;

import java.io.File;

public class FileBrowserHandler extends AbstractXulEventHandler {
  public void showSave() {
    try {
      XulTextbox filename = (XulTextbox) document.getElementById( "fileName" );

      XulFileDialog dialog = (XulFileDialog) document.createElement( "filedialog" );
      RETURN_CODE retval = dialog.showSaveDialog();
      if ( retval == RETURN_CODE.OK ) {
        File file = (File) dialog.getFile();
        filename.setValue( file.getName() );
      }

    } catch ( XulException e ) {
      System.out.println( "Error creating file dialog" );
    }

  }
}
