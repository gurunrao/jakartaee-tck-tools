/*
 * $Id$
 *
 * Copyright 1996-2009 Sun Microsystems, Inc.  All Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Sun designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Sun in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Sun Microsystems, Inc., 4150 Network Circle, Santa Clara,
 * CA 95054 USA or visit www.sun.com if you need additional information or
 * have any questions.
 */

package com.sun.tdk.signaturetest.plugin;

import com.sun.tdk.signaturetest.sigfile.F41Format;
import com.sun.tdk.signaturetest.sigfile.Reader;
import com.sun.tdk.signaturetest.sigfile.Writer;

/**
 * @author Mikhail Ershov
 */
public class FormatAdapter extends F41Format {
    private String signature;
    protected Reader reader;
    protected Writer writer;

    public FormatAdapter(String signature) {
        this.signature = signature;
        init();
    }

    public String getVersion() {
        return signature;
    }

    public Reader getReader() {
        return reader;
    }

    public Writer getWriter() {
        return writer;
    }

    public void setReader(Reader r) {
        reader = r;
    }

    public void setWriter(Writer w) {
        writer = w;
    }

    protected void init() {
        reader = new ReaderAdapter(this);
        writer = new WriterAdapter(this);
    }

    // extend access level from protected to public
    public void addSupportedFeature(Feature feature) {
        super.addSupportedFeature(feature);
    }

    // extend access level from protected to public
    public void removeSupportedFeature(Feature feature) {
        super.removeSupportedFeature(feature);
    }

}
