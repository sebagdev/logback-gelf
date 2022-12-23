/*
 * Logback GELF - zero dependencies Logback GELF appender library.
 * Copyright (C) 2019 Oliver Siegmar
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */

package de.siegmar.logbackgelf;

import java.util.function.Supplier;

import de.siegmar.logbackgelf.compressor.Compressor;
import de.siegmar.logbackgelf.compressor.GZIPCompressor;
import de.siegmar.logbackgelf.compressor.ZLIBCompressor;

public enum CompressionMethod {

    NONE(() -> new Compressor() { }),
    ZLIB(ZLIBCompressor::new),
    GZIP(GZIPCompressor::new);

    private final Supplier<Compressor> compressor;

    CompressionMethod(final Supplier<Compressor> compressor) {
        this.compressor = compressor;
    }

    public Compressor getCompressor() {
        return compressor.get();
    }

}
