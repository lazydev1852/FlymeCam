package com.meizu.media.cameraAlgorithm.zbar;

import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SymbolIterator implements Iterator<Symbol> {
    public static ChangeQuickRedirect changeQuickRedirect;
    private Symbol current;

    SymbolIterator(Symbol symbol) {
        this.current = symbol;
    }

    public boolean hasNext() {
        return this.current != null;
    }

    public Symbol next() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 8993, new Class[0], Symbol.class);
        if (proxy.isSupported) {
            return (Symbol) proxy.result;
        }
        if (this.current != null) {
            Symbol symbol = this.current;
            long next = this.current.next();
            if (next != 0) {
                this.current = new Symbol(next);
            } else {
                this.current = null;
            }
            return symbol;
        }
        throw new NoSuchElementException("access past end of SymbolIterator");
    }

    public void remove() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 8994, new Class[0], Void.TYPE).isSupported) {
            throw new UnsupportedOperationException("SymbolIterator is immutable");
        }
    }
}
