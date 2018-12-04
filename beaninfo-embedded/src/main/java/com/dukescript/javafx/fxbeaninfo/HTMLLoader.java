
/*-
 * #%L
 * DukeScript JavaFX Extensions - a library from the "DukeScript" project.
 * %%
 * Copyright (C) 2018 Dukehoff GmbH
 * %%
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * #L%
 */
package com.dukescript.javafx.fxbeaninfo;

import com.dukescript.api.javafx.beans.FXBeanInfo;
import com.dukescript.presenters.jxbrowser.JXBrowserPresenter;
import java.net.URL;
import javafx.scene.Node;
import javafx.scene.web.WebView;
import net.java.html.json.Models;

/**
 *
 * @author antonepple
 */
public class HTMLLoader {

    public static Node load(URL html, final FXBeanInfo.Provider viewModel) {
        JXBrowserPresenter presenter = JXBrowserPresenter.create(Node.class);

        final Node browser = presenter.getComponent(Node.class);

        presenter.displayPage(html,  new Runnable() {
            @Override
            public void run() {
                Models.applyBindings(viewModel);
            }
        });
        return browser;
    }
}
