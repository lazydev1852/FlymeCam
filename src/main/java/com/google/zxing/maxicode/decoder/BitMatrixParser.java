package com.google.zxing.maxicode.decoder;

import androidx.core.app.FrameMetricsAggregator;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.alibaba.fastjson.asm.Opcodes;
import com.arcsoft.livebroadcast.ArcSpotlightFaceAlignment;
import com.arcsoft.livebroadcast.ArcSpotlightOffscreen;
import com.baidu.p020ar.arplay.core.message.ARPMessageType;
import com.baidu.p020ar.audio.AudioParams;
import com.baidu.p020ar.util.MsgConstants;
import com.google.zxing.common.BitMatrix;
import com.meizu.camera.MeizuCamera;

public final class BitMatrixParser {
    private static final int[][] BITNR;
    private final BitMatrix bitMatrix;

    static {
        int[] iArr = new int[30];
        iArr[0] = 481;
        iArr[1] = 480;
        iArr[2] = 475;
        iArr[3] = 474;
        iArr[4] = 469;
        iArr[5] = 468;
        iArr[6] = 48;
        iArr[7] = -2;
        iArr[8] = 30;
        iArr[9] = -3;
        iArr[10] = -3;
        iArr[11] = -3;
        iArr[12] = -3;
        iArr[13] = -3;
        iArr[14] = -3;
        iArr[15] = -3;
        iArr[16] = -3;
        iArr[17] = -3;
        iArr[18] = -3;
        iArr[20] = 53;
        iArr[21] = 52;
        iArr[22] = 463;
        iArr[23] = 462;
        iArr[24] = 457;
        iArr[25] = 456;
        iArr[26] = 451;
        iArr[27] = 450;
        iArr[28] = 837;
        iArr[29] = -3;
        BITNR = new int[][]{new int[]{121, 120, 127, Opcodes.IAND, 133, 132, 139, 138, 145, 144, Opcodes.DCMPL, 150, 157, 156, Opcodes.IF_ICMPGT, Opcodes.IF_ICMPGE, Opcodes.RET, 168, 175, 174, Opcodes.PUTFIELD, 180, Opcodes.NEW, 186, Opcodes.INSTANCEOF, Opcodes.CHECKCAST, Opcodes.IFNONNULL, Opcodes.IFNULL, -2, -2}, new int[]{123, ArcSpotlightFaceAlignment.ASL_OUTLINE_POINT_COUNT, 129, 128, 135, 134, 141, 140, 147, 146, Opcodes.IFEQ, 152, Opcodes.IF_ICMPEQ, Opcodes.IFLE, Opcodes.IF_ACMPEQ, 164, 171, 170, Opcodes.RETURN, Opcodes.ARETURN, Opcodes.INVOKESPECIAL, Opcodes.INVOKEVIRTUAL, 189, 188, 195, 194, 201, ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION, 816, -3}, new int[]{125, 124, 131, 130, 137, 136, 143, 142, Opcodes.FCMPL, Opcodes.LCMP, 155, Opcodes.IFNE, Opcodes.IF_ICMPLT, Opcodes.IF_ICMPNE, Opcodes.GOTO, Opcodes.IF_ACMPNE, 173, 172, 179, Opcodes.GETSTATIC, Opcodes.INVOKEINTERFACE, Opcodes.INVOKESTATIC, 191, 190, 197, 196, MeizuCamera.TEMPERATURE_CLOSE_FLASH_NOTIFY, 202, 818, 817}, new int[]{283, 282, 277, 276, 271, 270, 265, 264, 259, 258, 253, 252, 247, 246, 241, 240, 235, 234, 229, 228, 223, 222, 217, 216, 211, 210, MeizuCamera.TEMPERATURE_CLOSE_CAMERA_NOTIFY, MeizuCamera.TEMPERATURE_CLOSE_RECORD_NOTIFY, 819, -3}, new int[]{285, 284, 279, 278, 273, 272, 267, 266, 261, 260, 255, 254, 249, 248, 243, 242, 237, 236, 231, 230, 225, 224, 219, 218, 213, 212, 207, 206, 821, 820}, new int[]{287, 286, 281, 280, 275, 274, 269, 268, 263, 262, 257, 256, 251, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 245, 244, 239, 238, 233, 232, 227, 226, 221, 220, 215, 214, 209, 208, 822, -3}, new int[]{289, 288, 295, 294, 301, 300, MsgConstants.TRACK_MODEL_NOT_SHOWING, 306, MsgConstants.TRACK_IMU_OPEN, MsgConstants.TRACK_MODEL_CAN_DISAPPEARING, MsgConstants.TRACK_CLOSE_TRACK_ALGO, MsgConstants.TRACK_OPEN_TRACK_ALGO, 325, 324, 331, 330, 337, 336, 343, 342, 349, 348, 355, 354, 361, 360, 367, 366, 824, 823}, new int[]{291, 290, 297, 296, ARPMessageType.MSG_TYPE_IMU_CLOSE, 302, MsgConstants.TRACK_HIDE_LOST_INFO, 308, MsgConstants.TRACK_SHOW_RECG_NOTSANNER, MsgConstants.TRACK_SHOW_CAPTURE, 321, 320, 327, 326, 333, 332, 339, 338, 345, 344, 351, 350, 357, 356, 363, 362, 369, 368, 825, -3}, new int[]{293, 292, 299, 298, ARPMessageType.MSG_TYPE_IMU_RESET_LOCATION, ARPMessageType.MSG_TYPE_IMU_CLOSE_RES, 311, MsgConstants.TRACK_MSG_ID_TRACK_LOST, MsgConstants.TRACK_CLOSE_RECG_NOTSANNER, MsgConstants.TRACK_HIDE_RECG_NOTSANNER, 323, 322, 329, 328, 335, 334, 341, 340, 347, 346, 353, 352, 359, 358, 365, 364, 371, 370, 827, 826}, new int[]{409, 408, 403, 402, 397, 396, 391, 390, 79, 78, -2, -2, 13, 12, 37, 36, 2, -1, 44, 43, 109, 108, 385, 384, 379, 378, 373, 372, 828, -3}, new int[]{411, 410, 405, 404, 399, 398, 393, 392, 81, 80, 40, -2, 15, 14, 39, 38, 3, -1, -1, 45, 111, 110, 387, 386, 381, 380, 375, 374, 830, 829}, new int[]{413, 412, 407, 406, 401, 400, 395, 394, 83, 82, 41, -3, -3, -3, -3, -3, 5, 4, 47, 46, 113, 112, 389, 388, 383, 382, 377, 376, 831, -3}, new int[]{415, 414, 421, 420, 427, 426, 103, 102, 55, 54, 16, -3, -3, -3, -3, -3, -3, -3, 20, 19, 85, 84, 433, 432, 439, 438, 445, 444, 833, 832}, new int[]{417, 416, 423, 422, 429, 428, 105, 104, 57, 56, -3, -3, -3, -3, -3, -3, -3, -3, 22, 21, 87, 86, 435, 434, 441, 440, 447, 446, 834, -3}, new int[]{419, 418, 425, 424, 431, 430, 107, 106, 59, 58, -3, -3, -3, -3, -3, -3, -3, -3, -3, 23, 89, 88, 437, 436, 443, 442, 449, 448, 836, 835}, iArr, new int[]{483, 482, 477, 476, 471, 470, 49, -1, -2, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, -2, -1, 465, 464, 459, 458, 453, 452, 839, 838}, new int[]{485, 484, 479, 478, 473, 472, 51, 50, 31, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, 1, -2, 42, 467, 466, 461, 460, 455, 454, 840, -3}, new int[]{487, 486, 493, 492, 499, 498, 97, 96, 61, 60, -3, -3, -3, -3, -3, -3, -3, -3, -3, 26, 91, 90, 505, 504, FrameMetricsAggregator.EVERY_DURATION, MsgConstants.SLAM_MSG_ID_TRACK_LOST, 517, 516, 842, 841}, new int[]{489, 488, 495, 494, MsgConstants.SLAM_MSG_ID_MODEL_LOADED, 500, 99, 98, 63, 62, -3, -3, -3, -3, -3, -3, -3, -3, 28, 27, 93, 92, MsgConstants.SLAM_MODEL_NOT_SHOWING, MsgConstants.SLAM_MODEL_SHOWING, InputDeviceCompat.SOURCE_DPAD, 512, 519, 518, 843, -3}, new int[]{491, 490, 497, 496, 503, 502, 101, 100, 65, 64, 17, -3, -3, -3, -3, -3, -3, -3, 18, 29, 95, 94, 509, 508, 515, 514, 521, 520, 845, 844}, new int[]{559, 558, 553, 552, 547, 546, 541, 540, 73, 72, 32, -3, -3, -3, -3, -3, -3, 10, 67, 66, 115, 114, 535, 534, 529, 528, 523, 522, 846, -3}, new int[]{561, 560, 555, 554, 549, 548, 543, 542, 75, 74, -2, -1, 7, 6, 35, 34, 11, -2, 69, 68, 117, 116, 537, 536, 531, 530, MsgConstants.SLAM_START_FROM_LUA, MsgConstants.SLAM_GESTURE_INTERACTION, 848, 847}, new int[]{563, 562, 557, 556, 551, 550, 545, 544, 77, 76, -2, 33, 9, 8, 25, 24, -1, -2, 71, 70, 119, 118, 539, 538, 533, 532, 527, 526, 849, -3}, new int[]{565, 564, 571, 570, 577, 576, 583, 582, 589, 588, 595, 594, 601, 600, 607, 606, 613, 612, 619, 618, 625, 624, 631, 630, 637, 636, 643, 642, 851, 850}, new int[]{567, 566, 573, 572, 579, 578, 585, 584, 591, 590, 597, 596, 603, 602, 609, 608, 615, 614, 621, 620, 627, 626, 633, 632, 639, 638, 645, 644, 852, -3}, new int[]{569, 568, 575, 574, 581, 580, 587, 586, 593, 592, 599, 598, 605, 604, 611, 610, 617, 616, 623, 622, 629, 628, 635, 634, 641, AudioParams.DEFAULT_FRAME_SIZE, 647, 646, 854, 853}, new int[]{727, 726, 721, 720, 715, 714, 709, 708, 703, 702, 697, 696, 691, 690, 685, 684, 679, 678, 673, 672, 667, 666, 661, 660, 655, 654, 649, 648, 855, -3}, new int[]{729, 728, 723, 722, 717, 716, 711, 710, 705, 704, 699, 698, 693, 692, 687, 686, 681, 680, 675, 674, 669, 668, 663, 662, 657, 656, 651, 650, 857, 856}, new int[]{731, 730, 725, 724, 719, 718, 713, 712, 707, 706, 701, MsgConstants.TRACK_CLOSE_CLOUD_RECOGNITION, 695, 694, 689, 688, 683, 682, 677, 676, 671, 670, 665, 664, 659, 658, 653, 652, 858, -3}, new int[]{733, 732, 739, 738, 745, 744, 751, 750, 757, 756, 763, 762, 769, 768, 775, 774, 781, 780, 787, 786, 793, 792, 799, 798, 805, MsgConstants.IMU_MODEL_SHOWING, 811, 810, 860, 859}, new int[]{735, 734, 741, 740, 747, 746, 753, 752, 759, 758, 765, 764, 771, ArcSpotlightOffscreen.ASVL_PAF_RGB32_B8G8R8A8, 777, 776, 783, 782, 789, 788, 795, 794, MsgConstants.IMU_MSG_ID_MODEL_LOADED, 800, 807, 806, 813, 812, 861, -3}, new int[]{737, 736, 743, 742, 749, 748, 755, 754, 761, 760, 767, 766, ArcSpotlightOffscreen.ASVL_PAF_RGB32_R8G8B8A8, 772, 779, 778, 785, 784, 791, 790, 797, 796, 803, 802, MsgConstants.IMU_MODEL_CAN_DISAPPEARING, 808, 815, 814, 863, 862}};
    }

    BitMatrixParser(BitMatrix bitMatrix2) {
        this.bitMatrix = bitMatrix2;
    }

    /* access modifiers changed from: package-private */
    public byte[] readCodewords() {
        byte[] bArr = new byte[144];
        int height = this.bitMatrix.getHeight();
        int width = this.bitMatrix.getWidth();
        for (int i = 0; i < height; i++) {
            int[] iArr = BITNR[i];
            for (int i2 = 0; i2 < width; i2++) {
                int i3 = iArr[i2];
                if (i3 >= 0 && this.bitMatrix.get(i2, i)) {
                    int i4 = i3 / 6;
                    bArr[i4] = (byte) (((byte) (1 << (5 - (i3 % 6)))) | bArr[i4]);
                }
            }
        }
        return bArr;
    }
}
