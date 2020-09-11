package com.mediatek.accessor.meta.data;

import com.baidu.p020ar.util.SystemInfoUtil;
import java.util.ArrayList;

public class DataItem {
    public static final int DEST_TYPE_EXTENDED_XMP = 1;
    public static final int DEST_TYPE_STANDARD_XMP = 0;

    public static class ArrayItem {
        public String arrayName;
        public int dest;
        public int index;
        public NameSpaceItem nameSpaceItem;
        public String value;
    }

    public static class BufferItem {
        public int dest;
        public String name;
        public NameSpaceItem nameSpaceItem;
        public byte[] value;
    }

    public static class DataCollections {
        public int dest;
        public ArrayList<ArrayItem> listOfArrayItem;
        public ArrayList<BufferItem> listOfBufferItem;
        public ArrayList<BufferItem> listOfCustomDataItem;
        public ArrayList<SimpleItem> listOfSimpleValue;
        public ArrayList<StructItem> listOfStructItem;
    }

    public static class SimpleItem {
        public int dest;
        public String name;
        public NameSpaceItem nameSpaceItem;
        public String value;
    }

    public static class NameSpaceItem {
        public int dest;
        public String nameSpace;
        public String nameSpacePrifix;

        public String toString() {
            return this.nameSpace + SystemInfoUtil.COLON + this.nameSpacePrifix;
        }
    }

    public static class StructItem {
        public int dest;
        public String fieldName;
        public NameSpaceItem fieldNameSpaceItem;
        public String fieldValue;
        public String structName;
        public NameSpaceItem structNameSpaceItem;

        public String toString() {
            return this.structNameSpaceItem + "|" + this.fieldNameSpaceItem + ", structName: " + this.structName + ", fieldName: " + this.fieldName + ", fieldValue: " + this.fieldValue;
        }
    }

    public static class Rect {
        public int bottom;
        public int left;
        public int right;
        public int top;

        public Rect(int i, int i2, int i3, int i4) {
            this.left = i;
            this.top = i2;
            this.right = i3;
            this.bottom = i4;
        }
    }
}
