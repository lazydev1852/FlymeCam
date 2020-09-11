package com.google.zxing.oned.rss.expanded.decoders;

import com.baidu.p020ar.msghandler.ComponentMessageType;
import com.google.zxing.common.BitArray;

public final class AI01320xDecoder extends AI013x0xDecoder {
    /* access modifiers changed from: protected */
    public int checkWeight(int i) {
        return i < 10000 ? i : i - ComponentMessageType.MSG_TYPE_ON_SHAKE;
    }

    AI01320xDecoder(BitArray bitArray) {
        super(bitArray);
    }

    /* access modifiers changed from: protected */
    public void addWeightCode(StringBuilder sb, int i) {
        if (i < 10000) {
            sb.append("(3202)");
        } else {
            sb.append("(3203)");
        }
    }
}
